package frc.robot.subsystems;

import java.util.Map;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;


import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase{
    private final TalonFX flywheelMotor = new TalonFX(IntakeConstants.kFlywheelMotorId);

    public IntakeSubsystem() {
        flywheelMotor.setNeutralMode(NeutralModeValue.Coast);
        //flywheelMotor.configureStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 40, 60, 0.1)); TODO: Figure out later
        setDefaultCommand(stop());
    } 

    @Override
    public void periodic() {
        var currentCommand = this.getCurrentCommand();
        if (currentCommand != null){
            SmartDashboard.putString("Intake Command", currentCommand.getName());
        } else {
            SmartDashboard.putString("Intake Command", "");
        }
    }

        public Command intake(){
        return run(
                () -> {flywheelMotor.set(1); // TODO: Input actual number
                }
        ).withName("Intake");
    }

        public Command stop() {
        return run(
            () -> {flywheelMotor.set(0); // TODO: Input actual number
                }
        ).withName("Stop");
    }
}
