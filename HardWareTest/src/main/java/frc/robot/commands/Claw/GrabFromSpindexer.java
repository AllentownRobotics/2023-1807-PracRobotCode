// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Claw;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.Claw.LowLevelCommands.SetHolding;
import frc.robot.commands.Claw.LowLevelCommands.SetWristOut;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Claw;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class GrabFromSpindexer extends SequentialCommandGroup {
  /** Creates a new GrabFromSpindexer. */
  public GrabFromSpindexer(Claw claw, Arm arm) {
    addCommands(Commands.waitUntil(arm::atReset),
                new SetWristOut(claw, false),
                new WaitCommand(0.1),
                new SetHolding(claw, true),
                new WaitCommand(0.2),
                new SetWristOut(claw, true));
  }
}
