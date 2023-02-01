// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DrivetrainSubsystem extends SubsystemBase {  
    public boolean brakeOn = false;
    public boolean neutralSteeringOn = false;


    private WPI_TalonFX leftMotorOne = new WPI_TalonFX(Constants.LEFT_MOTOR_ONE);;
    private WPI_TalonFX leftMotorTwo = new WPI_TalonFX(Constants.LEFT_MOTOR_TWO);
    private WPI_TalonFX leftMotorThree = new WPI_TalonFX(Constants.LEFT_MOTOR_THREE);
    private WPI_TalonFX rightMotorOne = new WPI_TalonFX(Constants.RIGHT_MOTOR_ONE);
    private WPI_TalonFX rightMotorTwo = new WPI_TalonFX(Constants.RIGHT_MOTOR_TWO);
    private WPI_TalonFX rightMotorThree = new WPI_TalonFX(Constants.RIGHT_MOTOR_THREE);

    private MotorControllerGroup left = new MotorControllerGroup(leftMotorOne, leftMotorTwo, leftMotorThree);
    private MotorControllerGroup right = new MotorControllerGroup(rightMotorOne, rightMotorTwo, rightMotorThree);

    public DifferentialDrive drive = new DifferentialDrive(left, right);

  public DrivetrainSubsystem() {
    
    leftMotorOne.setNeutralMode(NeutralMode.Coast);
    leftMotorTwo.setNeutralMode(NeutralMode.Coast);
    leftMotorThree.setNeutralMode(NeutralMode.Coast);
    rightMotorOne.setNeutralMode(NeutralMode.Coast);
    rightMotorTwo.setNeutralMode(NeutralMode.Coast);
    rightMotorThree.setNeutralMode(NeutralMode.Coast);

    right.setInverted(true);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

public void toggleTurnInPlace(){
  neutralSteeringOn = !neutralSteeringOn;
}

public void toggleBrake(){
  if (brakeOn){
    leftMotorOne.setNeutralMode(NeutralMode.Coast);
    leftMotorTwo.setNeutralMode(NeutralMode.Coast);
    leftMotorThree.setNeutralMode(NeutralMode.Coast);
    rightMotorOne.setNeutralMode(NeutralMode.Coast);
    rightMotorTwo.setNeutralMode(NeutralMode.Coast);
    rightMotorThree.setNeutralMode(NeutralMode.Coast);

    brakeOn = false;
  } else {
    leftMotorOne.setNeutralMode(NeutralMode.Brake);
    leftMotorTwo.setNeutralMode(NeutralMode.Brake);
    leftMotorThree.setNeutralMode(NeutralMode.Brake);
    rightMotorOne.setNeutralMode(NeutralMode.Brake);
    rightMotorTwo.setNeutralMode(NeutralMode.Brake);
    rightMotorThree.setNeutralMode(NeutralMode.Brake);

    brakeOn = true;
  }
}

public void drive(){
  drive.curvatureDrive(RobotContainer.m_xboxController.getRightTriggerAxis(), RobotContainer.m_xboxController.getLeftX(), neutralSteeringOn);
}

}