// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.ArmConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Enums.ClawState;
import frc.robot.Enums.WristState;
import frc.robot.commands.Arm.WaitForPlace;
import frc.robot.commands.Arm.AutoPlace;
import frc.robot.commands.Arm.ResetArm;
import frc.robot.commands.Arm.LowLevelCommands.ManualSetPointControl;
import frc.robot.commands.Arm.LowLevelCommands.SetArmAngle;
import frc.robot.commands.Claw.LowLevelCommands.SetClawState;
import frc.robot.commands.Claw.LowLevelCommands.SetWristState;
import frc.robot.commands.Claw.LowLevelCommands.ToggleClaw;
import frc.robot.commands.Claw.LowLevelCommands.ToggleWrist;
import frc.robot.commands.Compressor.Compress;
import frc.robot.commands.Spindexer.AutoSpindex;
import frc.robot.commands.Spindexer.LowLevelCommands.RunAtSpeed;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Cmprsr;
import frc.robot.subsystems.Spindexer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
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

  public final Claw claw = new Claw();
  public final Arm arm = new Arm(claw);
  final Cmprsr compressor = new Cmprsr();
  final Spindexer spindexer = new Spindexer();

  Trigger wristFlipTrigger = new Trigger(arm::isWristAllowedOut);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    compressor.setDefaultCommand(new Compress(compressor));

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
    // HIGH PLACEMENT
    operatorController.povUp().onTrue(new WaitForPlace(arm, 
                                                new SetArmAngle(arm, ArmConstants.ANGLE_CONE_HIGH, ArmConstants.ANGLE_CUBE_HIGH), 
                                                operatorController));
    // MID PLACEMENT
    operatorController.povLeft().onTrue(new WaitForPlace(arm, 
                                                new SetArmAngle(arm, ArmConstants.ANGLE_CONE_MID, ArmConstants.ANGLE_CUBE_MID),
                                                operatorController));
    // ARM RESET
    operatorController.povDown().onTrue(new ResetArm(this));
    // MANUAL CONTROL
    operatorController.axisLessThan(1, -0.15).whileTrue(new ManualSetPointControl(arm, operatorController));

    // INTAKE POSITION
    operatorController.back().onTrue(new SetArmAngle(arm, 35.0));

    // AUTO WRIST
    wristFlipTrigger.onTrue(Commands.runOnce(() -> claw.setManualWristControlAllowed(true), claw));
    wristFlipTrigger.whileFalse(new SetWristState(claw, WristState.WristDown).andThen(
                            Commands.runOnce(() -> claw.setManualWristControlAllowed(false))));

    // CLAW TOGGLE
    operatorController.x().onTrue(new ToggleClaw(claw));

    operatorController.b().onTrue(new ToggleWrist(claw));

    // SPINDEXER FORWARD
    operatorController.rightTrigger(OperatorConstants.OPERATOR_CONTROLLER_THRESHOLD_SPINDEXER).whileTrue(new RunAtSpeed(spindexer, 1.0, operatorController));
    // SPINDEXER REVERSE
    operatorController.leftTrigger(OperatorConstants.OPERATOR_CONTROLLER_THRESHOLD_SPINDEXER).whileTrue(new RunAtSpeed(spindexer, -1.0, operatorController));
    // AUTO SPINDEX
    operatorController.rightBumper().onTrue(new AutoSpindex(spindexer));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    /*SequentialCommandGroup auto = new SequentialCommandGroup(
              new SetWristState(claw, WristState.WristOut),
              new SetClawState(claw, ClawState.Closed),
              new AutoPlace(arm, claw, ArmConstants.ANGLE_CONE_HIGH),
              new PrintCommand("Placed"),
              new ResetArm(this),
              new PrintCommand("Reset"),
              new WaitCommand(0.25));*/

    return new SetArmAngle(arm, 180.0);
    //return new AutoSpindex(spindexer);
  }
}