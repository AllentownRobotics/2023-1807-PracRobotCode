package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CompressorAndPistons extends SubsystemBase {

    Compressor compressor;
    DoubleSolenoid collectorPistons;

    public CompressorAndPistons() {
        
        Compressor compressor = new Compressor(Constants.compressorModuleID, PneumaticsModuleType.CTREPCM);
        compressor.enabled();

        collectorPistons = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);
    }

    public void ExtendPistons() {
        collectorPistons.toggle();
    }

}
