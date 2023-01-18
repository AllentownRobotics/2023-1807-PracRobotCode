// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.BrakeCmd;
import frc.robot.commands.CollectCmd;
import frc.robot.commands.CompressCmd;
import frc.robot.commands.DriveCmd;
import frc.robot.commands.FlyWheelCmd;
import frc.robot.commands.IdleCmd;
import frc.robot.commands.IndexCmd;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Compress;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.FlyWheel;
import frc.robot.subsystems.Indexer;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static FlyWheel flywheelsubsystem;
  public static XboxController controller;
  public static FlyWheelCmd flywheelcommand;
  public static DriveTrain drivetrainsubsystem;
  public static Indexer indexsubsystem;
  public static DriveCmd drivecommand;
  public static Compress compresssubsystem;
  public static Collector collectsubsystem;

  private JoystickButton flyButton;
  private JoystickButton brakeButton;
  private JoystickButton collectButton;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    controller = new XboxController(Constants.controllerport);

    flywheelsubsystem = new FlyWheel();
    drivetrainsubsystem = new DriveTrain();
    indexsubsystem = new Indexer();
    compresssubsystem = new Compress();
    collectsubsystem = new Collector();
    // Configure the button bindings
    flywheelsubsystem.setDefaultCommand(new IdleCmd());
    drivetrainsubsystem.setDefaultCommand(new DriveCmd());
    compresssubsystem.setDefaultCommand(new CompressCmd());
    collectsubsystem.setDefaultCommand(new CollectCmd());
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    Trigger bottomSensorTrigger = new Trigger(() -> Indexer.sensorBottom());
    bottomSensorTrigger.whenActive(new IndexCmd());
    Trigger topSensorTrigger = new Trigger(() -> Indexer.sensorTop());
    topSensorTrigger.whenActive(new IndexCmd());


    flyButton = new JoystickButton(controller, XboxController.Button.kA.value);
    flyButton.whileHeld(new FlyWheelCmd());
    brakeButton = new JoystickButton(controller, XboxController.Button.kB.value);
    brakeButton.whileHeld(new BrakeCmd());
    collectButton = new JoystickButton(controller, XboxController.Button.kY.value);
    collectButton.whileHeld(new CollectCmd());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
