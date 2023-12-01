package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.Pigeon2;
import com.ctre.phoenix6.mechanisms.swerve.SwerveDrivetrainConstants;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstantsFactory;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.Constants.SwerveConstants;
import frc.robot.SwerveModule;

public class SwerveSubsystem {
    public SwerveDrivetrainConstants swerveDrivetrainConstants = new SwerveDrivetrainConstants()
        .withPigeon2Id(SwerveConstants.pigeonID)
        .withCANbusName(SwerveConstants.CANbusName)
        .withSupportsPro(false);
    public Pigeon2 gyro = new Pigeon2(SwerveConstants.pigeonID); 
    public SwerveDriveOdometry swerveDriveOdometry = new SwerveDriveOdometry(SwerveConstants.swerveKinematics, gyro.getRotation2d(), getModulePositions());

    public SwerveModule[] swerveModules = {
        SwerveConstants.Mod0,
        SwerveConstants.Mod1,
        SwerveConstants.Mod2,
        SwerveConstants.Mod3
    };

    public SwerveSubsystem() {
        resetGyro();
    }

    public SwerveModulePosition[] getModulePositions() {
        SwerveModulePosition[] moduleStates = new SwerveModulePosition[swerveModules.length];
        for (int i = 0; i < moduleStates.length; i++) {
            moduleStates[i] = swerveModules[i].getModulePosition();
        }
        return moduleStates;
    }

    public void resetGyro() {
        gyro.setYaw(0);
    }

    public void stopMotors() {
        for (SwerveModule module : swerveModules) {
            module.stopDriveMotor();
        }
    }
}
