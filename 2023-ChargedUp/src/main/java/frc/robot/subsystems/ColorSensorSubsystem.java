// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;


public class ColorSensorSubsystem extends SubsystemBase {



  //Color sensor
  I2C.Port i2cPort;
  ColorSensorV3 m_colorSensor;

  private ColorMatch m_colorMatch;
  private Color detectedColor;
  public String colorString = "Null";

  //Colors
  private final Color PURPLE = new Color(0.6, 0.1, 0.9);
  private final Color YELLOW = new Color(0.9, 0.9, 0);


  /** Creates a new ColorSensor. */
  public ColorSensorSubsystem() {
    i2cPort = I2C.Port.kOnboard;
    m_colorSensor = new ColorSensorV3(i2cPort);

    System.out.println("Color Sensor Subsystem Initialized");
  }

  public String ColorDetect() {
    m_colorMatch.addColorMatch(PURPLE);
    m_colorMatch.addColorMatch(YELLOW);
    //Detecting and result 
    detectedColor = m_colorSensor.getColor();

    ColorMatchResult matchResult = m_colorMatch.matchClosestColor(detectedColor);
  
      //Matching Colors 
    if (matchResult.color.equals(PURPLE)) {
    colorString = "Purple";
    } else if (matchResult.color.equals(YELLOW)) {
    colorString = "Yellow";
    } else {
    colorString = "Other";
    }
  
    //Printing all values to the SmartDash
    SmartDashboard.putString("Color", colorString);
    return colorString;
  }

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
