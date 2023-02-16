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
<<<<<<< Updated upstream
public final class Constants {}
=======
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    
    public static final int kOperatorControllerPort = 1;
  }
  public static final int compressorModuleID = 14;

  public static final int leftArmPistonForwardChannel = 0;

  public static final int leftArmPistonReverseChannel = 1;

  public static final int rightArmPistonForwardChannel = 2;

  public static final int rightArmPistonReverseChannel = 3;

  public static final int clawRetractorForwardChannel = 4;

  public static final int clawRetractorReverseChannel = 5;

  public static final int leftClawExtenderForwardChannel = 6;

  public static final int leftClawExtenderReverseChannel = 7;
  
  public static final int rightClawExtenderForwardChannel = 8;

  public static final int rightClawExtenderReverseChannel = 9;
}
>>>>>>> Stashed changes
