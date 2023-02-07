package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Indexer;

public class IndexerCommand extends CommandBase {
    public void IndexCommand() {
        addRequirements(RobotContainer.indexer);
    }
    public void execute() {
            RobotContainer.indexer.Index();
    }
    @Override
  public void end(boolean interrupted) {
      Indexer.feederMotor.set(0);
      Indexer.indexerMotor.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
