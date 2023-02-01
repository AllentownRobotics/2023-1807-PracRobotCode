// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.CollectorCommand;
import frc.robot.commands.CompressorCommand;
import frc.robot.commands.DrivetrainCommand;
import frc.robot.commands.IndexerCommand;
import frc.robot.commands.PistonCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.StopButtonCommand;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Pistons;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Compress;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static XboxController xboxController;
  public static Drivetrain drivetrain = new Drivetrain();
  public static Indexer indexer = new Indexer();
  public static Shooter shooter = new Shooter();
  public static Pistons pistons = new Pistons();
  public static Collector collector = new Collector();
  public static Compress compress = new Compress();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    drivetrain.setDefaultCommand(new DrivetrainCommand(1.0));
    compress.setDefaultCommand(new CompressorCommand());
    xboxController = new XboxController(Constants.robotContainerXboxController);
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(xboxController, XboxController.Button.kY.value).whenHeld(new IndexerCommand());
    new JoystickButton(xboxController, XboxController.Button.kLeftBumper.value).whenHeld
    (new DrivetrainCommand(Constants.drivetrainPrecisionMultiplier));
    new JoystickButton(xboxController, XboxController.Button.kB.value).whenHeld(new CollectorCommand());
    new JoystickButton(xboxController, XboxController.Button.kA.value).whenHeld(new StopButtonCommand());
    new JoystickButton(xboxController, XboxController.Button.kX.value).whenHeld(new PistonCommand());
    new JoystickButton(xboxController, XboxController.Button.kLeftStick.value).whenHeld(new ShooterCommand());
  }


}
