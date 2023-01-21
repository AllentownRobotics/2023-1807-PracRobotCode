// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.NeoMotorSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ControlPIDCommand extends PIDCommand {

  static XboxController m_xboxController = RobotContainer.m_xboxController;

  static NeoMotorSubsystem m_neoMotorSubsystem = RobotContainer.m_neoMotorSubsystem;

  /** Creates a new ControlPIDCommand. */
  public ControlPIDCommand(double targetSpeed) {
    super(
        // The controller that the command will use
        new PIDController(Constants.kP, Constants.kI, Constants.kD),

        // This should return the measurement
        m_neoMotorSubsystem::getSpeed,
        // This should return the setpoint (can also be a constant)
        m_xboxController.getLeftY(),
        // This uses the output
        output -> RobotContainer.m_neoMotorSubsystem.control(output)
        
        );
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
