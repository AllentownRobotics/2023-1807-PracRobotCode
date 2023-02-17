// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;

public class Arm extends SubsystemBase {
  static DoubleSolenoid leftArmPiston;
  static DoubleSolenoid rightArmPiston;
  /** Creates a new Arm. */
  public Arm() {
    leftArmPiston = new DoubleSolenoid(PneumaticsModuleType.REVPH, 
    MechanismConstants.leftArmPistonForwardChannel, MechanismConstants.leftArmPistonReverseChannel);
    rightArmPiston = new DoubleSolenoid(PneumaticsModuleType.REVPH, 
    MechanismConstants.rightArmPistonForwardChannel, MechanismConstants.rightArmPistonReverseChannel);    
  }

  public static void toggleArm() {
    leftArmPiston.toggle();
    rightArmPiston.toggle();
  }
}
