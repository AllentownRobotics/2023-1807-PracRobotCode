package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

    public static WPI_TalonFX frontLeft;
    public static WPI_TalonFX frontRight;
    public static WPI_TalonFX centerLeft;
    public static WPI_TalonFX centerRight;
    public static WPI_TalonFX backLeft;
    public static WPI_TalonFX backRight;
    
    public static MotorControllerGroup leftWheels;
    public static MotorControllerGroup rightWheels;

    public static DifferentialDrive drivetrain;

    public Drivetrain() {
        frontRight = new WPI_TalonFX(Constants.drivetrainFrontRight);
        centerRight = new WPI_TalonFX(Constants.drivetrainCenterRight);
        backRight = new WPI_TalonFX(Constants.drivetrainBackRight);
        frontLeft = new WPI_TalonFX(Constants.drivetrainFrontLeft);
        centerLeft = new WPI_TalonFX(Constants.drivetrainCenterLeft);
        backLeft = new WPI_TalonFX(Constants.drivetrainBackLeft);

        frontRight.setNeutralMode(NeutralMode.Coast);
        centerRight.setNeutralMode(NeutralMode.Coast);
        backRight.setNeutralMode(NeutralMode.Coast);
        frontLeft.setNeutralMode(NeutralMode.Coast);
        centerLeft.setNeutralMode(NeutralMode.Coast);
        backLeft.setNeutralMode(NeutralMode.Coast);

        leftWheels = new MotorControllerGroup(frontLeft, centerLeft, backLeft);
        rightWheels = new MotorControllerGroup(frontRight, centerRight, backRight);

        rightWheels.setInverted(true);

        drivetrain = new DifferentialDrive(leftWheels, rightWheels);
    }
    public void CurvatureDrive(double moveSpeed, double rotateSpeed, boolean stopButton) {
        drivetrain.curvatureDrive(moveSpeed, rotateSpeed, stopButton);    
    }
}
