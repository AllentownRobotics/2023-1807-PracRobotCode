// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClawConstants;

public class Claw extends SubsystemBase {

  DoubleSolenoid wristPiston = new DoubleSolenoid(PneumaticsModuleType.REVPH, ClawConstants.WRIST_CHANNEL_FORWARD, ClawConstants.WRIST_CHANNEL_BACKWARD);
  DoubleSolenoid clawPiston = new DoubleSolenoid(PneumaticsModuleType.REVPH, ClawConstants.CLAW_CHANNEL_FORWARD, ClawConstants.CLAW_CHANNEL_BACKWARD);
  
  boolean wristOut = false;
  boolean holding = false;

  public Claw() {
  }

  public boolean getHolding(){
    return holding;
  }

  public boolean getWristStraight(){
    return wristOut;
  }

  public void setHolding(boolean hold){
    holding = hold;
  }

  public void setWristOut(boolean wristStraight){
    wristOut = wristStraight;
  }

  public void toggleHold(){
    holding = !holding;
  }

  public void toggleWrist(){
    wristOut = !wristOut;
  }

  @Override
  public void periodic() {
    wristPiston.set(wristOut ? Value.kForward : Value.kReverse);
    clawPiston.set(holding ? Value.kReverse : Value.kForward);
  }
}
