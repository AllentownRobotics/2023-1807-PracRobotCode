package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

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

    public static boolean isBraking;

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

        isBraking = false;
    }
    public void CurvatureDrive(double moveSpeed, double rotateSpeed) {
        drivetrain.curvatureDrive(moveSpeed, rotateSpeed, RobotContainer.xboxController.getRightBumper());    
    }
    public void ToggleBrakes() {
        if (isBraking = false) {
        frontRight.setNeutralMode(NeutralMode.Brake);
        centerRight.setNeutralMode(NeutralMode.Brake);
        backRight.setNeutralMode(NeutralMode.Brake);
        frontLeft.setNeutralMode(NeutralMode.Brake);
        centerLeft.setNeutralMode(NeutralMode.Brake);
        backLeft.setNeutralMode(NeutralMode.Brake);
        isBraking = true;
        } else if (isBraking = true) {
        frontRight.setNeutralMode(NeutralMode.Coast);
        centerRight.setNeutralMode(NeutralMode.Coast);
        backRight.setNeutralMode(NeutralMode.Coast);
        frontLeft.setNeutralMode(NeutralMode.Coast);
        centerLeft.setNeutralMode(NeutralMode.Coast);
        backLeft.setNeutralMode(NeutralMode.Coast);
        isBraking = false;
        }
    }
}
