// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SpindexerConstants;

public class Spindexer extends SubsystemBase {
  CANSparkMax motor = new CANSparkMax(SpindexerConstants.SPINDEXER_MOTOR_ID, MotorType.kBrushless);

  ColorSensorV3 colorSensor = new ColorSensorV3(I2C.Port.kOnboard);

  public Spindexer() {
    motor.setIdleMode(IdleMode.kBrake);

    motor.burnFlash();
  }

  @Override
  public void periodic() {
    SmartDashboard.putString("Color Sensor", colorMatch(colorSensor.getColor()));
  }

  public void spindex(double direction){
    motor.set(direction * SpindexerConstants.SPINDEXER_MOTOR_MAXOUTPUT);
  }

  public String colorMatch(Color sensedColor){
    double sRed = sensedColor.red;
    double sGreen = sensedColor.green;
    double sBlue = sensedColor.blue;

    double cubeThreshold = SpindexerConstants.COLORSENSOR_THRESHOLD_CUBE;
    double coneThreshold = SpindexerConstants.COLORSENSOR_THRESHOLD_CONE;

    Color cubeColor = SpindexerConstants.COLORSENSOR_COLOR_CUBE;
    Color coneColor = SpindexerConstants.COLORSENSOR_COLOR_CONE;

    byte cubeMatch = 0b000;
    byte coneMatch = 0b000;

    // Cube red
    if (sRed <= cubeColor.red + cubeThreshold && sRed >= cubeColor.red - cubeThreshold){
      cubeMatch += 0b100;
    }
    // Cube green
    if (sGreen <= cubeColor.green + cubeThreshold && sGreen >= cubeColor.green - cubeThreshold){
      cubeMatch += 0b010;
    }
    // Cube Blue
    if (sBlue <= cubeColor.blue + cubeThreshold && sBlue >= cubeColor.blue - cubeThreshold){
      cubeMatch += 0b001;
    }

    // Cone red
    if (sRed <= coneColor.red + coneThreshold && sRed >= coneColor.red - coneThreshold){
      coneMatch += 0b100;
    }
    // Cone green
    if (sGreen <= coneColor.green + coneThreshold && sGreen >= coneColor.green - coneThreshold){
      coneMatch += 0b010;
    }
    // Cone Blue
    if (sBlue <= coneColor.blue + coneThreshold && sBlue >= coneColor.blue - coneThreshold){
      coneMatch += 0b001;
    }

    // Results parse
    // Prioritize cone in all cases because of angle being higher
    if(coneMatch == 0b111 && cubeMatch != 0b111){
      return "Cone Match";
    }
    else if(cubeMatch == 0b111 && coneMatch != 0b111){
      return "Cube Match";
    }
    else if(coneMatch == 0b111 && cubeMatch == 0b111){
      return "Cone Match";
    }

    return "Null Match";
  }
}
