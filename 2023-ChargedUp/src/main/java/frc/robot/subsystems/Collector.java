package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Collector extends SubsystemBase {

    WPI_TalonFX collectorMotor;
    DoubleSolenoid extendPiston;

    boolean extended;

public Collector() {
    collectorMotor = new WPI_TalonFX(Constants.COmotor);

    collectorMotor.setNeutralMode(NeutralMode.Coast);

    extendPiston = new DoubleSolenoid(Constants.COextendPistonID, PneumaticsModuleType.REVPH, Constants.COextendPistonForward, Constants.COextendPistonReverse);
}

public void activation(boolean dump){
    extendPiston.set(Value.kForward);

    if(!dump){
        collectorMotor.set(ControlMode.PercentOutput, Constants.COmotorSpeed);
    }else{
        collectorMotor.set(ControlMode.PercentOutput, -Constants.COmotorSpeed);
    }
}

public void retraction() {
    extendPiston.set(Value.kReverse);
    collectorMotor.set(ControlMode.PercentOutput, 0);
}

@Override
public void periodic() {

}

}