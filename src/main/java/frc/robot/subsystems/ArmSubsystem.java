package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.hardware.TalonFX;


import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase{
    private final TalonFX armMotor = new TalonFX(ArmConstants.kLeftArmMotorId);

    public ArmSubsystem() {
        armMotor.setNeutralMode(NeutralModeValue.Brake);
        armMotor.setInverted(true); //TODO: I don't know???
        // armMotor.configureStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 40, 60, 0.1)); TODO: Figure out later
        setDefaultCommand(hold());
        }
    
    public Command wristDown(){
        return run(() -> armMotor.set(ArmConstants.kArmDownPercent)).withName("Wrist Down");
    }

    public Command wristDownVolts(){
        return run(() -> armMotor.setVoltage(ArmConstants.kArmDownVolts)).withName("Wrist Down");
    }
    
    public Command wristDownEndUp(){
        return runEnd(() -> armMotor.set(ArmConstants.kArmDownPercent), 
                     () -> wristUp()).withName("Wrist Down");
    }

    public Command wristDownEndUpVolts() {
        return runEnd(() -> armMotor.setVoltage(ArmConstants.kArmDownPercent), 
                     () -> wristUp()).withName("Wrist Down");
    }

    public Command wristUpVolts() {
        return run(() -> armMotor.setVoltage(-ArmConstants.kArmUpVolts)).withName("Wrist Up").withTimeout(.5);
    }

    public Command wristUp() {
        return run(() -> armMotor.set(-ArmConstants.kArmUpPercent)).withName("Wrist Up").withTimeout(.5);
    }
        
    public Command hold() {
        return run(
            () -> {armMotor.setVoltage(2);
            }
        ).withName("Hold");
    }

    public Command stop() {
        return run(() -> armMotor.set(0)).withName("Stop");
    }

    @Override
    public void periodic() {
        var currentCommand = this.getCurrentCommand();
        if (currentCommand != null){
            SmartDashboard.putString("Arm Command", currentCommand.getName());
        } else {
            SmartDashboard.putString("Arm Command", "");
        }
    }
}
