// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.Climb.climbACTIVE;
import frc.robot.commands.Collector.collectorACTIVATE;
import frc.robot.commands.Drivetrain.driveARCADE;
import frc.robot.commands.Drivetrain.driveBRAKE;
import frc.robot.commands.Indexer.indexerACTIVATE;
import frc.robot.commands.Shooter.shooterACTIVE;
import frc.robot.commands.Shooter.shooterIDLE;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.ShooterWithHood;

public class RobotContainer {


  //controllers and buttons
  public static XboxController operatorController;

  public static XboxController driverController;

  public Trigger brakeButton;

  public Trigger collectionCollect;

  public Trigger collectionDump;

  public Trigger indexTrigger;

  public Trigger climbGoClimbing;

  public Trigger climbDoNotClimb;

  public Trigger upButton;

  public Trigger rightButton;

  public Trigger downButton;

  public Trigger leftButton;
  
//defining subsystems
public static Drivetrain drivetrain;

public static Collector collectorSystem;

public static Indexer indexerSystem;
  
public static ShooterWithHood shooterSystem;

public static Compressor compressorSystem;

public static Climb climbSystem;

  // The robot's subsystems and commands are defined here...

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

  //controllers and buttons
    driverController = new XboxController(Constants.CTRL_FOR_DRIVER);

    operatorController = new XboxController(Constants.CTRL_FOR_OPERATOR);

  //default commands
    drivetrain.setDefaultCommand(new driveARCADE());

    shooterSystem.setDefaultCommand(new shooterIDLE());

    //compressorSystem.setDefaultCommand(new compressACTIVE());

    drivetrain = new Drivetrain();

    collectorSystem = new Collector();

    indexerSystem = new Indexer();

    shooterSystem = new ShooterWithHood();

    climbSystem = new Climb();

    compressorSystem = new Compressor(null);

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
  /* public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  } */

public static void CurveDrive(Object y, Object y2) {}

public static void ArcadeDrive(Object y, Object x) {}

public static void TankDrive(Object y, Object x) {}


//button binding
public void buttonBinds() {
  brakeButton = new JoystickButton(driverController, XboxController.Button.kB.value).whileTrue(new driveBRAKE());
  
  climbGoClimbing = new JoystickButton(operatorController, XboxController.Button.kX.value).whileTrue(new climbACTIVE());

  collectionCollect = new JoystickButton(operatorController, XboxController.Button.kA.value).whileTrue(new collectorACTIVATE(false));

  collectionDump = new JoystickButton(operatorController, XboxController.Button.kB.value).whileTrue(new collectorACTIVATE(true));

  indexTrigger = new JoystickButton(operatorController, XboxController.Axis.kRightTrigger.value).whileTrue(new indexerACTIVATE());

  upButton = new POVButton(operatorController, 0).whileTrue(new shooterACTIVE());

  rightButton = new POVButton(operatorController, 90).whileTrue(new shooterACTIVE());

  downButton = new POVButton(operatorController, 180).whileTrue(new shooterACTIVE());

  leftButton = new POVButton(operatorController, 270).whileTrue(new shooterACTIVE());
}

}