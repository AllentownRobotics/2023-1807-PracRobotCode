package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pistons extends SubsystemBase {

    Compressor compressor;
    DoubleSolenoid collectorPistons;

    public Pistons() {

        collectorPistons = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);

    }

    public void ExtendPistons() {
        collectorPistons.toggle();
    }

}
