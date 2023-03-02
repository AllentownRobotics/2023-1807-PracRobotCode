// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Arm.ArmSubStationInTake;
import frc.robot.commands.Arm.ResetArm;
import frc.robot.commands.Arm.LowLevelCommands.ManualSetPointControl;
import frc.robot.commands.Arm.NodeCommands.HighNode;
import frc.robot.commands.Arm.NodeCommands.MidNode;
import frc.robot.commands.Claw.LowLevelCommands.ToggleClaw;
import frc.robot.commands.Claw.LowLevelCommands.ToggleWrist;
import frc.robot.commands.Compressor.Compress;
import frc.robot.commands.Spindexer.AutoSpindex;
import frc.robot.commands.Spindexer.LowLevelCommands.RunAtSpeed;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Cmprsr;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Spindexer;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private final CommandXboxController operatorController = new CommandXboxController(OperatorConstants.OPERATOR_CONTROLLER_PORT);
  private final CommandXboxController driverController = new CommandXboxController(OperatorConstants.DRIVER_CONTROLLER_PORT);

  public final Claw claw = new Claw();
  public final Arm arm = new Arm(claw);
  final Cmprsr compressor = new Cmprsr();
  final Spindexer spindexer = new Spindexer();
  final DriveSubsystem drivetrain = new DriveSubsystem();
  final Limelight limelight = new Limelight();

  SlewRateLimiter strafe = new SlewRateLimiter(5);
  SlewRateLimiter translate = new SlewRateLimiter(5);
  boolean fieldOriented = true;

  Trigger wristFlipTrigger = new Trigger(arm::isWristAllowedOut);
  //Trigger armManualControl = new Trigger(() -> Math.abs(operatorController.getLeftY()) >= 0.15);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    compressor.setDefaultCommand(new Compress(compressor));

    drivetrain.setDefaultCommand(
      new RunCommand(
            () -> drivetrain.drive(
                translate.calculate(MathUtil.applyDeadband(-driverController.getLeftY(), 0.3)),
                strafe.calculate(MathUtil.applyDeadband(-driverController.getLeftX(), 0.3)),
                MathUtil.applyDeadband(driverController.getRightX(), 0.3),
                fieldOriented),
            drivetrain));  

    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    /*
        DRIVER
    */

    driverController.rightBumper().whileTrue(new RunCommand(() -> drivetrain.setX(), drivetrain));
    driverController.leftBumper().onTrue(new InstantCommand(() -> fieldOriented = !fieldOriented));
    driverController.start().onTrue(new InstantCommand(() -> drivetrain.zeroHeading()));

    /*
        OPERATOR
    */
    // HIGH PLACEMENT
    operatorController.povUp().onTrue(new HighNode(arm, claw, operatorController));
    // MID PLACEMENT
    operatorController.povLeft().onTrue(new MidNode(arm, claw, operatorController));
    // ARM RESET
    operatorController.povDown().onTrue(new ResetArm(this));
    // MANUAL CONTROL
    //armManualControl.whileTrue(new ManualSetPointControl(arm, operatorController));
    // INTAKE POSITION
    operatorController.rightBumper().onTrue(new ArmSubStationInTake(this)).onFalse(new ResetArm(this));

    // AUTO WRIST
    wristFlipTrigger.onTrue(Commands.runOnce(() -> claw.setManualWristControlAllowed(true))).whileFalse(
                                            Commands.runOnce(() -> claw.setManualWristControlAllowed(false)));

    // CLAW TOGGLE
    operatorController.x().onTrue(new ToggleClaw(claw));

    operatorController.b().onTrue(new ToggleWrist(claw));

    // SPINDEXER FORWARD
    operatorController.rightTrigger(OperatorConstants.OPERATOR_CONTROLLER_THRESHOLD_SPINDEXER).whileTrue(
                                                                    new RunAtSpeed(spindexer, 1.0, operatorController));
    // SPINDEXER REVERSE
    operatorController.leftTrigger(OperatorConstants.OPERATOR_CONTROLLER_THRESHOLD_SPINDEXER).whileTrue(
                                                                    new RunAtSpeed(spindexer, -1.0, operatorController));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
  }
}