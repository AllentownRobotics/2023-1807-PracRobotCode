// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Collector extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  WPI_TalonFX collectMotor;
  DoubleSolenoid collectSolenoid;

  public Collector() {
    collectMotor = new WPI_TalonFX(Constants.collectormotorid);
    collectMotor.setNeutralMode(NeutralMode.Coast);
    collectSolenoid = new DoubleSolenoid(Constants.collectpneumaticid,PneumaticsModuleType.REVPH, Constants.collectpneumaticforward, Constants.collectpneumaticreverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  public void collect(boolean state)
  {
    if(state)
    {
      if(collectSolenoid.get().equals(Value.kReverse))
      {
        collectSolenoid.toggle();
      }
      collectMotor.set(ControlMode.Velocity, 1000);
    }
    else
    {
      if(collectSolenoid.get().equals(Value.kForward))
      {
        collectSolenoid.toggle();
      }
      collectMotor.set(ControlMode.Velocity, 0);
    }

  }
}
