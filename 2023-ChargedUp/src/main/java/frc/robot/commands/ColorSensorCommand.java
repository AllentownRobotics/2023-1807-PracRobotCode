// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ColorSensorSubsystem;

public class ColorSensorCommand extends CommandBase {

  private ColorMatch m_colorMatch;
  private Color detectedColor;
  public String colorString = "Null";
  private ColorSensorV3 m_colorSensor = RobotContainer.m_colorSensor;

  //Colors
  private final Color PURPLE = new Color(0.6, 0.1, 0.9);
  private final Color YELLOW = new Color(0.9, 0.9, 0);

  /** Creates a new ColorSensorCommand. */
  public ColorSensorCommand(ColorSensorSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Color Sensor Command Initialized");

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

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
    }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("Color Sensor Command Ended"); // print to log that the command stopped 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
