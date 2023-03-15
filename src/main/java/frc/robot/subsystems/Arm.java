package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;
import frc.robot.Constants.CompressorConstants;

public class Arm extends SubsystemBase {

     //The arm has two solenoids on either side.
     public static DoubleSolenoid leftArmSolenoid;

     public static DoubleSolenoid rightArmSolenoid;
 
     public Arm() {
         leftArmSolenoid = new DoubleSolenoid(
             CompressorConstants.COMPRESSOR_ID,
             PneumaticsModuleType.REVPH,
             ArmConstants.LEFT_ARM_EXTEND_CHANNEL_ID,
             ArmConstants.LEFT_ARM_RETRACT_CHANNEL_ID
         );

         rightArmSolenoid = new DoubleSolenoid(
            CompressorConstants.COMPRESSOR_ID,
            PneumaticsModuleType.REVPH,
            ArmConstants.RIGHT_ARM_EXTEND_CHANNEL_ID,
            ArmConstants.RIGHT_ARM_RETRACT_CHANNEL_ID
        );
     }

    @Override
    public void periodic() {}

    @Override
    public void simulationPeriodic() {}

    public void armExtended() {
    leftArmSolenoid.set(Value.kForward);
    rightArmSolenoid.set(Value.kForward);
    }

    public void armRetracted() {
    leftArmSolenoid.set(Value.kReverse);
    rightArmSolenoid.set(Value.kReverse);
    }

}
