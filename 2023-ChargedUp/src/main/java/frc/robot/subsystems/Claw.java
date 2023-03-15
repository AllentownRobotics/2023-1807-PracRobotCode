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
  static DoubleSolenoid clawExtenderLeft;
  static DoubleSolenoid clawExtenderRight;

  /** Creates a new Claw. */
  public Claw() {
    clawWrist = new DoubleSolenoid(PneumaticsModuleType.REVPH, 
    MechanismConstants.clawWristForwardChannel, MechanismConstants.clawWristReverseChannel);
    clawExtenderLeft = new DoubleSolenoid(PneumaticsModuleType.REVPH, 
    MechanismConstants.clawExtenderLeftForwardChannel, MechanismConstants.clawExtenderLeftReverseChannel);
    clawExtenderRight = new DoubleSolenoid(PneumaticsModuleType.REVPH, 
    MechanismConstants.clawExtenderRightForwardChannel, MechanismConstants.clawExtenderRightReverseChannel);
  }
  public static void OpenClawWrist() {
    clawWrist.set(Value.kReverse);
  }
  public static void CloseClawWrist() {
    clawWrist.set(Value.kForward);
  }

  public static void ClawExtensionForward() {
    clawExtenderLeft.set(Value.kReverse);
    clawExtenderRight.set(Value.kReverse);
  }
  public static void ClawExtensionRetract() {
    clawExtenderLeft.set(Value.kForward);
    clawExtenderRight.set(Value.kForward);
  }
}
