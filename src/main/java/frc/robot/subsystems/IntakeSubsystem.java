package frc.robot.subsystems;

import java.util.Map;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
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
    private final TalonFX flywheelMotor1 = new TalonFX(IntakeConstants.kFlywheelMotorId);
    private final TalonFX flywheelMotor2 = new TalonFX(IntakeConstants.kFlywheelMotorId2);

    public IntakeSubsystem() {
        flywheelMotor1.setNeutralMode(NeutralModeValue.Coast);
        flywheelMotor2.setNeutralMode(NeutralModeValue.Coast);
        flywheelMotor1.configStatorCurrentLimit();
        flywheelMotor2.;
        setDefaultCommand(hold());
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
                () -> {flywheelMotor1.set(1);
                       flywheelMotor2.set(1);}
        ).withName("Intake");
    }

        public Command hold() {
        return run(
            () -> {flywheelMotor1.setVoltage(2);
                   flywheelMotor2.setVoltage(2);
                }
        );
    }
}
