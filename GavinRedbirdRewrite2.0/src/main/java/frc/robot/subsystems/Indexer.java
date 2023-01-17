// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Ultrasonic;
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
    indexUltrasonic1.setAutomaticMode(true);
    indexUltrasonic2.setAutomaticMode(true);
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

  public static boolean sensorBottom()
  {
    if(indexUltrasonic1.getRangeInches()<7 || indexUltrasonic1.getRangeInches()>20)
    {
     return true;
    }
    else
    {
      return false;
    }
  }
  public static boolean sensorTop()
  {
    if(indexUltrasonic2.getRangeInches()<7 || indexUltrasonic2.getRangeInches()>20)
    {
     return true;
    }
    else
    {
      return false;
    }
  }
}
