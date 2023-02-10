// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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
    public static final int DRIVER_CONTROLLER_PORT = 0;
    public static final int OPERATOR_CONTROLLER_PORT = 1;
  }

  public static class ArmConstants{
    public static final boolean USE_LEFT_ENCODER = true;

    public static final double ANGLE_OFFSET_FROM_VERTICAL_DEGREES = 57.442;
    public static final double HEIGHT_OFFSET_FROM_GROUND_INCHES = 35.219;
    public static final double ARM_LENGTH_INCHES = 30.254;

    public static final int LEFT_MOTOR1_ID = 0;
    public static final int LEFT_MOTOR2_ID = 0;

    public static final int RIGHT_MOTOR1_ID = 0;
    public static final int RIGHT_MOTOR2_ID = 0;

    public static final double PID_kP = 0.0;
    public static final double PID_kI = 0.0;
    public static final double PID_kD = 0.0;
    public static final double PID_kFF = 0.0;

    public static final double ANGLE_CONE_INSURANCE = 5.0;

    public static final double ANGLE_CONE_HIGH = 195.37664 - ANGLE_CONE_INSURANCE;
    public static final double ANGLE_CONE_MID = 210.2488 - ANGLE_CONE_INSURANCE;

    public static final double ANGLE_CUBE_HIGH = 195.37664;
    public static final double ANGLE_CUBE_MID = 210.2488;

    public static final double ANGLE_FROM_HEIGHT(double heightInches, boolean insure){
      double sideRatios = Math.abs(heightInches - HEIGHT_OFFSET_FROM_GROUND_INCHES) / ARM_LENGTH_INCHES;
      double angle = (270.0 - Math.asin(sideRatios)) - ANGLE_OFFSET_FROM_VERTICAL_DEGREES;

      angle -= insure ? ANGLE_CONE_INSURANCE : 0.0;

      return angle;
    }
  }
}
