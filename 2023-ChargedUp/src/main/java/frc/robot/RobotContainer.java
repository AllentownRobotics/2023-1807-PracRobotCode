// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.BrakeCommand;
import frc.robot.commands.CoastCommand;
import frc.robot.commands.CollectExtendCommand;
import frc.robot.commands.CollectRetractCommand;
import frc.robot.commands.CompressCommand;
import frc.robot.commands.CurvatureDriveCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.FlywheelIdleCommand;
import frc.robot.commands.FlywheelShootCommand;
import frc.robot.commands.IndexCommand;
import frc.robot.subsystems.CollectorSubsystem;
import frc.robot.subsystems.CompressorSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.FlywheelSubsystem;
import frc.robot.subsystems.IndexerSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public final static DrivetrainSubsystem m_DrivetrainSubsystem = new DrivetrainSubsystem();
  public final static FlywheelSubsystem m_FlywheelSubsystem = new FlywheelSubsystem();
  public final static CompressorSubsystem m_CompressorSubsystem = new CompressorSubsystem();
  public final static IndexerSubsystem m_IndexerSubsystem = new IndexerSubsystem();
  public final static CollectorSubsystem m_CollectorSubsystem = new CollectorSubsystem();


  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  public static XboxController m_xboxController= new XboxController(Constants.XBOX_CONTROLLER_ONE);;
  
  private boolean brakeOn = false;

  private boolean neutralSteeringOn = false;

  private boolean collectorOn = false;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_DrivetrainSubsystem.setDefaultCommand(new CurvatureDriveCommand(m_xboxController.getRightTriggerAxis(), m_xboxController.getLeftX(), neutralSteeringOn));
    m_FlywheelSubsystem.setDefaultCommand(new FlywheelIdleCommand());
    m_CompressorSubsystem.setDefaultCommand(new CompressCommand());

    // Configure the button bindings
    configureButtonBindings();




  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    if (m_xboxController.getAButtonPressed()) {
      if (brakeOn) {
        new CoastCommand();
        brakeOn = false;
      } else {
        new BrakeCommand();
        brakeOn = true;
      }  
    }

    if (m_xboxController.getBButtonPressed()) {
      neutralSteeringOn = !neutralSteeringOn;
    }
    
    if (m_xboxController.getLeftBumperPressed()) {
      new FlywheelShootCommand();
    }

    if (m_xboxController.getLeftBumperReleased())	{
      new FlywheelIdleCommand();
    }

    if (m_xboxController.getRightBumperPressed()) {
      if (collectorOn) {
          new CollectRetractCommand();
          collectorOn = false;
        } else {
          new CollectExtendCommand();
          collectorOn = true;
        }  
      }

    if (m_xboxController.getXButtonPressed()) {
      if (collectorOn) {
          new CollectRetractCommand();
          collectorOn = false;
        } else {
          new CollectExtendCommand();
          collectorOn = true;
        }  
      }

      JoystickButton indexButton = new JoystickButton(m_xboxController, XboxController.Button.kX.value);
      indexButton.whileHeld(new IndexCommand(.5));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
