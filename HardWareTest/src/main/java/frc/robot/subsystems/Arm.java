// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxAbsoluteEncoder.Type;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class Arm extends SubsystemBase {
  /** Creates a new Arm. */
  CANSparkMax leftMotor1 = new CANSparkMax(ArmConstants.LEFT_MOTOR1_ID, MotorType.kBrushless);
  CANSparkMax leftMotor2 = new CANSparkMax(ArmConstants.LEFT_MOTOR2_ID, MotorType.kBrushless);

  CANSparkMax rightMotor1 = new CANSparkMax(ArmConstants.RIGHT_MOTOR1_ID, MotorType.kBrushless);
  CANSparkMax rightMotor2 = new CANSparkMax(ArmConstants.RIGHT_MOTOR2_ID, MotorType.kBrushless);

  AbsoluteEncoder encoder;

  SparkMaxPIDController pidController;

  double desiredAngle;

  public Arm() {
    // Determine which encoder to use
    encoder = ArmConstants.USE_LEFT_ENCODER ? leftMotor1.getAbsoluteEncoder(Type.kDutyCycle) : rightMotor1.getAbsoluteEncoder(Type.kDutyCycle); 
    // If using right encoder set inversion false, if not set true
    encoder.setInverted(!ArmConstants.USE_LEFT_ENCODER);
    // Set conversion factor to output in degrees and degrees/sec
    encoder.setPositionConversionFactor(1.0 / 360.0);
    encoder.setVelocityConversionFactor((1.0 / 360.0) / 60.0);

    pidController = leftMotor1.getPIDController();
    pidController.setFeedbackDevice(encoder);

    // Set PID values from SysID
    pidController.setP(ArmConstants.PID_kP);
    pidController.setI(ArmConstants.PID_kI);
    pidController.setD(ArmConstants.PID_kD);
    pidController.setFF(ArmConstants.PID_kFF);
    pidController.setOutputRange(-1.0, 1.0);

    // Have all motors follor master
    leftMotor2.follow(leftMotor1, false);
    rightMotor1.follow(leftMotor1, true);
    rightMotor2.follow(leftMotor1, true);

    // Set all motors to brake
    leftMotor1.setIdleMode(IdleMode.kBrake);
    leftMotor2.setIdleMode(IdleMode.kBrake);
    rightMotor1.setIdleMode(IdleMode.kBrake);
    rightMotor2.setIdleMode(IdleMode.kBrake);
  }

  @Override
  public void periodic() {
    pidController.setReference(desiredAngle, ControlType.kPosition);
  }

  public double getAngle(){
    return encoder.getPosition();
  }

  public void setDesiredAngle(double angle) {
    desiredAngle = angle;
  }

  public void RotateBy(double degrees){
    desiredAngle += degrees;
  }
}
