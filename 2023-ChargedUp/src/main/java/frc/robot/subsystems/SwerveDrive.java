// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;

public class SwerveDrive extends SubsystemBase {
  SwerveModule fL = new SwerveModule("FL", DrivetrainConstants.driveMotorFL_ID, 
  DrivetrainConstants.turnMotorFL_ID, DrivetrainConstants.fLModuleAngularOffset);

  SwerveModule fR = new SwerveModule("FR", DrivetrainConstants.driveMotorFR_ID, 
  DrivetrainConstants.turnMotorFR_ID, DrivetrainConstants.fRModuleAngularOffset);

  SwerveModule bL = new SwerveModule("BL", DrivetrainConstants.driveMotorBL_ID, 
  DrivetrainConstants.turnMotorBL_ID, DrivetrainConstants.bLModuleAngularOffset);

  SwerveModule bR = new SwerveModule("BR", DrivetrainConstants.driveMotorBR_ID, 
  DrivetrainConstants.turnMotorBR_ID, DrivetrainConstants.bRModuleAngularOffset);
  /** Creates a new SwerveDrive. */
  public SwerveDrive() {}

  public void drivetrain(double x, double y, double rotation) {
    x = DrivetrainConstants.drivetrainLinearTopSpeed;
    y = DrivetrainConstants.drivetrainLinearTopSpeed;
    rotation = DrivetrainConstants.drivetrainAngularTopSpeed;

    fL.setDesiredState(SwerveModule.getState());
    fR.setDesiredState(SwerveModule.getState());
    bL.setDesiredState(SwerveModule.getState());
    bR.setDesiredState(SwerveModule.getState());

    }
}
