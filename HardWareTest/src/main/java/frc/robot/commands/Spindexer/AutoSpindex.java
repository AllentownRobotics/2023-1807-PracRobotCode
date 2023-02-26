// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Spindexer;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Spindexer.LowLevelCommands.SetSpindexerRotations;
import frc.robot.subsystems.Spindexer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoSpindex extends SequentialCommandGroup {
  /** Creates a new AutoSpindex. */
  public AutoSpindex(Spindexer spindexer) {
    addCommands(new SetSpindexerRotations(spindexer, -1.5),
                Commands.waitUntil(spindexer::atSetPoint),
                new SetSpindexerRotations(spindexer, 2),
                Commands.waitUntil(spindexer::atSetPoint));
  }
}
