// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // Global Module Values
    public static final double MODULE_GEARING_DRIVE_MOTORTOWHEEL = 990.0 / 195.0;
    public static final double MODULE_GEARING_ROTATION_MOTORTOWHEEL = 9424.0 / 203.0;
    public static final double MODULE_WHEEL_RADIUS_METERS = Units.inchesToMeters(3);
    public static final double MODULE_WHEEL_CIRCUMFRENCE_METERS = MODULE_WHEEL_RADIUS_METERS * 2.0 * Math.PI;

        // Drive Constants
    public static final double DRIVE_MOTORS_Kp = 0.04;
    public static final double DRIVE_MOTORS_Kff = 1.0 / ((5676 * MODULE_WHEEL_CIRCUMFRENCE_METERS) / MODULE_GEARING_DRIVE_MOTORTOWHEEL);

        // Turn Constants
    public static final double TURN_MOTORS_Kp = 1.0;
    public static final double TURN_MOTORS_Kff = 0.0;

    // Global Chassis Values
    public static final double CHASSIS_DISTANCE_BETWEEN_MODULES_METERS = Units.inchesToMeters(26);
    public static final double CHASSIS_DISTANCE_OFFSET_MODULES_METERS = CHASSIS_DISTANCE_BETWEEN_MODULES_METERS / 2.0;
    public static final double CHASSIS_MAXSPEED_LINEAR_METERSPERSECOND = 2.0;
    public static final double CHASSIS_MAXSPEED_ANGULAR_RADIANSPERSECOND = Math.PI * 2.0; // 360 deg/sec

    public static final boolean CHASSIS_GYRO_INVERTED = false;

    public static final double CHASSIS_FRONTLEFT_ANGULAROFFSET_RADIANS = Math.PI / 2.0;
    public static final double CHASSIS_FRONTRIGHT_ANGULAROFFSET_RADIANS = Math.PI / 2.0;
    public static final double CHASSIS_BACKLEFT_ANGULAROFFSET_RADIANS = Math.PI / 2.0;
    public static final double CHASSIS_BACKRIGHT_ANGULAROFFSET_RADIANS = Math.PI / 2.0;

    public static final Translation2d CHASSIS_FRONTLEFT_POSITION_METERS = new Translation2d(-CHASSIS_DISTANCE_OFFSET_MODULES_METERS, CHASSIS_DISTANCE_OFFSET_MODULES_METERS);
    public static final Translation2d CHASSIS_FRONTRIGHT_POSITION_METERS = new Translation2d(CHASSIS_DISTANCE_OFFSET_MODULES_METERS, CHASSIS_DISTANCE_OFFSET_MODULES_METERS);
    public static final Translation2d CHASSIS_BACKLEFT_POSITION_METERS = new Translation2d(-CHASSIS_DISTANCE_OFFSET_MODULES_METERS, -CHASSIS_DISTANCE_OFFSET_MODULES_METERS);
    public static final Translation2d CHASSIS_BACKRIGHT_POSITION_METERS = new Translation2d(CHASSIS_DISTANCE_OFFSET_MODULES_METERS, -CHASSIS_DISTANCE_OFFSET_MODULES_METERS);

    /**
     * Order: FL, FR, BL, BR
     */
    public static final SwerveDriveKinematics CHASSIS_KINEMATICS = new SwerveDriveKinematics(
        CHASSIS_FRONTLEFT_POSITION_METERS,
        CHASSIS_FRONTRIGHT_POSITION_METERS,
        CHASSIS_BACKLEFT_POSITION_METERS,
        CHASSIS_BACKRIGHT_POSITION_METERS
    );

    // CAN IDs
    public static final int IDS_FRONTLEFT_DRIVEMOTOR = 1;
    public static final int IDS_FRONTRIGHT_DRIVEMOTOR = 3;
    public static final int IDS_BACKLEFT_DRIVEMOTOR = 5;
    public static final int IDS_BACKRIGHT_DRIVEMOTOR = 7;

    public static final int IDS_FRONTLEFT_TURNMOTOR = 2;
    public static final int IDS_FRONTRIGHT_TURNMOTOR = 4;
    public static final int IDS_BACKLEFT_TURNMOTOR = 6;
    public static final int IDS_BACKRIGHT_TURNMOTOR = 8;

    public static final int IDS_GYRO = 9;

    // Auto Values
    public static final double AUTO_MAXACCELERATION_ANGULAR_RADIANSPERSECONDSQUARED = Math.PI * 2; // 360 deg/sec^2
    
    public static final double AUTO_ROTATIONPID_Kp = 1.0;
    public static final TrapezoidProfile.Constraints AUTO_ROTATIONPID_CONSTRAINT = new TrapezoidProfile.Constraints(CHASSIS_MAXSPEED_ANGULAR_RADIANSPERSECOND, AUTO_MAXACCELERATION_ANGULAR_RADIANSPERSECONDSQUARED);
}
