// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.CurvatureDriveCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.FlywheelRepeatCommand;
import frc.robot.commands.IndexerRepeatCommand;
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
  
  private boolean neutralSteeringOn = false;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    
    m_DrivetrainSubsystem.setDefaultCommand(new CurvatureDriveCommand(m_xboxController.getRightTriggerAxis(), m_xboxController.getLeftX(), neutralSteeringOn));
    m_FlywheelSubsystem.setDefaultCommand(new FlywheelRepeatCommand(50));
    // Configure the button bindings
    /**
     * B button = Neutral Steering toggle
     * A button = Brake toggle
     * Y button = Collector Arm toggle
     * Right bumper = Collector Motor toggle
     * X button = Indexer on
     * Left bumper = Flywheel Toggle
     * pretty much everything is a toggle
     */
    configureButtonBindings();


  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    if (m_xboxController.getBButtonPressed()) {
      neutralSteeringOn = !neutralSteeringOn;
    }


    Command setBrake = Commands.either(
      // true
      Commands.runOnce(m_DrivetrainSubsystem::coast, m_CollectorSubsystem),
      // false
      Commands.runOnce(m_DrivetrainSubsystem::brake, m_CollectorSubsystem),
      // condition
      (() -> m_DrivetrainSubsystem.brakeOn));

    JoystickButton brakeButton = new JoystickButton(m_xboxController, XboxController.Button.kA.value);
    brakeButton.onTrue(setBrake);


    Command collectorArm = Commands.either(
          // true
        Commands.runOnce(m_CollectorSubsystem::retract, m_CollectorSubsystem),
          // false
        Commands.runOnce(m_CollectorSubsystem::extend, m_CollectorSubsystem),
          // condition
        (() -> m_CollectorSubsystem.collectorExtended));

    JoystickButton collectorArmButton = new JoystickButton(m_xboxController, XboxController.Button.kY.value);
    collectorArmButton.onTrue(collectorArm);

    
    Command collectorMotor = Commands.run(m_CollectorSubsystem::run, m_CollectorSubsystem) ;

    JoystickButton collectorMotorButton = new JoystickButton(m_xboxController, XboxController.Button.kRightBumper.value);
    collectorMotorButton.onTrue(collectorMotor);
    

    JoystickButton indexButton = new JoystickButton(m_xboxController, XboxController.Button.kX.value);
    indexButton.whileTrue(new IndexerRepeatCommand(0.5));


    JoystickButton flywheelButton = new JoystickButton(m_xboxController, XboxController.Button.kLeftBumper.value);
    flywheelButton.whileTrue(new FlywheelRepeatCommand(10000)).whileFalse(new FlywheelRepeatCommand(50));

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

