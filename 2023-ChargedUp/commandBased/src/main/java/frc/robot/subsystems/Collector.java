package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Collector extends SubsystemBase {

    WPI_TalonFX collectorMotor;

    public Collector() {
        WPI_TalonFX collectorMotor = new WPI_TalonFX(Constants.collectorMotorID);
        collectorMotor.setNeutralMode(NeutralMode.Coast);
    }
    public void Collect() {
        collectorMotor.set(Constants.collectorMotorSpeed);
    }
}
