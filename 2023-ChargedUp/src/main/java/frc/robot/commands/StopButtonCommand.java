package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class StopButtonCommand extends CommandBase {
    public StopButtonCommand() {
        addRequirements(RobotContainer.drivetrain);
    }
    public void execute() {
            Drivetrain.frontRight.setNeutralMode(NeutralMode.Brake);
            Drivetrain.centerRight.setNeutralMode(NeutralMode.Brake);
            Drivetrain.backRight.setNeutralMode(NeutralMode.Brake);
            Drivetrain.frontLeft.setNeutralMode(NeutralMode.Brake);
            Drivetrain.centerLeft.setNeutralMode(NeutralMode.Brake);
            Drivetrain.backLeft.setNeutralMode(NeutralMode.Brake);
    }
    @Override
  public void end(boolean interrupted) {
    Drivetrain.frontRight.setNeutralMode(NeutralMode.Coast);
    Drivetrain.centerRight.setNeutralMode(NeutralMode.Coast);
    Drivetrain.backRight.setNeutralMode(NeutralMode.Coast);
    Drivetrain.frontLeft.setNeutralMode(NeutralMode.Coast);
    Drivetrain.centerLeft.setNeutralMode(NeutralMode.Coast);
    Drivetrain.backLeft.setNeutralMode(NeutralMode.Coast);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
