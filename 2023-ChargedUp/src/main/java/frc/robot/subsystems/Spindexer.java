// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Spindexer extends SubsystemBase {
  public static CANSparkMax indexMotor;
  /** Creates a new Spindexer. */
  public Spindexer() {
    indexMotor = new CANSparkMax(Constants.spindexerMotorID, MotorType.kBrushless);
  }

  public static void Index(double speed) {
    // This method will be called once per scheduler run
    indexMotor.set(speed);
  }
}
