// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SwerveControllerCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Lockdown;
import frc.robot.commands.SwerveDrive;
import frc.robot.subsystems.Drivetrain;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  public boolean fieldRelative;
  public boolean locked;

  XboxController driverController = new XboxController(0);

  Drivetrain drivetrain = new Drivetrain();


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
  drivetrain.setDefaultCommand(new SwerveDrive(drivetrain, driverController));    

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Field relative toggle
    new JoystickButton(driverController, XboxController.Button.kLeftBumper.value).onTrue(
      new RunCommand(() -> drivetrain.toggleFieldRelative(), drivetrain)
    );

    // Lock button
    new JoystickButton(driverController, XboxController.Button.kB.value).whileTrue(new Lockdown(drivetrain));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand(Trajectory autoTrajectory) {
    ProfiledPIDController rotationController = new ProfiledPIDController(Constants.AUTO_ROTATIONPID_Kp, 0, 0, Constants.AUTO_ROTATIONPID_CONSTRAINT);
    rotationController.enableContinuousInput(-Math.PI, Math.PI);

    SwerveControllerCommand autoCommand = new SwerveControllerCommand(
      autoTrajectory,
      drivetrain::getPose,
      Constants.CHASSIS_KINEMATICS,
      new PIDController(1, 0, 0), 
      new PIDController(1, 0, 0), 
      rotationController,
      drivetrain::setAllModuleStates,
      drivetrain);

    return autoCommand;
  }
}
