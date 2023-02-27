// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Spindexer;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Spindexer.LowLevelCommands.SetSpindexerRotations;
import frc.robot.subsystems.Spindexer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoSpindex extends SequentialCommandGroup {
  /**
   * Sequential command group that rotates the spindexer counter clockwise for one and a half rotations,
   * resets the encoder and the desired rotation, then rotates it clockwise for one rotation and ends
   * after resetting the enoder and desired rotations again
   */
  public AutoSpindex(Spindexer spindexer) {
    addCommands(new SetSpindexerRotations(spindexer, -1.5),
                Commands.waitUntil(spindexer::atSetPoint),
                new ParallelCommandGroup(Commands.runOnce(() -> spindexer.setDesiredRotation(0)),
                                          Commands.runOnce(() -> spindexer.zeroEncoder())),
                new SetSpindexerRotations(spindexer, 2),
                Commands.waitUntil(spindexer::atSetPoint),
                new ParallelCommandGroup(Commands.runOnce(() -> spindexer.setDesiredRotation(0)),
                                          Commands.runOnce(() -> spindexer.zeroEncoder())));
  }
}
