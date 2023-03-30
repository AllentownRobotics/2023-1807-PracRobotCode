// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Wrist;

public class CollectUp extends InstantCommand {
  private Wrist wrist;
  /** Creates a new CollectDown. */
  public CollectUp(Wrist wrist) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.wrist = wrist;
    addRequirements(wrist);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    wrist.setPistons(Value.kReverse);
    wrist.setAngle(10);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
