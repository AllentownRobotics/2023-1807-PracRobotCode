// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

public class NeoMotorSubsystem extends SubsystemBase {

  private CANSparkMax m_motor;
  private RelativeEncoder m_encoder;
  private double speed;

  /** Creates a new NeoMotor. */

  public NeoMotorSubsystem() {
    m_motor = new CANSparkMax(Constants.MotorID, MotorType.kBrushless);

    m_motor.restoreFactoryDefaults();
    
    m_encoder = m_motor.getEncoder();

  }

  public void control(double among_us){
    m_motor.set(among_us);
  }

  public double getSpeed(){
    speed = m_encoder.getVelocity();
    return speed;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
