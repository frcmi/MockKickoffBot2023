package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.Pigeon2;
import com.ctre.phoenix6.mechanisms.swerve.SwerveDrivetrain;
import com.ctre.phoenix6.mechanisms.swerve.SwerveDrivetrainConstants;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstantsFactory;
import com.ctre.phoenix6.mechanisms.swerve.SwerveRequest;

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
    public SwerveDrivetrain swerveDrivetrain = new SwerveDrivetrain(
        swerveDrivetrainConstants, 
        SwerveConstants.Mod0.moduleConstants,
        SwerveConstants.Mod1.moduleConstants,
        SwerveConstants.Mod2.moduleConstants,
        SwerveConstants.Mod3.moduleConstants);

    

    public void driveFieldCentric(double forwardVelocity, double sidewaysVelocity, double rotationAboutCenter) {
        SwerveRequest.FieldCentric driveRequest = new SwerveRequest.FieldCentric()
            .withIsOpenLoop(true)
            .withVelocityX(forwardVelocity)
            .withVelocityY(sidewaysVelocity)
            .withRotationalRate(rotationAboutCenter);
        swerveDrivetrain.setControl(
            driveRequest
        );
    }
    public void driveRobotCentric(double forwardVelocity, double sidewaysVelocity, double rotationAboutCenter) {
        SwerveRequest.RobotCentric driveRequest = new SwerveRequest.RobotCentric()
            .withIsOpenLoop(true)
            .withVelocityX(forwardVelocity)
            .withVelocityY(sidewaysVelocity)
            .withRotationalRate(rotationAboutCenter);
        swerveDrivetrain.setControl(
            driveRequest
        );
    }
    public void driveSwerveRequest(SwerveRequest driveRequest) {
        swerveDrivetrain.setControl(
            driveRequest
        );
    }

    public SwerveModule[] swerveModules = {
        SwerveConstants.Mod0,
        SwerveConstants.Mod1,
        SwerveConstants.Mod2,
        SwerveConstants.Mod3
    };

    public SwerveSubsystem() {
        resetGyro();
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
