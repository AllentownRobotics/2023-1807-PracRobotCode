// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.Arm.LowLevelCommands.SetArmAngle;
import frc.robot.commands.Claw.SetWristToStandBy;
import frc.robot.commands.Claw.LowLevelCommands.SetWristOut;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ResetArm extends SequentialCommandGroup {
  /** Creates a new ResetArm. */
  public ResetArm(RobotContainer rc) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new SetWristOut(rc.claw, false),
                new SetArmAngle(rc.arm, 35.0), 
                Commands.waitUntil(rc.arm::atSetPoint),  
                new ParallelCommandGroup(Commands.run(() -> rc.arm.runAtSpeed(-0.025), rc.arm).until(rc.arm::atReset), 
                                          new SetWristToStandBy(rc.claw)));
  }
}
