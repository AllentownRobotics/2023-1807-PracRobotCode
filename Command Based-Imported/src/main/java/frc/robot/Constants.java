package frc.robot;

public class Constants {


    //drivetrain constants (DT)
    public static final int DT_LFT_MOTOR_ONE_ID = 1;

    public static final int DT_LFT_MOTOR_TWO_ID = 2;
 
    public static final int DT_LFT_MOTOR_THREE_ID = 3;
 
    public static final int DT_RGHT_MOTOR_ONE_ID = 4;
 
    public static final int DT_RGHT_MOTOR_TWO_ID = 5;
 
    public static final int DT_RGHT_MOTOR_THREE_ID = 6;
    
    public static final int DT_GYRO_ID = 0;


    //collector constants (CO)
    public static final int CO_MOTOR = 7;

    public static final int CO_EXTEND_PISTON_ID = 8;

    public static final int CO_EXTEND_PISTON_FORWARD = 0;

    public static final int CO_EXTEND_PISTON_REVERSE = 1;

    public static final double CO_MOTOR_SPEED = 0.8;


    //indexer constants (IN)
    public static final int IN_MOTOR_ID = 9;

    public static final int IN_MOTOR_FEED = 10;

    public static final double IN_MOTOR_SPEED = 0.8;


    //shooter constants (SH)
    public static final int SH_MOTOR_MASTER_ID = 11;
    
    public static final int SH_MOTOR_FOLLOW_ID = 12;

    public static final int SH_HOOD_PISTON_ID = 13;

    public static final int SH_HOOD_PISTON_FORWARD = 2;

    public static final int SH_HOOD_PISTON_BACKWARD = 3;

    public static final int SH_IDLE_RPM = 500;

    public static final int SH_SHOOT_LOW_RPM = 5000;

    public static final int SH_SHOOT_MID_RPM = 4400;

    public static final int SH_SHOOT_HIGH_RPM = 5100;

    public static final int SH_SHOOT_VERY_HIGH_RPM = 6250;

    public static final double SHkP = 0.2;

    public static final double SHkI = 0;

    public static final double SHkD = 0;

    public static final double SHkF = 0;


    //compressor constants (CM)
    public static final int CMID = 14;

    public static final double CM_RANGE_MIN = 60;

    public static final double CM_RANGE_MAX = 120;


    //climb constants (CB)
    public static final int CB_LFT_EXTENDED = 18000;

    public static final int CB_LFT_RETRACTED = -180000;

    public static final int CB_RGHT_EXTENDED = 18000;

    public static final int CB_RGHT_RETRACTED = -180000;

    public static final int CB_PISTON_FORWARD = 0;

    public static final int CB_PISTON_REVERSE = 1;

    public static final int CB_LFT_ID = 15;

    public static final int CB_RGHT_ID = 16;

    public static final int CB_PISTON_ID = 17;


    //driver controller constants
    public static final int CTRL_FOR_DRIVER = 0;

    public static final int CTRL_FOR_OPERATOR = 1;

    public static final int CTRL_FOR_DRIVER_MOVE_AXIS = 2;

    public static final int CTRL_FOR_DRIVER_ROTATE_AXIS = 2;

}
