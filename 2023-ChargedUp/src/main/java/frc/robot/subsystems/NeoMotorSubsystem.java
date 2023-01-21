// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class NeoMotorSubsystem extends SubsystemBase {

  


  private CANSparkMax m_Motor;
  /** Creates a new NeoMotor. */

  public NeoMotorSubsystem() {
    m_Motor = new CANSparkMax(Constants.MotorID, MotorType.kBrushless);

    m_Motor.restoreFactoryDefaults();

  }

  public void control(XboxController m_joystick){
    m_Motor.set(m_joystick.getLeftY());
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
