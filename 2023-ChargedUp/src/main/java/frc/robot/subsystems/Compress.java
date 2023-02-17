// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;;

public class Compress extends SubsystemBase {
  static Compressor compressor;
  /** Creates a new Compress. */
  public Compress() {
    compressor = new Compressor(MechanismConstants.compressorModuleID, PneumaticsModuleType.REVPH);
  }

  public static void runCompressor() {
    // This method will be called once per scheduler run
    compressor.enableAnalog(60, 120);
  }
}
