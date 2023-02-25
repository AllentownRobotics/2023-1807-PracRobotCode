// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.Arm.LowLevelCommands.SetArmAngle;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ResetArm extends SequentialCommandGroup {
  /** Creates a new ResetArm. */
  public ResetArm(RobotContainer rc) {
    SetArmAngle resetCheckPoint = new SetArmAngle(
      rc.arm, 35.0);
    Command waitForArm = Commands.waitUntil(rc.arm::atSetPoint);
    Command finalLower = Commands.run(() -> rc.arm.runAtSpeed(-0.025), rc.arm).until(rc.arm::atReset);

    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(resetCheckPoint, waitForArm, finalLower);
  }
}
