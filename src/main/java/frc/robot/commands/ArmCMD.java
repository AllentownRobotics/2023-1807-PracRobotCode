package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ArmCMD extends CommandBase {
    
    public ArmCMD() {
        addRequirements(RobotContainer.armSystem);
    }

    @Override
    public void initialize() {}

    
    @Override
    public void execute() {
        RobotContainer.armSystem.armExtended();
    }

    @Override
    public void end(boolean interrupted) {
        RobotContainer.armSystem.armRetracted();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
