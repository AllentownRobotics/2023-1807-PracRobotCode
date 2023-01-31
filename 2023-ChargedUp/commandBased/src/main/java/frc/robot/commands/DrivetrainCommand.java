// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DrivetrainCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   * @return 
   */
  public void DriveCommand() {    
    // Use addRequirements() here to declare subsystem dependencies.

    addRequirements(RobotContainer.drivetrain);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double moveSpeed = RobotContainer.xboxController.getLeftY();
    double rotateSpeed = RobotContainer.xboxController.getRightX();
    boolean stopButton = RobotContainer.xboxController.getAButton();
    // brake button
    if (RobotContainer.xboxController.getXButton()) {
      Drivetrain.frontRight.setNeutralMode(NeutralMode.Brake);
      Drivetrain.centerRight.setNeutralMode(NeutralMode.Brake);
      Drivetrain.backRight.setNeutralMode(NeutralMode.Brake);
      Drivetrain.frontLeft.setNeutralMode(NeutralMode.Brake);
      Drivetrain.centerLeft.setNeutralMode(NeutralMode.Brake);
      Drivetrain.backLeft.setNeutralMode(NeutralMode.Brake);
    // precision mode for small movements 
    if (RobotContainer.xboxController.getLeftBumper()) {
      RobotContainer.drivetrain.CurvatureDrive
      (moveSpeed * Constants.drivetrainPrecisionMultiplier, 
      rotateSpeed * Constants.drivetrainPrecisionMultiplier,
      stopButton);

    } else {

    RobotContainer.drivetrain.CurvatureDrive(moveSpeed, rotateSpeed, stopButton);

    }
  }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
