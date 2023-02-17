// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;

public class Claw extends SubsystemBase {
  static DoubleSolenoid clawRetractor;
  static DoubleSolenoid clawExtender;
  static DoubleSolenoid rightClawExtender;
  /** Creates a new Claw. */
  public Claw() {
    clawRetractor = new DoubleSolenoid(PneumaticsModuleType.REVPH, 
    MechanismConstants.clawRetractorForwardChannel, MechanismConstants.clawRetractorReverseChannel);
    clawExtender = new DoubleSolenoid(PneumaticsModuleType.REVPH, 
    MechanismConstants.clawExtenderForwardChannel, MechanismConstants.clawExtenderReverseChannel);
  }
  public static void toggleClaw() {
    clawRetractor.toggle();
  }

  public static void toggleClawExtension() {
    clawExtender.toggle();
  }
}
