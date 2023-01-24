// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class CurvatureDriveCommand extends CommandBase {
  private double xSpeed;
  private boolean allowTurnInPlace;
  private double yRotation;

  /** Creates a new CurvatureDriveCommand. */
  public CurvatureDriveCommand(double xSpeed, double yRotation, boolean allowTurnInPlace) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.xSpeed = xSpeed;

    this.yRotation = yRotation;

    this.allowTurnInPlace = allowTurnInPlace;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
        RobotContainer.m_DrivetrainSubsystem.drive.curvatureDrive(xSpeed, yRotation, allowTurnInPlace);

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
