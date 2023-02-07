package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class PistonCommand extends CommandBase {

    public void CompressCommand() {
        addRequirements(RobotContainer.pistons);
    }
    public void execute() {
            RobotContainer.pistons.ExtendPistons();
    }
    @Override
  public void end(boolean interrupted) {
      RobotContainer.pistons.ExtendPistons(); // this is intentional
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
