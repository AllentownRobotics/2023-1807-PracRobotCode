package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class IndexerCommand extends CommandBase {
    public void execute() {
        if (RobotContainer.xboxController.getYButton()) {
            RobotContainer.indexer.Index();
        }
    }
}
