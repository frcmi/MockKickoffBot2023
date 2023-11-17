package frc.robot;

import org.opencv.utils.Converters;

import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstants;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import frc.math.Conversions;
import frc.robot.Constants.SwerveConstants;

public class SwerveModule {
    public final SwerveModuleConstants moduleConstants;
    public int moduleNumber;
    public Rotation2d angleOffset;
    protected Rotation2d previousAngle;

    protected TalonFX steerMotor;
    protected TalonFX driveMotor;

    protected SimpleMotorFeedforward feedForward = new SimpleMotorFeedforward(SwerveConstants.driveKS, SwerveConstants.driveKV, SwerveConstants.driveKA);

    public SwerveModule(int moduleNumber, Rotation2d angleOffset, SwerveModuleConstants moduleConstants) {
        this.moduleNumber = moduleNumber;
        this.angleOffset = angleOffset;

        this.moduleConstants = moduleConstants;

        steerMotor = new TalonFX(moduleConstants.SteerMotorId);
        driveMotor = new TalonFX(moduleConstants.DriveMotorId);
    }

    public void setBrakeMode(boolean brakeMode) {
        if (brakeMode == false) {

        }
    }
}
