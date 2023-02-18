package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterWithHood extends SubsystemBase {
    
    WPI_TalonFX masterMotor;
    WPI_TalonFX followerMotor;

    DoubleSolenoid hoodPiston;

    public ShooterWithHood() {
        hoodPiston = new DoubleSolenoid(Constants.SH_HOOD_PISTON_ID, PneumaticsModuleType.REVPH, Constants.SH_HOOD_PISTON_FORWARD, Constants.SH_HOOD_PISTON_BACKWARD);

        masterMotor = new WPI_TalonFX(Constants.SH_MOTOR_MASTER_ID);
        followerMotor = new WPI_TalonFX(Constants.SH_MOTOR_FOLLOW_ID);

        masterMotor.config_kP(0, Constants.SHkP);
        masterMotor.config_kI(0, Constants.SHkI);
        masterMotor.config_kD(0, Constants.SHkD);
        masterMotor.config_kF(0, Constants.SHkF);

        followerMotor.follow(masterMotor);
        masterMotor.setInverted(true);
    }

    public void Shoot(int rpm, boolean hoodUp) {
        if(hoodUp) {
            hoodPiston.set(Value.kForward);
        } else {
            hoodPiston.set(Value.kReverse);
        }

        masterMotor.set(TalonFXControlMode.Velocity, rpm);
    }

    public void terminating() {
        masterMotor.set(TalonFXControlMode.Velocity, Constants.SH_IDLE_RPM);
    }

    public int lookupRPM(int POV) {
        int rpmSet;

        switch(POV) {
            case 0:
            rpmSet = Constants.SH_SHOOT_LOW_RPM;

            case 90:
            rpmSet = Constants. SH_SHOOT_MID_RPM;

            case 180:
            rpmSet = Constants.SH_SHOOT_HIGH_RPM;

            case 270:
            rpmSet = Constants.SH_SHOOT_VERY_HIGH_RPM;

            default:
            rpmSet = Constants.SH_IDLE_RPM;
        }

        return rpmSet;
    }

    public boolean checkhood(Integer POV) {
     if (POV.equals(270)){
         return true;

     } else {

         return false;
     }
    
    }

     @Override
     public void periodic() {}

    public int lookupRPM() {
        return 0;
    }


}
