// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;
import frc.robot.subsystems.ColorSensorSubsystem;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ColorSensorSubsystem extends SubsystemBase {



  //Color sensor
  I2C.Port i2cPort;
  ColorSensorV3 m_colorSensor;



  /** Creates a new ColorSensor. */
  public ColorSensorSubsystem() {
    i2cPort = I2C.Port.kOnboard;
    m_colorSensor = new ColorSensorV3(i2cPort);

    System.out.println("Color Sensor Subsystem Initialized");
  }

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
