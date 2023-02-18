package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

    WPI_TalonFX leftMotorOne;
    WPI_TalonFX leftMotorTwo;
    WPI_TalonFX leftMotorThree;

    WPI_TalonFX rightMotorOne;
    WPI_TalonFX rightMotorTwo;
    WPI_TalonFX rightMotorThree;

    MotorControllerGroup leftMotors;
    MotorControllerGroup rightMotors;

    DifferentialDrive differentialDrive;

public Drivetrain() {
    leftMotorOne = new WPI_TalonFX(Constants.DT_LFT_MOTOR_ONE_ID);
    leftMotorTwo = new WPI_TalonFX(Constants.DT_LFT_MOTOR_TWO_ID);
    leftMotorThree = new WPI_TalonFX(Constants.DT_LFT_MOTOR_THREE_ID);

    rightMotorOne = new WPI_TalonFX(Constants.DT_RGHT_MOTOR_ONE_ID);
    rightMotorTwo = new WPI_TalonFX(Constants.DT_RGHT_MOTOR_TWO_ID);
    rightMotorThree = new WPI_TalonFX(Constants.DT_RGHT_MOTOR_THREE_ID);

    leftMotorOne.setNeutralMode(NeutralMode.Coast);
    leftMotorTwo.setNeutralMode(NeutralMode.Coast);
    leftMotorThree.setNeutralMode(NeutralMode.Coast);

    rightMotorOne.setNeutralMode(NeutralMode.Coast);
    rightMotorTwo.setNeutralMode(NeutralMode.Coast);
    rightMotorThree.setNeutralMode(NeutralMode.Coast);
    leftMotors.setInverted(true);

    leftMotors = new MotorControllerGroup(leftMotorOne, leftMotorTwo, leftMotorThree);
    rightMotors = new MotorControllerGroup(rightMotorOne, rightMotorTwo, rightMotorThree);

    differentialDrive = new DifferentialDrive(rightMotors, leftMotors);

}
    public void CurveDrive(double speed, double turnBy, boolean turnInPlace) {
    }
    
    public void ArcadeDrive(double moveSpeed, double rotateSpeed) {
    }
    
    public void Brake(boolean b) {
    }
    
}