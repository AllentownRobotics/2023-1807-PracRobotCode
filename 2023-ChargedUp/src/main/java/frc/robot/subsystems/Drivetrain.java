// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.sensors.WPI_Pigeon2;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  SwerveModule FL = new SwerveModule("FL", Constants.IDS_FRONTLEFT_DRIVEMOTOR, Constants.IDS_FRONTLEFT_TURNMOTOR, Constants.CHASSIS_FRONTLEFT_ANGULAROFFSET_RADIANS);
  SwerveModule FR = new SwerveModule("FR", Constants.IDS_FRONTRIGHT_DRIVEMOTOR, Constants.IDS_FRONTRIGHT_TURNMOTOR, Constants.CHASSIS_FRONTRIGHT_ANGULAROFFSET_RADIANS);
  SwerveModule BL = new SwerveModule("BL", Constants.IDS_BACKLEFT_DRIVEMOTOR, Constants.IDS_BACKLEFT_TURNMOTOR, Constants.CHASSIS_BACKLEFT_ANGULAROFFSET_RADIANS);
  SwerveModule BR = new SwerveModule("BR", Constants.IDS_BACKRIGHT_DRIVEMOTOR, Constants.IDS_BACKRIGHT_TURNMOTOR, Constants.CHASSIS_BACKRIGHT_ANGULAROFFSET_RADIANS);

  WPI_Pigeon2 gyro = new WPI_Pigeon2(Constants.IDS_GYRO);

  SwerveDriveOdometry odometry = new SwerveDriveOdometry(Constants.CHASSIS_KINEMATICS, gyro.getRotation2d(), getAllModulePositions());

  boolean fieldRelative = true;
  boolean locked = false;

  /** Creates a new Drivetrain. */
  public Drivetrain() {}

  /**
   * Drives the robot
   * @param xSpeed
   * @param ySpeed
   * @param rot
   */
  public void SwerveDrive(double xSpeed, double ySpeed, double rot){
    xSpeed *= Constants.CHASSIS_MAXSPEED_LINEAR_METERSPERSECOND;
    ySpeed *= Constants.CHASSIS_MAXSPEED_LINEAR_METERSPERSECOND;
    rot *= Constants.CHASSIS_MAXSPEED_ANGULAR_RADIANSPERSECOND;

    SwerveModuleState[] moduleStates = Constants.CHASSIS_KINEMATICS.toSwerveModuleStates(
      fieldRelative ?
        ChassisSpeeds.fromFieldRelativeSpeeds(xSpeed, ySpeed, rot, gyro.getRotation2d()) :
        new ChassisSpeeds(xSpeed, ySpeed, rot)
    );

    SwerveDriveKinematics.desaturateWheelSpeeds(moduleStates, Constants.CHASSIS_MAXSPEED_LINEAR_METERSPERSECOND);

    setAllModuleStates(moduleStates);
  }

  /**
   * Sets the desired states of all modules
   * @param moduleStates Desired state of all modules
   */
  public void setAllModuleStates(SwerveModuleState[] moduleStates){
    SwerveDriveKinematics.desaturateWheelSpeeds(moduleStates, Constants.CHASSIS_MAXSPEED_LINEAR_METERSPERSECOND);

    FL.setDesiredState(moduleStates[0]);
    FR.setDesiredState(moduleStates[1]);
    BL.setDesiredState(moduleStates[2]);
    BR.setDesiredState(moduleStates[3]);
  }


  /**
   * Sets the modules to an X formation to prevent unwanted movement
   */
  public void lockDown(){
    FL.setDesiredState(new SwerveModuleState(0, Rotation2d.fromDegrees(-45)));
    FR.setDesiredState(new SwerveModuleState(0, Rotation2d.fromDegrees(45)));
    BL.setDesiredState(new SwerveModuleState(0, Rotation2d.fromDegrees(45)));
    BR.setDesiredState(new SwerveModuleState(0, Rotation2d.fromDegrees(-45)));
  }

  /**
   * Toggles whether the drive function will be field relative or robot relative 
   * 
   * USED ONLY FOR BUTTON BINDINGS
   */
  public void toggleFieldRelative(){
    fieldRelative = !fieldRelative;
  }

  /**
   * Gets the current Pose2d of the robot
   * @return the current Pose2d of the robot
   */
  public Pose2d getPose(){
    return odometry.getPoseMeters();
  }

  /**
   * Resets the odometry to the given Pose2d
   * @param resetPose Pose2d for the odometry to reset to
   */
  public void resetOdometry(Pose2d resetPose){
    odometry.resetPosition(gyro.getRotation2d(), getAllModulePositions(), resetPose);
  }

  /**
   * Resets encoders of all modules to 0
   */
  public void resetEncoders(){
    FL.resetEncoder();
    FR.resetEncoder();
    BL.resetEncoder();
    BR.resetEncoder();
  }

  /**
   * Resets gyro to face 0 degrees
   */
  public void zeroHeading(){
    gyro.reset();
  }

  /**
   * Gets the position of all modules in correct order
   * @return Positions of all modules 
   */
  private SwerveModulePosition[] getAllModulePositions(){
    return new SwerveModulePosition[] {
      FL.getSwerveModulePosition(),
      FR.getSwerveModulePosition(),
      BL.getSwerveModulePosition(),
      BR.getSwerveModulePosition()
    };
  }

  @Override
  public void periodic() {
    odometry.update(gyro.getRotation2d(), getAllModulePositions());
  }
}
