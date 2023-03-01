// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Arm.NodeCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.ArmConstants;
import frc.robot.Enums.WristState;
import frc.robot.commands.Arm.WaitForPlace;
import frc.robot.commands.Arm.LowLevelCommands.SetArmAngle;
import frc.robot.commands.Claw.LowLevelCommands.SetWristState;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Claw;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class HighNode extends SequentialCommandGroup {
  /**
   * Sequential command group that sets the wrist state down then actuates the arm for placement at high nodes.
   * Ends after the currently held game piece is dropped
   * @param arm Arm subsystem
   * @param claw Claw subsystem
   * @param controller Operator controller
   */
  public HighNode(Arm arm, Claw claw, CommandXboxController controller) {
    addCommands(new SetWristState(claw, WristState.WristOut),
                new WaitForPlace(arm, new SetArmAngle(arm, ArmConstants.ANGLE_CONE_HIGH, ArmConstants.ANGLE_CUBE_HIGH), controller));
  }
}
