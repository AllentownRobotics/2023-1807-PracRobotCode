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

public class Indexer extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private CANSparkMax indexMotor;
  private static DigitalInput beamBreak;
  public Indexer() 
  {
    indexMotor = new CANSparkMax(DriveConstants.indexMotorid, MotorType.kBrushless);
    indexMotor.setIdleMode(IdleMode.kBrake);
    beamBreak = new DigitalInput(Constants.beamBreakChannel);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public static boolean getBeamBreak() {
    return beamBreak.get();
  }
  public void spin(double speed)
  {
    indexMotor.set(speed);
    
  }
  public void stop()
  {
    indexMotor.set(0);
    indexMotor.setIdleMode(IdleMode.kBrake);
  }
}
