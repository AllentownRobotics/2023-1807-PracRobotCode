package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Compress;

public class CompressorCommand extends CommandBase {
    public CompressorCommand() {
        addRequirements(RobotContainer.compress);
    }
    public void execute() {
        Compress.runCompressor();
    }
    @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
