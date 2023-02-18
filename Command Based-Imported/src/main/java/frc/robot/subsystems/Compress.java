package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Compress extends SubsystemBase {
    
    static Compressor compressor;


    public Compress(int cmid, PneumaticsModuleType revph) {
    }

    public Compress() {
        compressor = new Compressor(Constants.CMID, PneumaticsModuleType.REVPH);
    }
    
    public static void Activate() {
        compressor.enableAnalog(Constants.CM_RANGE_MIN, Constants.CM_RANGE_MAX);
    }

    @Override
    public void periodic() {}

}
