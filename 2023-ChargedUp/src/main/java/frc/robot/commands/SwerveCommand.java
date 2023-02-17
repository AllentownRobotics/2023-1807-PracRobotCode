// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class SwerveCommand extends CommandBase {
  
  /** Creates a new SwerveCommand. */
  public SwerveCommand() {
    addRequirements(RobotContainer.drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.drivetrain.drivetrain(
      MathUtil.applyDeadband(RobotContainer.m_driverController.getLeftX(), 0.05), 

      MathUtil.applyDeadband(RobotContainer.m_driverController.getLeftY(), 0.05), 
      
      MathUtil.applyDeadband(RobotContainer.m_driverController.getRightX(), 0.05));
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
