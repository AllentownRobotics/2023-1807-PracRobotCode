package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class PistonCommand extends CommandBase {

    public PistonCommand() {
        addRequirements(RobotContainer.pistons);
    }

    public void initialize() {
      RobotContainer.pistons.TogglePistons();
    }
    public void execute() {
      
    }
    @Override
  public void end(boolean interrupted) {
      RobotContainer.pistons.TogglePistons(); // this is intentional
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
