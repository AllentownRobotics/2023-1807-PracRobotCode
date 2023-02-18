package frc.robot.commands.Indexer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;


public class indexerACTIVATE extends CommandBase {
    
    public indexerACTIVATE() {
        addRequirements(RobotContainer.indexerSystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        RobotContainer.indexerSystem.indexing();
    }

    @Override
    public void end(boolean interrupted) {
        RobotContainer.indexerSystem.terminating();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    }