package frc.robot.commands.Climb;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Climb;

public class climbACTIVE extends CommandBase {

    public climbACTIVE() {
        addRequirements(RobotContainer.climbSystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        Climb.weAreClimbing();
    }

    @Override
    public void end(boolean interrupted) {
        Climb.noClimbing();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
