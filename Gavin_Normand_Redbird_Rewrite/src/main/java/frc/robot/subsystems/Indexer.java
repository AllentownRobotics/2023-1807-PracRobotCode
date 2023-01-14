// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Indexer extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
    public static Ultrasonic indexUltrasonic1;
    public static Ultrasonic indexUltrasonic2;

    private WPI_TalonSRX indexMotor;
    private WPI_TalonSRX feedMotor;
  public Indexer() {
    indexUltrasonic1 = new Ultrasonic(1, 0);
    indexUltrasonic2 = new Ultrasonic(3, 2);

    indexMotor = new WPI_TalonSRX(Constants.indexmotorid);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  public void index(int rpm)
  {
    indexMotor.set(rpm);
  }
  public void feed(int rpm)
  {
    feedMotor.set(rpm);
  }
  
}
