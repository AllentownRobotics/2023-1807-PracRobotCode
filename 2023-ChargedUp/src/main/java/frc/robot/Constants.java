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
    public static final int kDriverControllerPort = 0;
  }
  public static class ColorConstants {

    public static final int coneR = 255;

    public static final int coneG = 80;

    public static final int coneB = 0;

    public static final int cubeR = 190;

    public static final int cubeG = 20;

    public static final int cubeB = 220;

    public static final int redTeamR = 128;

    public static final int redTeamG = 0;

    public static final int redTeamB = 0;

    public static final int blueTeamR = 0;

    public static final int blueTeamG = 0;

    public static final int blueTeamB = 128;
  }
  public static class AnimNumberConstants {

    public static final int idleAnimNumber = 0;

    public static final int coneReqAnimNumber = 1;

    public static final int cubeReqAnimNumber = 2;

    public static final int coneTransportAnimNumber = 3;

    public static final int cubeTransportAnimNumber = 4;

    public static final int coneScoreAnimNumber = 5;

    public static final int cubeScoreAnimNumber = 6;

    public static final int endgameAnimNumber = 7;

    public static final int resetAnimNumber = 8;
  }
}
