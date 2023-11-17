package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.Pigeon2;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstantsFactory;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.Constants.SwerveConstants;
import frc.robot.SwerveModule;

public class SwerveSubsystem {
    //oh boy, this'll be a fun one...
    private SwerveModuleConstantsFactory swerveModuleFactory = new SwerveModuleConstantsFactory();
    public SwerveDriveOdometry swerveDriveOdometry;
    public SwerveModule[] swerveModules = {
        SwerveConstants.Mod0,
        SwerveConstants.Mod1,
        SwerveConstants.Mod2,
        SwerveConstants.Mod3
    };
    public Pigeon2 gyro = new Pigeon2(SwerveConstants.pigeonID);

    public SwerveSubsystem() {
        resetGyro();
    }

    public void resetGyro() {
        gyro.setYaw(0);
    }

    public void setBrakeMode(boolean brakeMode) {
        for (SwerveModule module : swerveModules) {
            
        }
    }
}
