package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Compress extends SubsystemBase {
        static Compressor compressor;
    public Compress() {
        compressor = new Compressor(Constants.compressorModuleID, PneumaticsModuleType.REVPH);
    }
    public static void runCompressor() {
        compressor.enableAnalog(60, 120);
    }
}
