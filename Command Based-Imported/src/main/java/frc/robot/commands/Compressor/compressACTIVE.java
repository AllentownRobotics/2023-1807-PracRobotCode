package frc.robot.commands.Compressor;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Compress;

public class compressACTIVE extends CommandBase {
    
    public compressACTIVE() {
        addRequirements(RobotContainer.compressorSystem);
    }


    private void addRequirements(Compressor compressorSystem) {
    }


    @Override
    public void initialize() {}

    @Override
    public void execute() {
        Compress.Activate();
    }

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return false;
    }
}
