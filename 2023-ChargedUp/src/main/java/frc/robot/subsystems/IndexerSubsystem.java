// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.ResourceBundle.Control;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IndexerSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
    public static Ultrasonic indexUltrasonic1;
    public static Ultrasonic indexUltrasonic2;

    private WPI_TalonSRX indexMotor;
    private WPI_TalonSRX feedMotor;
  public IndexerSubsystem() {
    indexUltrasonic1 = new Ultrasonic(1, 0);
    indexUltrasonic2 = new Ultrasonic(3, 2);

    indexMotor = new WPI_TalonSRX(Constants.INDEX_MOTOR);
    feedMotor = new WPI_TalonSRX(Constants.FEED_MOTOR);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  public void index(double rpm)
  {
    indexMotor.set(ControlMode.PercentOutput, -rpm);
    feedMotor.set(ControlMode.PercentOutput, -rpm);
  }
}