package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OuttakeConstants;
import frc.robot.Constants.ShooterConstants;

public class OuttakeSubsystem extends SubsystemBase {
    TalonFX upperMotor = new TalonFX (OuttakeConstants.upperMotorID);
    TalonFX lowerMotor = new TalonFX (OuttakeConstants.lowerMotorID);
    TalonFX hoodMotor = new TalonFX (OuttakeConstants.hoodMotorID);

    /**
     * @param speed is the speed to shoot ball at in mps
     * @param angle is the angle to shoot ball at
     */
    public void setShootSpeeds(double shooterSpeed, double hoodSpeed) {
        upperMotor.set(shooterSpeed);
        hoodMotor.set(hoodSpeed);
    }

    public double getHoodMotorRadians() {
        return hoodMotor.getRadians(); //trust
    }
}

