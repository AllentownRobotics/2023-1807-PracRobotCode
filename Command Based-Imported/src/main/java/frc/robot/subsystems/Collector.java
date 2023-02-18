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

    static WPI_TalonFX collectorMotor;
    static DoubleSolenoid extendPiston;

    boolean extended;

public Collector() {
    collectorMotor = new WPI_TalonFX(Constants.CO_MOTOR);

    collectorMotor.setNeutralMode(NeutralMode.Coast);

    extendPiston = new DoubleSolenoid(Constants.CO_EXTEND_PISTON_ID, PneumaticsModuleType.REVPH, Constants.CO_EXTEND_PISTON_FORWARD, Constants.CO_EXTEND_PISTON_REVERSE);
}

public static void Activate(boolean dump){
    extendPiston.set(Value.kForward);

    if(!dump){
        collectorMotor.set(ControlMode.PercentOutput, Constants.CO_MOTOR_SPEED);
    }else{
        collectorMotor.set(ControlMode.PercentOutput, -Constants.CO_MOTOR_SPEED);
    }

}

public static void Retract() {
    extendPiston.set(Value.kReverse);
    collectorMotor.set(ControlMode.PercentOutput, 0);

}

@Override
public void periodic() {}


}