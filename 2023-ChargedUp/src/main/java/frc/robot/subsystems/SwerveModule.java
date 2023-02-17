// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxAbsoluteEncoder.Type;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveModule extends SubsystemBase {

  private final CANSparkMax driveMotor;
  private final CANSparkMax turningMotor;

  private static RelativeEncoder driveEncoder;
  private static AbsoluteEncoder turningEncoder;

  int driveMotorChannel;
  int turningMotorChannel;

  int driveEncoderChannelA;
  int driveEncoderChannelB;

  int turningEncoderChannelA;
  int turningEncoderChannelB;

  String name;

  double angularOffset;

  /** Creates a new SwerveModule. */
  public SwerveModule(
    String name,
    int driveMotorID,
    int turnMotorID,
    double angularOffset) {

      this.name = name;

      this.angularOffset = angularOffset;
      
      driveMotor = new CANSparkMax(driveMotorChannel, MotorType.kBrushless);

      turningMotor = new CANSparkMax(turningEncoderChannelB, MotorType.kBrushless);

      driveEncoder = driveMotor.getEncoder();

      turningEncoder = turningMotor.getAbsoluteEncoder(Type.kDutyCycle);

      driveMotor.restoreFactoryDefaults();
      
      turningMotor.restoreFactoryDefaults();

    }

    public static SwerveModuleState getState() {
      return new SwerveModuleState(
          driveEncoder.getVelocity(), new Rotation2d(turningEncoder.getPosition()));
    }

    public SwerveModulePosition getPosition() {
      return new SwerveModulePosition(
       driveEncoder.getPosition() , new Rotation2d(turningEncoder.getPosition()));
    }

    public void setDesiredState(SwerveModuleState desiredState) {
      SwerveModuleState state =
          SwerveModuleState.optimize(desiredState, new Rotation2d(turningEncoder.getPosition()));
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
