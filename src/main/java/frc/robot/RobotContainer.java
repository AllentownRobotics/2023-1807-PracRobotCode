package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.ArmCMD;
import frc.robot.commands.CompressCMD;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Compress;

public class RobotContainer {
    
    public static CommandXboxController driverController;

    public static CommandXboxController operatorController;

    public static Arm armSystem = new Arm();

    public static Compress compressorSystem = new Compress();


    public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    
    operatorController = new CommandXboxController(Constants.CTRL_FOR_DRIVER_ID);
        
    driverController = new CommandXboxController(Constants.CTRL_FOR_OPERATOR_ID);
    
    //Default commands
    compressorSystem.setDefaultCommand(new CompressCMD());
}

    public void configureBindings() {
        operatorController.x().whileTrue(new ArmCMD());
    }
}