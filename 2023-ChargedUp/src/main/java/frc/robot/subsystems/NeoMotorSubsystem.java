// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;


public class NeoMotorSubsystem extends SubsystemBase {

  private SparkMaxPIDController m_pidController;
  private RelativeEncoder m_encoder;
  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;
  public double rotations;
  private CANSparkMax m_motor;
  

  /** Creates a new NeoMotor. */

  public NeoMotorSubsystem() {
    m_motor = new CANSparkMax(Constants.MotorID, MotorType.kBrushless);

    m_motor.restoreFactoryDefaults();

    m_pidController = m_motor.getPIDController();

     // PID coefficients
    kP = 0.1; 
    kI = 1e-4;
    kD = 1; 
    kIz = 0; 
    kFF = 0; 
    kMaxOutput = 1; 
    kMinOutput = -1;
    rotations = 0;

    // set PID coefficients
    m_pidController.setP(kP);
    m_pidController.setI(kI);
    m_pidController.setD(kD);
    m_pidController.setIZone(kIz);
    m_pidController.setFF(kFF);
    m_pidController.setOutputRange(kMinOutput, kMaxOutput);  
    
  }

  public void control(XboxController m_joystick){
    rotations = SmartDashboard.getNumber("Set Rotations", 0);

    m_pidController.setReference(rotations, CANSparkMax.ControlType.kPosition);

    m_motor.set(m_joystick.getLeftY());
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
