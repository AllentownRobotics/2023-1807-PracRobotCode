// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private CANSparkMax leftLead;
  private CANSparkMax leftFollow;
  private CANSparkMax rightLead;
  private CANSparkMax rightFollow;
  private DifferentialDrive driver;
  private MotorControllerGroup left;
  private MotorControllerGroup right;
  private DigitalInput IRSensor;
  public DriveTrain() 
  {
    leftLead = new CANSparkMax(1, MotorType.kBrushless);
    leftFollow = new CANSparkMax(0, MotorType.kBrushless);
    rightLead = new CANSparkMax(0, MotorType.kBrushless);
    rightFollow = new CANSparkMax(0, MotorType.kBrushless);


    left = new MotorControllerGroup(leftLead, leftFollow);
    right = new MotorControllerGroup(rightLead, rightFollow);
    left.setInverted(true);
    driver = new DifferentialDrive(left, right);

    IRSensor = new DigitalInput(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("Sensor", IRSensor.get());
  }

  public void drive(CommandXboxController controller)
  {
    driver.arcadeDrive(controller.getLeftY()*1.0, controller.getRightX()*1.0);
  }
}
