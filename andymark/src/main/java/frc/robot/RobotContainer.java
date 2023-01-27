// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.CollectCmd;
import frc.robot.commands.DriveCMD;
import frc.robot.commands.IndexCmd;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Indexer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static DriveTrain drivetrainsubsystem;
  public static Indexer indexsubsystem;
  public static Collector collectsubsystem;
  private JoystickButton indexButton;
  private JoystickButton collectButton;

  // Replace with CommandPS4Controller or CommandJoystick if needed
  public static XboxController controller;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    controller = new XboxController(OperatorConstants.kDriverControllerPort);
    // Configure the trigger bindings
    drivetrainsubsystem = new DriveTrain();
    indexsubsystem = new Indexer();
    drivetrainsubsystem.setDefaultCommand(new DriveCMD());
    indexsubsystem.setDefaultCommand(new IndexCmd(0));
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
    Trigger beamBreakTrigger = new Trigger(() -> Indexer.getBeamBreak());
    indexButton = new JoystickButton(controller, XboxController.Button.kX.value);
    indexButton.and(beamBreakTrigger).whileTrue(new IndexCmd(0.05));

    collectButton = new JoystickButton(controller, XboxController.Button.kA.value);
    collectButton.whileHeld(new CollectCmd(.5));

    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
