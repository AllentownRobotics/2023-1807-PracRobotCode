// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class LEDCommand extends CommandBase {
  public int animNumber;
  // 0 = red, 1 = green, 2 = blue, 3 = rainbow, 4 = blink, 5 = none
  /** Creates a new LEDCommand. */
  public LEDCommand(int animNumber) {
    this.animNumber = animNumber;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.led);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    switch (animNumber) {
      case 0: RobotContainer.led.RedAnim();
      break;
      case 1: RobotContainer.led.GreenAnim();
      break;
      case 2: RobotContainer.led.BlueAnim();
      break;
      case 3: RobotContainer.led.RainbowAnim();
      break;
      case 4: RobotContainer.led.StrobeAnim();
      break;
      case 5: RobotContainer.led.FlowAnim();
      break;
      case 6: RobotContainer.led.NoAnim();
      break;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.led.NoAnim();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
