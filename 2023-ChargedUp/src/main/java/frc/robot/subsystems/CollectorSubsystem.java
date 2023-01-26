// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CollectorSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  WPI_TalonFX collectMotor;
  DoubleSolenoid collectSolenoid;

  public CollectorSubsystem() {
    collectMotor = new WPI_TalonFX(Constants.COLLECTOR_MOTOR);
    collectMotor.setNeutralMode(NeutralMode.Coast);
    collectSolenoid = new DoubleSolenoid(Constants.COLLECTOR_PNEUMATIC,PneumaticsModuleType.REVPH, Constants.PNEUMATIC_FOWARD, Constants.PNEUMATIC_REVERSE);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  public void collect()
  {
    collectSolenoid.set(Value.kForward);
    collectMotor.set(ControlMode.PercentOutput,.35);
  }
  public void retract()
  {
    collectSolenoid.set(Value.kReverse);
    collectMotor.set(ControlMode.PercentOutput,0);
  }

  public double get() {
    return collectMotor.get();
  }
}