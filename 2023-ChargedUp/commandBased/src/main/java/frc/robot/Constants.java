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

    // drivetrain constants

    public static final int drivetrainFrontLeft = 1;
    
    public static final int drivetrainCenterLeft = 2;
    
    public static final int drivetrainBackLeft = 3;
    
    public static final int drivetrainFrontRight = 4;
    
    public static final int drivetrainCenterRight = 5;
    
    public static final int drivetrainBackRight = 6;

    public static final double drivetrainPrecisionMultiplier = 0.25;

    // shooter constants

    public static final int shooterLeftMotor = 7;
    
    public static final int shooterRightMotor = 8;

    public static final int shooterTargetRPM = 4000;

    // indexer constants

    public static final int indexerIndexEchoChannel = 0;
    
    public static final int indexerIndexPingChannel = 1;

    public static final int indexerFeederEchoChannel = 2;
    
    public static final int indexerFeederPingChannel = 3;

    public static final int indexerFeederMotorID = 12;
    
    public static final int indexerIndexMotorID = 13;

    // collector constants

    public static final int collectorMotorID = 11;

    public static final double collectorMotorSpeed = .5;

    public static final int compressorModuleID = 14;

    // general constants
    
    public static final int robotContainerXboxController = 0;
}
