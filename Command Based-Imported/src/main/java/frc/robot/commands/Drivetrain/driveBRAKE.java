package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

//declaring a new brake drive
public class driveBRAKE extends CommandBase {
    
    public driveBRAKE() {
        addRequirements(RobotContainer.drivetrain);
    }

//starting the command
    @Override
    public void initialize() {}

//executing
    @Override
    public void execute() {
        RobotContainer.drivetrain.Brake(true);
    }
//called when the command ends/is interrupted
    @Override
    public void end(boolean interrupted) {
        RobotContainer.drivetrain.Brake(false);
    }

//returns true when the command has to end
    @Override
    public boolean isFinished() {
        return false;
    }
}
