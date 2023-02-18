package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;


public class shooterACTIVE extends CommandBase {
    
    public shooterACTIVE() {
        addRequirements(RobotContainer.shooterSystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        int POV = RobotContainer.operatorController.getPOV();

        int targetRPM = RobotContainer.shooterSystem.lookupRPM();

        boolean hood = RobotContainer.shooterSystem.checkhood(POV);

        RobotContainer.shooterSystem.Shoot(targetRPM, hood);
    }

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return false;
    }
}
