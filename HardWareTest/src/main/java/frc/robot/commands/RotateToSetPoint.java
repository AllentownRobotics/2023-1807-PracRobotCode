// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ArmConstants;
import frc.robot.subsystems.Arm;

public class RotateToSetPoint extends CommandBase {
  Arm arm; 
  
  XboxController controller;

  /** Creates a new RotateToSetPoint. */
  public RotateToSetPoint() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean placeCube = controller.getLeftBumper();
    int POV = controller.getPOV();

    switch (POV){
      case 180:
        arm.setDesiredAngle(placeCube ? ArmConstants.ANGLE_CUBE_HIGH : ArmConstants.ANGLE_CONE_HIGH);

      case 270:
        arm.setDesiredAngle(placeCube ? ArmConstants.ANGLE_CUBE_MID : ArmConstants.ANGLE_CONE_MID);

      case 0:
        arm.setDesiredAngle(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
