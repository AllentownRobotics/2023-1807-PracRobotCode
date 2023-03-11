// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;

public class Claw extends SubsystemBase {
  static DoubleSolenoid clawWrist;
  static DoubleSolenoid clawExtender;
  static DoubleSolenoid rightClawExtender;

  /** Creates a new Claw. */
  public Claw() {
    clawWrist = new DoubleSolenoid(PneumaticsModuleType.REVPH, 
    MechanismConstants.clawWristForwardChannel, MechanismConstants.clawWristReverseChannel);
    clawExtender = new DoubleSolenoid(PneumaticsModuleType.REVPH, 
    MechanismConstants.clawExtenderForwardChannel, MechanismConstants.clawExtenderReverseChannel);
  }
  public static void OpenClawWrist() {
    clawWrist.set(Value.kReverse);
  }
  public static void CloseClawWrist() {
    clawWrist.set(Value.kForward);
  }

  public static void ClawExtensionForward() {
    clawExtender.set(Value.kReverse);
  }
  public static void ClawExtensionRetract() {
    clawExtender.set(Value.kForward);
  }
}
