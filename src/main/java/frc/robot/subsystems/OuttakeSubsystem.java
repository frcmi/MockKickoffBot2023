package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.Constants.OuttakeConstants;

public class OuttakeSubsystem {
    TalonFX upperMotor = new TalonFX (OuttakeConstants.upperMotorID);
    TalonFX lowerMotor = new TalonFX (OuttakeConstants.lowerMotorID);
    TalonFX hoodMotor = new TalonFX (OuttakeConstants.hoodMotorID);

    public void setMotors(double upperMotorSpeed, double lowerMotorSpeed, double hoodMotorSpeed){
        upperMotor.set(upperMotorSpeed);
        lowerMotor.set(lowerMotorSpeed);
        hoodMotor.set(hoodMotorSpeed);
    }
}

