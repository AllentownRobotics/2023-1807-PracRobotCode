// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.Enums.PlacementType;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

public final class Constants {
  public static class GlobalConstants{
    public static final int PNEUMATICS_ID = 14;
  }

  public static class OperatorConstants {
    public static final int DRIVER_CONTROLLER_PORT = 0;
    public static final int OPERATOR_CONTROLLER_PORT = 1;

    public static final int OPERATOR_CONTROLLER_AXISID_LEFTSTICK_Y = 1;

    public static final double OPERATOR_CONTROLLER_THRESHOLD_SPINDEXER = 0.08;
  }

  public static final int pigeonid = 9;
  public static final class DriveConstants {
    // Driving Parameters - Note that these are not the maximum capable speeds of
    // the robot, rather the allowed maximum speeds
    public static final double kMaxSpeedMetersPerSecond = 3;
    public static final double kMaxAngularSpeed = 2 * Math.PI; // radians per second

    // Chassis configuration
    public static final double kTrackWidth = Units.inchesToMeters(26);
    // Distance between centers of right and left wheels on robot
    public static final double kWheelBase = Units.inchesToMeters(26);
    // Distance between front and back wheels on robot
    public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
        new Translation2d(kWheelBase / 2, kTrackWidth / 2),
        new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
        new Translation2d(-kWheelBase / 2, kTrackWidth / 2),
        new Translation2d(-kWheelBase / 2, -kTrackWidth / 2));

    // Angular offsets of the modules relative to the chassis in radians
    public static final double kFrontLeftChassisAngularOffset = -Math.PI/2;
    public static final double kFrontRightChassisAngularOffset = 0;
    public static final double kBackLeftChassisAngularOffset = Math.PI;
    public static final double kBackRightChassisAngularOffset = Math.PI/2;

    // SPARK MAX CAN IDs
    public static final int kFrontLeftDrivingCanId = 1;
    public static final int kRearLeftDrivingCanId = 5;
    public static final int kFrontRightDrivingCanId = 3;
    public static final int kRearRightDrivingCanId = 7;

    public static final int kFrontLeftTurningCanId = 2;
    public static final int kRearLeftTurningCanId = 6;
    public static final int kFrontRightTurningCanId = 4;
    public static final int kRearRightTurningCanId = 8;

    public static final boolean kGyroReversed = false;
  }

  public static final class ModuleConstants {
    // The MAXSwerve module can be configured with one of three pinion gears: 12T, 13T, or 14T.
    // This changes the drive speed of the module (a pinion gear with more teeth will result in a
    // robot that drives faster).
    public static final int kDrivingMotorPinionTeeth = 13;

    // Invert the turning encoder, since the output shaft rotates in the opposite direction of
    // the steering motor in the MAXSwerve Module.
    public static final boolean kTurningEncoderInverted = true;

    // Calculations required for driving motor conversion factors and feed forward
    public static final double kDrivingMotorFreeSpeedRps = 5676.0 / 60.0;
    public static final double kWheelDiameterMeters = 0.0762;
    public static final double kWheelCircumferenceMeters = kWheelDiameterMeters * Math.PI;
    // 45 teeth on the wheel's bevel gear, 22 teeth on the first-stage spur gear, 15 teeth on the bevel pinion
    public static final double kDrivingMotorReduction = (45.0 * 22) / (kDrivingMotorPinionTeeth * 15);
    public static final double kDriveWheelFreeSpeedRps = (kDrivingMotorFreeSpeedRps * kWheelCircumferenceMeters)
        / kDrivingMotorReduction;

    public static final double kDrivingEncoderPositionFactor = (kWheelDiameterMeters * Math.PI)
        / kDrivingMotorReduction; // meters
    public static final double kDrivingEncoderVelocityFactor = ((kWheelDiameterMeters * Math.PI)
        / kDrivingMotorReduction) / 60.0; // meters per second

    public static final double kTurningEncoderPositionFactor = (2 * Math.PI); // radians
    public static final double kTurningEncoderVelocityFactor = (2 * Math.PI) / 60.0; // radians per second

    public static final double kTurningEncoderPositionPIDMinInput = 0; // radians
    public static final double kTurningEncoderPositionPIDMaxInput = kTurningEncoderPositionFactor; // radians

    public static final double kDrivingP = 0.04;
    public static final double kDrivingI = 0;
    public static final double kDrivingD = 0;
    public static final double kDrivingFF = 1 / kDriveWheelFreeSpeedRps;
    public static final double kDrivingMinOutput = -1;
    public static final double kDrivingMaxOutput = 1;

    public static final double kTurningP = 1;
    public static final double kTurningI = 0;
    public static final double kTurningD = 0;
    public static final double kTurningFF = 0;
    public static final double kTurningMinOutput = -1;
    public static final double kTurningMaxOutput = 1;

    public static final IdleMode kDrivingMotorIdleMode = IdleMode.kBrake;
    public static final IdleMode kTurningMotorIdleMode = IdleMode.kBrake;

    public static final int kDrivingMotorCurrentLimit = 50; // amps
    public static final int kTurningMotorCurrentLimit = 20; // amps
  }

  public static class ArmConstants{
    public static final boolean USE_LEFT_ENCODER = true;

    public static final double ANGLE_OFFSET_FROM_ZERO = 9.5;
    public static final double ANGLE_OFFSET_FROM_VERTICAL_DEGREES = 57.442;
    public static final double HEIGHT_OFFSET_FROM_GROUND_INCHES = 35.219;
    public static final double ARM_LENGTH_INCHES = 30.254;

    public static final int LEFT_MOTOR_ID = 31;

    public static final int RIGHT_MOTOR_ID = 32;

    public static final double PID_kP = 0.03;
    public static final double PID_kI = 0.00000001;
    public static final double PID_kD = 0.0;
    public static final double PID_kFF = 0.0005;
    
    public static final double ANGLE_CONE_INSURANCE = 20.0;
    public static final double ANGLE_CUBE_INSURANCE = 10.0;
    public static final double ANGLE_MANUAL_SPEED_MAX_DEGREESPERSECOND = 120.0;
    public static final double ANGLE_MANUAL_INPUT_MODIFIER = 2.0;

    public static final double ANGLE_CONE_HIGH = 201.182 - ANGLE_CONE_INSURANCE;
    public static final double ANGLE_CONE_MID = 224.367 - ANGLE_CONE_INSURANCE;

    public static final double ANGLE_CUBE_HIGH = 201.182 - ANGLE_CUBE_INSURANCE;
    public static final double ANGLE_CUBE_MID = 224.367 - ANGLE_CUBE_INSURANCE;

    /**
     * Calculates the angle required for the arm to rotate to in order to reach the desired height
     * @param heightInches Height above ground for the arm to end up
     * @return The angle for the arm to rotate to in order reach the desired height above the ground
     */
    public static double ANGLE_FROM_HEIGHT(double heightInches){
      double verticalDiff = heightInches - HEIGHT_OFFSET_FROM_GROUND_INCHES;
      double sideRatios = Math.abs(verticalDiff) / ARM_LENGTH_INCHES;
      double angleABS = (270.0 - (verticalDiff > 0.0 ? Math.asin(sideRatios) : -Math.asin(sideRatios)));
      double angle = (angleABS - ANGLE_OFFSET_FROM_VERTICAL_DEGREES) + ANGLE_OFFSET_FROM_ZERO;

      return angle;
    }

    /**
     * Calculates the angle required for the arm to rotate to in order to reach the desired height
     * with insurance so as to place the arm slightly above the target height
     * @param heightInches Height above the ground for the arm to end up at disregarding insurance
     * @param setPointType The type of set point for the angle to be, each type uses its respective insurance
     * defined in the constants
     * @return The angle for the arm to rotate to in order to reach the desired height above the ground with insurance
     */
    public static double ANGLE_FROM_HEIGHT(double heightInches, PlacementType setPointType){
      double verticalDiff = heightInches - HEIGHT_OFFSET_FROM_GROUND_INCHES;
      double sideRatios = Math.abs(verticalDiff) / ARM_LENGTH_INCHES;
      double angleABS = (270.0 - (verticalDiff > 0.0 ? Math.asin(sideRatios) : -Math.asin(sideRatios)));
      double angle = (angleABS - ANGLE_OFFSET_FROM_VERTICAL_DEGREES) + ANGLE_OFFSET_FROM_ZERO;

      angle -= (setPointType.equals(PlacementType.Cone) ? ANGLE_CONE_INSURANCE : ANGLE_CUBE_INSURANCE);

      return angle;
    }
  }

  public static class ClawConstants{
    public static final int WRIST_ID = GlobalConstants.PNEUMATICS_ID;
    public static final int WRIST_CHANNEL_FORWARD = 0;
    public static final int WRIST_CHANNEL_BACKWARD = 3;

    public static final int CLAW_ID = GlobalConstants.PNEUMATICS_ID;
    public static final int CLAW_CHANNEL_FORWARD = 4;
    public static final int CLAW_CHANNEL_BACKWARD = 1;

    public static final double ANGLE_WRIST_EXCLUSIONZONE_MIN = 197 + ArmConstants.ANGLE_OFFSET_FROM_ZERO;
    public static final double ANGLE_WRIST_EXCLUSIONZONE_MAX = 229 + ArmConstants.ANGLE_OFFSET_FROM_ZERO;
  }

  public static class SpindexerConstants{
    public static final int SPINDEXER_MOTOR_ID = 11;

    public static final double SPINDEXER_GEARING_MOTORTOTABLE = 22.0 / 1.0;

    public static final double PID_kP = 0.08;
    public static final double PID_kI = 0.0;
    public static final double PID_kD = 0.0;
    public static final double PID_kFF = 0.0;

    public static final double SPINDEXER_MOTOR_MAXOUTPUT = 0.25;

    public static final double COLORSENSOR_THRESHOLD_CUBE = 0.04;
    public static final double COLORSENSOR_THRESHOLD_CONE = 0.04;

    public static final Color COLORSENSOR_COLOR_CUBE = new Color(190, 20, 220);
    public static final Color COLORSENSOR_COLOR_CONE = new Color(230, 220, 0);
  }

  public static class CompressorConstants{
    public static int COMPRESSOR_ID = GlobalConstants.PNEUMATICS_ID;

    public static double COMPRESSOR_RANGE_MIN = 60.0;
    public static double COMPRESSOR_RANGE_MAX = 120.0;
  }

  public static class CollectorConstants{
    public static final int TOP_MOTOR_ID = 0;
    public static final int BOTTOM_MOTOR_ID = 0;

    public static final int COLLECTOR_PISTON_ID = GlobalConstants.PNEUMATICS_ID;
    public static final int COLLECTOR_PISTON_CHANNEL_FORWARD = 0;
    public static final int COLLECTOR_PISTON_CHANNEL_BACKWARD = 0;

    // SUBJECT TO CHANGE
    public static final int BELT_MOTOR_ID = 0;

    public static final double COLLECTOR_SPEED_MAX = 0.5;
  }
} 