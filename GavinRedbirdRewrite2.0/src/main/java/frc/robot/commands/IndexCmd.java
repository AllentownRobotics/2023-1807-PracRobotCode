// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Indexer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class IndexCmd extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public IndexCmd() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.indexsubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("BOTTOM SENSOR", Indexer.indexUltrasonic1.getRangeInches());
    SmartDashboard.putNumber("TOP SENSOR", Indexer.indexUltrasonic2.getRangeInches());
    if(Indexer.indexUltrasonic1.getRangeInches()<7 || Indexer.indexUltrasonic1.getRangeInches() > 20)
    {
      RobotContainer.indexsubsystem.index(1);
    }
    else
    {
      RobotContainer.indexsubsystem.index(0);
    }
    if(Indexer.indexUltrasonic2.getRangeInches()<7 || Indexer.indexUltrasonic2.getRangeInches()>20)
    {
      RobotContainer.indexsubsystem.index(1);

    }
    else
    {
      RobotContainer.indexsubsystem.index(0);
    }
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
