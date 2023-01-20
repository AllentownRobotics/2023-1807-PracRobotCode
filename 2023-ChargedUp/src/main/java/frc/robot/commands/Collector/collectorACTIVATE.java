package frc.robot.commands.Collector;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
/*import frc.robot.commands.Collector.Collector_ACTIVATE;
import frc.robot.subsystems.Collector;*/


public class collectorACTIVATE extends CommandBase {
    boolean dump;

    public collectorACTIVATE(boolean dump) {
        addRequirements(RobotContainer.collectorSystem);

        this.dump = dump;
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        RobotContainer.activation(dump);
}

    @Override
    public void end(boolean interrupted) {
        RobotContainer.retraction();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}