// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import javax.print.CancelablePrintJob;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private CANSparkMax leftLead;
  private CANSparkMax leftFollow;
  private CANSparkMax rightLead;
  private CANSparkMax rightFollow;
  private DifferentialDrive driver;
  public DriveTrain() 
  {
    leftLead = new CANSparkMax(DriveConstants.leftLeadid, MotorType.kBrushless);
    leftFollow = new CANSparkMax(DriveConstants.leftFollowid, MotorType.kBrushless);
    rightLead = new CANSparkMax(DriveConstants.rightLeadid, MotorType.kBrushless);
    rightFollow = new CANSparkMax(DriveConstants.rightFollowid, MotorType.kBrushless);

    leftFollow.follow(leftLead);
    rightFollow.follow(rightLead);
    driver = new DifferentialDrive(leftLead, rightLead);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(XboxController controller)
  {
    driver.arcadeDrive(controller.getLeftY(), controller.getRightX());
  }
}
