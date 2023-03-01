// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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
    public static final int DRIVER_CONTROLLER_PORT = 1;
    public static final int OPERATOR_CONTROLLER_PORT = 0;

    public static final int OPERATOR_CONTROLLER_AXISID_LEFTSTICK_Y = 1;

    public static final double OPERATOR_CONTROLLER_THRESHOLD_SPINDEXER = 0.08;
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
    public static final double ANGLE_MANUAL_INPUT_MODIFIER = ANGLE_MANUAL_SPEED_MAX_DEGREESPERSECOND * 0.02;

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

    public static final double ANGLE_WRIST_EXCLUSIONZONE_MIN = 0.0;
    public static final double ANGLE_WRIST_EXCLUSIONZONE_MAX = 192.0 + ArmConstants.ANGLE_OFFSET_FROM_ZERO;
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