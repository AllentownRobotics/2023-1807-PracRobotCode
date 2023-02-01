package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Collector extends SubsystemBase {

    public static WPI_TalonFX collectorMotor;

    public Collector() {
        collectorMotor = new WPI_TalonFX(Constants.collectorMotorID);
        collectorMotor.setNeutralMode(NeutralMode.Coast);
    }
    public void Collect() {
        collectorMotor.set(Constants.collectorMotorSpeed);
    }
}
