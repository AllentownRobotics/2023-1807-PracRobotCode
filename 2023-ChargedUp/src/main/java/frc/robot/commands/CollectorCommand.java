package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class CollectorCommand extends CommandBase {
    public void execute() {
        if (RobotContainer.xboxController.getBButton()) {
            RobotContainer.collector.Collect();
        }
    }
}
