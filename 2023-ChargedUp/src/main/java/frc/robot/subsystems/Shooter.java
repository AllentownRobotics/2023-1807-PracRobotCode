// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {

    public static WPI_TalonFX shooterLeft;
    public static WPI_TalonFX shooterRight;
  /** Creates a new Shooter. */
  public Shooter() {
    shooterLeft = new WPI_TalonFX(Constants.shooterLeftMotor);
    shooterRight = new WPI_TalonFX(Constants.shooterRightMotor);
    shooterRight.setInverted(true);
  }
  public void Shoot() {
    shooterLeft.set(ControlMode.Velocity, Constants.shooterTargetRPM);
    shooterRight.set(ControlMode.Velocity, Constants.shooterTargetRPM);
  }
  public void StopShooting() {
    shooterLeft.set(0);
    shooterRight.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
