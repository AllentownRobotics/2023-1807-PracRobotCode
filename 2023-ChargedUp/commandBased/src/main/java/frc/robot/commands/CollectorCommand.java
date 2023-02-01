package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Collector;

public class CollectorCommand extends CommandBase {

    public void CollectComand() {
        addRequirements(RobotContainer.collector);
    }
    public void execute() {
            RobotContainer.collector.Collect();
    }
    @Override
  public void end(boolean interrupted) {
    Collector.collectorMotor.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
