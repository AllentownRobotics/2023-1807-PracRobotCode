// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.AnimNumberConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.LEDCommand;
import frc.robot.subsystems.LED;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static LED led = new LED();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
     led.setDefaultCommand(new LEDCommand(8));

    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.back().onTrue(new LEDCommand(AnimNumberConstants.idleAnimNumber));

    m_driverController.leftStick().onTrue(new LEDCommand(AnimNumberConstants.coneReqAnimNumber));

    m_driverController.rightStick().onTrue(new LEDCommand(AnimNumberConstants.cubeReqAnimNumber));

    m_driverController.leftBumper().onTrue(new LEDCommand(AnimNumberConstants.coneTransportAnimNumber));

    m_driverController.rightBumper().onTrue(new LEDCommand(AnimNumberConstants.cubeTransportAnimNumber));

    m_driverController.y().onTrue(new LEDCommand(AnimNumberConstants.coneScoreAnimNumber));
    
    m_driverController.x().onTrue(new LEDCommand(AnimNumberConstants.cubeScoreAnimNumber));

    m_driverController.a().onTrue(new LEDCommand(AnimNumberConstants.endgameAnimNumber));

    m_driverController.start().onTrue(new LEDCommand(AnimNumberConstants.resetAnimNumber));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
