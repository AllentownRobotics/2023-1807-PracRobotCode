// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax.IdleMode;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    
    public static final int kOperatorControllerPort = 1;

    public static final int driveMotorPinionTeeth = 13;

    public static final double driveMotorSpeedRPS = 5676 / 60;

    public static final double wheelDiameterMeters = 0.0762;

    public static final double wheelCircumferenceMeters = wheelDiameterMeters * Math.PI;

    public static final double driveMotorReduction = (45.0 * 22) / (driveMotorPinionTeeth * 15);

    public static final double driveWheelSpeedRPS = (driveMotorSpeedRPS * wheelCircumferenceMeters)
        / driveMotorReduction;

    public static final double driveEncoderPositionCoefficient = (wheelDiameterMeters * Math.PI)
        / driveMotorReduction;

    public static final double driveEncoderVelocityCoefficient = ((wheelDiameterMeters * Math.PI)
        / driveMotorReduction) / 60.0;

    public static final double turningEncoderPositionCoefficient = (2 * Math.PI);

    public static final double turningEncoderVelocityCoefficient = (2 * Math.PI) / 60.0;

    public static final IdleMode driveMotorIdleMode = IdleMode.kBrake;

    public static final IdleMode turningMotorIdleMode = IdleMode.kBrake;

    public static final int driveMotorCurrentLimit = 50;
    
    public static final int turningMotorCurrentLimit = 20;
  }

    public static class MechanismConstants {

  public static final int compressorModuleID = 14;

  public static final int leftArmPistonForwardChannel = 0;

  public static final int leftArmPistonReverseChannel = 1;

  public static final int rightArmPistonForwardChannel = 2;

  public static final int rightArmPistonReverseChannel = 3;

  public static final int clawRetractorForwardChannel = 4;

  public static final int clawRetractorReverseChannel = 5;

  public static final int clawExtenderForwardChannel = 6;

  public static final int clawExtenderReverseChannel = 7;
    }
    public static class DrivetrainConstants {

      public static final int driveMotorFL_ID = 1;

      public static final int turnMotorFL_ID = 2;

      public static final int driveMotorFR_ID = 3;
      
      public static final int turnMotorFR_ID = 4;

      public static final int driveMotorBL_ID = 5;

      public static final int turnMotorBL_ID = 6;

      public static final int driveMotorBR_ID = 7;

      public static final int turnMotorBR_ID = 8;

      public static final double fLModuleAngularOffset = -Math.PI/2;

      public static final double fRModuleAngularOffset = 0;

      public static final double bLModuleAngularOffset = Math.PI;

      public static final double bRModuleAngularOffset = Math.PI/2;

      public static final double drivetrainLinearTopSpeed = 2.0;

      public static final double drivetrainAngularTopSpeed = Math.PI * 2;

      
    }
}
