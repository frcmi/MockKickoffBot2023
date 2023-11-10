package frc.robot;

import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstants;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import frc.robot.Constants.SwerveConstants;

public class SwerveModule {
    public int moduleNumber;
    public Rotation2d angleOffset;
    protected Rotation2d previousAngle;

    protected TalonFX azimuthMotor;
    protected TalonFX driveMotor;
    protected CANcoder azimuthEncoder;

    protected SimpleMotorFeedforward feedForward = new SimpleMotorFeedforward(SwerveConstants.driveKS, SwerveConstants.driveKV, SwerveConstants.driveKA);

    public SwerveModule(int moduleNumber, Rotation2d angleOffset, int azimuthMotorID, int driveMotorID, int azimuthEncoderID) {
        this.moduleNumber = moduleNumber;
        this.angleOffset = angleOffset;

        azimuthEncoder = new CANcoder(azimuthEncoderID);
        azimuthMotor = new TalonFX(azimuthMotorID);
        driveMotor = new TalonFX(driveMotorID);
    }
}
