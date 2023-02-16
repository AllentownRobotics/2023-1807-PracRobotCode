// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Claw;

public class ClawCommand extends CommandBase {
  int commandNumber;
  /** Creates a new ClawCommand. */
  public ClawCommand(int commandNumber) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.commandNumber = commandNumber;
    addRequirements(RobotContainer.claw);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (commandNumber == 0) {
      Claw.toggleClaw();
    } else if (commandNumber == 1) {
      Claw.toggleClawExtension();
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
 
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
