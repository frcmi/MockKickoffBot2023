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
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.SwerveConstants;
import frc.robot.SwerveModule;

public class SwerveSubsystem extends SubsystemBase {
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

    public SwerveModule[] swerveModules = {
            SwerveConstants.Mod0,
            SwerveConstants.Mod1,
            SwerveConstants.Mod2,
            SwerveConstants.Mod3
    };

    private CommandXboxController xboxController;

    public SwerveSubsystem(CommandXboxController controller) {
        xboxController = controller;

        resetGyro();
    }

    /**
     * Drive relative to the field.
     * 
     * @param forwardVelocity     the velocity the robot should go towards the end
     *                            of the field
     * @param sidewaysVelocity    the velocity the robot should go towards the right
     *                            side of the field
     * @param rotationAboutCenter the velocity of the robot around it's center
     */
    public void driveFieldCentric(double forwardVelocity, double sidewaysVelocity, double rotationAboutCenter) {
        SwerveRequest.FieldCentric driveRequest = new SwerveRequest.FieldCentric()
                .withIsOpenLoop(true)
                .withVelocityX(forwardVelocity)
                .withVelocityY(sidewaysVelocity)
                .withRotationalRate(rotationAboutCenter);
        swerveDrivetrain.setControl(
                driveRequest);
    }

    /**
     * Drive relative to the robot.
     * 
     * @param forwardVelocity        the velocity the robot should go forward
     * @param sidewaysVelocity       the velocity the robot should go towards the
     *                               right
     * @param rotationAboutCenterthe velocity of the robot around it's center
     */
    public void driveRobotCentric(double forwardVelocity, double sidewaysVelocity, double rotationAboutCenter) {
        SwerveRequest.RobotCentric driveRequest = new SwerveRequest.RobotCentric()
                .withIsOpenLoop(true)
                .withVelocityX(forwardVelocity)
                .withVelocityY(sidewaysVelocity)
                .withRotationalRate(rotationAboutCenter);
        swerveDrivetrain.setControl(
                driveRequest);
    }

    /**
     * Drive using a Phoenix6 SwerveRequest
     * 
     * @param driveRequest the SwerveRequest to give to the drive train
     */
    public void driveSwerveRequest(SwerveRequest driveRequest) {
        swerveDrivetrain.setControl(driveRequest);
    }

    /**
     * Set the yaw value of the gyro to 0
     */
    public void resetGyro() {
        gyro.setYaw(0);
    }

    /**
     * Stop all the drive motors.
     */
    public void stopMotors() {
        for (SwerveModule module : swerveModules) {
            module.stopDriveMotor();
        }
    }

    @Override
    public void periodic() {
        // jesus of programming, i am praying to thou, make this work
        driveFieldCentric(
                xboxController.getLeftY(),
                xboxController.getLeftX(),
                xboxController.getRightX());
    }
}
