// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.concurrent.CancellationException;

import javax.print.CancelablePrintJob;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxAbsoluteEncoder.Type;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Wrist extends SubsystemBase {
  private CANSparkMax wristMotor;
  private SparkMaxPIDController pid;
  private AbsoluteEncoder encoder;
  private double desiredAngle;
  private DoubleSolenoid pistons;

  private CANSparkMax wMotor1;
  private CANSparkMax wMotor2;

  /** Creates a new Wrist. */
  public Wrist() {
    wristMotor = new CANSparkMax(33, MotorType.kBrushless);

    pistons = new DoubleSolenoid(14, PneumaticsModuleType.REVPH, 0, 1);
    pid = wristMotor.getPIDController();
    pid.setP(0.02);
    pid.setI(0.0);
    pid.setD(0.0);
    pid.setFF(0.0);
    pid.setOutputRange(-.2, .2);
    
    encoder = wristMotor.getAbsoluteEncoder(Type.kDutyCycle);
    
    pid.setFeedbackDevice(encoder);
    encoder.setPositionConversionFactor(360);

    desiredAngle = 0;

    pistons.set(Value.kReverse);

    wMotor1 = new CANSparkMax(4, MotorType.kBrushless);
    wMotor2 = new CANSparkMax(2, MotorType.kBrushless);

    
    wMotor1.follow(wMotor2, true);
    wristMotor.setInverted(false);
    encoder.setInverted(false);
    pid.setPositionPIDWrappingEnabled(false);
    wristMotor.burnFlash();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    pid.setReference(desiredAngle, ControlType.kPosition);
    SmartDashboard.putNumber("angle", encoder.getPosition());
    SmartDashboard.putNumber("desiredangle", desiredAngle);

  }

  public void setAngle(double angle)
  {
    desiredAngle = angle;
  }

  public void setPistons(Value value)
  {
    pistons.set(value);
  }

  public void setMotors(double speed)
  {
    wMotor2.set(speed);
  }
}
