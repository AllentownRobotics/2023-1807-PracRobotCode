package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climb extends SubsystemBase {
    
    static WPI_TalonFX leftArmMotor;
    static WPI_TalonFX rightArmMotor;
    static DoubleSolenoid climbPiston;

    public Climb() {
        leftArmMotor = new WPI_TalonFX(Constants.CB_LFT_ID);
        rightArmMotor = new WPI_TalonFX(Constants.CB_RGHT_ID);
        climbPiston = new DoubleSolenoid(Constants.CB_PISTON_ID, PneumaticsModuleType.REVPH, Constants.CB_PISTON_FORWARD, Constants.CB_PISTON_REVERSE);

        rightArmMotor.setInverted(true);
        rightArmMotor.follow(leftArmMotor);

        leftArmMotor.setNeutralMode(NeutralMode.Brake);
        rightArmMotor.setNeutralMode(NeutralMode.Brake);
    }

    public static void weAreClimbing() {
        climbPiston.set(Value.kForward);

        leftArmMotor.set(Constants.CB_LFT_EXTENDED);
        rightArmMotor.set(Constants.CB_RGHT_EXTENDED);

    }

    public static void noClimbing() {
        climbPiston.set(Value.kReverse);

        leftArmMotor.set(Constants.CB_LFT_RETRACTED);
        rightArmMotor.set(Constants.CB_RGHT_RETRACTED);

    }


}
