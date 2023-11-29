package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.hardware.TalonFX;

import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase{
    private final TalonFX leftArmMotor = new TalonFX(ArmConstants.kLeftArmMotorId);
    private final TalonFX rightArmMotor = new TalonFX(ArmConstants.kRightArmMotorId);

    public ArmSubsystem() {
        
    }

}
