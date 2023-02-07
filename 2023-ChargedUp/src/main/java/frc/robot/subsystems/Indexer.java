package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Indexer extends SubsystemBase {
    
    Ultrasonic indexSensor;
    Ultrasonic feederSensor;

    public static WPI_TalonSRX indexerMotor;
    public static WPI_TalonSRX feederMotor;

    public Indexer() {
        indexSensor = new Ultrasonic(Constants.indexerIndexPingChannel, 
        Constants.indexerIndexEchoChannel);
        
        feederSensor = new Ultrasonic(Constants.indexerFeederPingChannel, 
        Constants.indexerFeederEchoChannel);

        indexerMotor = new WPI_TalonSRX(Constants.indexerIndexMotorID);
        feederMotor = new WPI_TalonSRX(Constants.indexerFeederMotorID);

        indexerMotor.setNeutralMode(NeutralMode.Coast);
        feederMotor.setNeutralMode(NeutralMode.Coast);
    }
    public void Index() {
        feederMotor.set(.4);
        indexerMotor.set(.4);
    }
}
