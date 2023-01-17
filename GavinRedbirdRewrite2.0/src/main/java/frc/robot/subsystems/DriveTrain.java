// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
    private WPI_TalonFX leftMotorOne;
    private WPI_TalonFX leftMotorTwo;
    private WPI_TalonFX leftMotorThree;
  
    private WPI_TalonFX rightMotorFour;
    private WPI_TalonFX rightMotorFive;
    private WPI_TalonFX rightMotorSix;

    private MotorControllerGroup left;
    private MotorControllerGroup right;

    private DifferentialDrive drive;

  public DriveTrain() {
    leftMotorOne = new WPI_TalonFX(Constants.lm1);
    leftMotorTwo = new WPI_TalonFX(Constants.lm2);
    leftMotorTwo = new WPI_TalonFX(Constants.lm3);
    rightMotorFour = new WPI_TalonFX(Constants.rm4);
    rightMotorFive = new WPI_TalonFX(Constants.rm5);
    rightMotorSix = new WPI_TalonFX(Constants.rm6);
    
    leftMotorOne.setNeutralMode(NeutralMode.Coast);
    leftMotorTwo.setNeutralMode(NeutralMode.Coast);
    leftMotorThree.setNeutralMode(NeutralMode.Coast);
    rightMotorFour.setNeutralMode(NeutralMode.Coast);
    rightMotorFive.setNeutralMode(NeutralMode.Coast);
    rightMotorSix.setNeutralMode(NeutralMode.Coast);

    left = new MotorControllerGroup(leftMotorOne, leftMotorTwo, leftMotorThree);
    right = new MotorControllerGroup(rightMotorFour, rightMotorFive, rightMotorSix);

    right.setInverted(true);

    drive = new DifferentialDrive(left, right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  public void drive(XboxController joy)
  {
    drive.curvatureDrive(joy.getLeftY()*Constants.SpeedMult, joy.getRightX()*Constants.TurnMult, joy.getRightBumper());
  }

  public void brakeButton(boolean brake) 
  {
    if(brake)
    {
      leftMotorOne.setNeutralMode(NeutralMode.Brake);
      leftMotorTwo.setNeutralMode(NeutralMode.Brake);
      leftMotorThree.setNeutralMode(NeutralMode.Brake);
      rightMotorFour.setNeutralMode(NeutralMode.Brake);
      rightMotorFive.setNeutralMode(NeutralMode.Brake);
      rightMotorSix.setNeutralMode(NeutralMode.Brake);
    }
    else
    {
      leftMotorOne.setNeutralMode(NeutralMode.Coast);
      leftMotorTwo.setNeutralMode(NeutralMode.Coast);
      leftMotorThree.setNeutralMode(NeutralMode.Coast);
      rightMotorFour.setNeutralMode(NeutralMode.Coast);
      rightMotorFive.setNeutralMode(NeutralMode.Coast);
      rightMotorSix.setNeutralMode(NeutralMode.Coast);
    }
  }
}
