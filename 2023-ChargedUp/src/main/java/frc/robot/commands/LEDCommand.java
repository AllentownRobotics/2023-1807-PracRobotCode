// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.AnimNumberConstants;

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
  public void initialize() {
    switch (animNumber) {
        case AnimNumberConstants.idleAnimNumber: RobotContainer.led.IdleAnim();
        break;
        case AnimNumberConstants.coneReqAnimNumber: RobotContainer.led.ConeReqAnim();
        break;
        case AnimNumberConstants.cubeReqAnimNumber: RobotContainer.led.CubeReqAnim();
        break;
        case AnimNumberConstants.coneTransportAnimNumber: RobotContainer.led.ConeTransportAnim();
        break;
        case AnimNumberConstants.cubeTransportAnimNumber: RobotContainer.led.CubeTransportAnim();
        break;
        case AnimNumberConstants.coneScoreAnimNumber: RobotContainer.led.ConeScoreAnim(); 
        break;
        case AnimNumberConstants.cubeScoreAnimNumber: RobotContainer.led.CubeScoreAnim();
        break;
        case AnimNumberConstants.endgameAnimNumber: RobotContainer.led.EndGameAnim();
        break;
        case AnimNumberConstants.resetAnimNumber: RobotContainer.led.NoAnim();
        break;
      }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
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
