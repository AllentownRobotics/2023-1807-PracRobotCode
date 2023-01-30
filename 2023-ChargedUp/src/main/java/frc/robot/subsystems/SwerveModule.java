// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxAbsoluteEncoder.Type;
import com.revrobotics.SparkMaxPIDController;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SwerveModule extends SubsystemBase {
  String name;

  CANSparkMax driveMotor;
  CANSparkMax turnMotor;

  SparkMaxPIDController drivePID;
  SparkMaxPIDController turnPID;

  RelativeEncoder driveEncoder;
  AbsoluteEncoder turnEncoder;

  double angularOffset;

  SwerveModuleState desiredState = new SwerveModuleState(0.0, new Rotation2d());

  /**
   * Creates a new swerve module with given parameters
   * @param name Abbreviation for the relative location of the module
   * @param driveMotorID CAN ID for the driver motor
   * @param turnMotorID CAN ID for the rotation motor
   * @param angularOffset Angular offset of the module starting position in radians
   */
  public SwerveModule(String name, int driveMotorID, int turnMotorID, double angularOffset) {
    this.name = name;
    this.angularOffset = angularOffset;

    driveMotor = new CANSparkMax(driveMotorID, MotorType.kBrushless);
    turnMotor = new CANSparkMax(turnMotorID, MotorType.kBrushless);

    driveMotor.restoreFactoryDefaults();
    turnMotor.restoreFactoryDefaults();

    driveMotor.setIdleMode(IdleMode.kBrake);
    turnMotor.setIdleMode(IdleMode.kBrake);

    driveEncoder = driveMotor.getEncoder();
    driveEncoder.setPositionConversionFactor((Constants.MODULE_WHEEL_CIRCUMFRENCE_METERS) / Constants.MODULE_GEARING_DRIVE_MOTORTOWHEEL); // Meters
    driveEncoder.setVelocityConversionFactor(driveEncoder.getPositionConversionFactor() / 60.0); // Meters per second

    turnEncoder = turnMotor.getAbsoluteEncoder(Type.kDutyCycle); // Uses data port
    turnEncoder.setPositionConversionFactor(2.0 * Math.PI); // Radians
    turnEncoder.setVelocityConversionFactor(turnEncoder.getPositionConversionFactor() / 60.0); // Radians per second
    turnEncoder.setInverted(true); // Motor spins opposite output shaft

    drivePID = driveMotor.getPIDController();
    drivePID.setFeedbackDevice(driveEncoder);
    drivePID.setP(Constants.DRIVE_MOTORS_Kp);
    drivePID.setFF(Constants.DRIVE_MOTORS_Kff);
    drivePID.setOutputRange(-1.0, 1.0);

    turnPID = turnMotor.getPIDController();
    turnPID.setFeedbackDevice(turnEncoder);
    turnPID.setPositionPIDWrappingEnabled(true);
    turnPID.setPositionPIDWrappingMinInput(0.0);
    turnPID.setPositionPIDWrappingMaxInput(2.0 * Math.PI);
    turnPID.setP(Constants.TURN_MOTORS_Kp);
    turnPID.setFF(Constants.TURN_MOTORS_Kff);
    turnPID.setOutputRange(-1.0, 1.0);
    
    driveMotor.burnFlash();
    turnMotor.burnFlash();

    desiredState.angle = new Rotation2d(turnEncoder.getPosition());
    resetEncoder();
  }

  /**
   * Sets the desired state for the module to converge to
   * @param newDesiredState State for the module to converge to
   */
  public void setDesiredState(SwerveModuleState newDesiredState){
    SwerveModuleState correctedState = newDesiredState;
    correctedState.angle.plus(Rotation2d.fromDegrees(angularOffset));
    desiredState = SwerveModuleState.optimize(correctedState, new Rotation2d(turnEncoder.getPosition()));

    drivePID.setReference(desiredState.speedMetersPerSecond, CANSparkMax.ControlType.kVelocity);
    turnPID.setReference(desiredState.angle.getRadians(), CANSparkMax.ControlType.kPosition);
  }

  /**
   * Gets the current state of the module
   * @return State of the module
   */
  public SwerveModuleState getActualState(){
    return new SwerveModuleState(driveEncoder.getVelocity(), new Rotation2d(turnEncoder.getPosition() - angularOffset));
  }

  /**
   * Gets the desired state of the swerve module
   * @return Desired state of the module
   */
  public SwerveModuleState getDesiredState(){
    return desiredState;
  }

  /**
   * Gets the current position of the module
   * @return Position of the module
   */
  public SwerveModulePosition getSwerveModulePosition(){
    return new SwerveModulePosition(driveEncoder.getPosition(), new Rotation2d(turnEncoder.getPosition() - angularOffset));
  }

  /**
   * Gets the linear velocity of the wheel
   * @return Linear velocity of the wheel in meters/second
   */
  public double getLinearVelocity(){
    return driveEncoder.getVelocity();
  }

  /**
   * Gets the rotational velocity of the rotational shaft
   * @return Rotational velocity of the rotational shaft in radians/second
   */
  public double getTurnRate(){
    return turnEncoder.getVelocity();
  }

  /**
   * Resets the drive encoder to 0
   */
  public void resetEncoder(){
    driveEncoder.setPosition(0);
  }

  /**
   * Gets the Abbreviated location of the swerve module relative to the center of the chassis of the module
   * @return Abbreviated location of the swerve module relative to the center of the chassis
   */
  public String getName(){
    return name;
  }
}
