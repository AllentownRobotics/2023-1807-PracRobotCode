// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FlyWheel extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  WPI_TalonFX lead;
  WPI_TalonFX follow;

  public FlyWheel() {
    lead = new WPI_TalonFX(Constants.flyid1);
    follow = new WPI_TalonFX(Constants.flyid2);
    follow.follow(lead);
    lead.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  public void shoot(int rpm)
  {
    lead.set(TalonFXControlMode.Velocity,rpm);
  }
}
