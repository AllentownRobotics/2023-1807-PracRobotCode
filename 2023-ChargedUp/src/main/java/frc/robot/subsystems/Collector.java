// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Collector extends SubsystemBase {
  public static CANSparkMax lowerMotor;
  public static CANSparkMax upperMotor;
  /** Creates a new Collector. */
  public Collector() {
    lowerMotor = new CANSparkMax(Constants.collectorLowerMotorID, MotorType.kBrushless);
    upperMotor = new CANSparkMax(Constants.collectorUpperMotorID, MotorType.kBrushless);
  }

  public static void Collect() {
    // This method will be called once per scheduler run
    lowerMotor.set(.5);
    upperMotor.set(-.5);
  }
}
