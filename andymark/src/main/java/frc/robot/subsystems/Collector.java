// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;

public class Collector extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private CANSparkMax topCollectMotor;
  private CANSparkMax bottomCollectMotor;
  private static DigitalInput beamBreak;
  public Collector() 
  {
    topCollectMotor = new CANSparkMax(Constants.topCollectorid, MotorType.kBrushless);
    bottomCollectMotor = new CANSparkMax(Constants.bottomCollectorid, MotorType.kBrushless);
    topCollectMotor.setIdleMode(IdleMode.kBrake);
    bottomCollectMotor.setIdleMode(IdleMode.kBrake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void collect(double speed)
  {
    topCollectMotor.set(speed);
    bottomCollectMotor.set(speed);
  }
  public void stop()
  {
    topCollectMotor.set(0);
    topCollectMotor.setIdleMode(IdleMode.kBrake);
    bottomCollectMotor.set(0);
    bottomCollectMotor.setIdleMode(IdleMode.kBrake);
  }
}
