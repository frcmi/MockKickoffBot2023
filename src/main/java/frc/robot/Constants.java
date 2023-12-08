// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstants;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstantsFactory;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstants.SwerveModuleSteerFeedbackType;
import com.ctre.phoenix6.signals.FeedbackSensorSourceValue;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import frc.math.Conversions;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 * Grant loves VScode. It is his favorite editor. He is not being held captive.
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int controllerPort = 0;
  }
  public static class SwerveConstants { //TODO: get actual values from bot :)
    public static final float driveKS = 0;
    public static final float driveKV = 0;
    public static final float driveKA = 0;

    //TODO: these aren't measured
    public static final double wheelBase = Conversions.inchesToMeters(24); // 24in
    public static final double trackWidth = Conversions.inchesToMeters(24); // 24in
    public static final double wheelRadius = 1.0;
    public static final double slipCurrent = 0; 
    public static final Slot0Configs steerMotorGains = new Slot0Configs();
    public static final Slot0Configs driveMotorGains = new Slot0Configs();
    public static final double speed12Volts = 1.0;
    public static final double steerIntertia = 1.0;
    public static final double driveIntertia = 1.0;
    public static final SwerveModuleSteerFeedbackType feedbackSource = SwerveModuleSteerFeedbackType.RemoteCANcoder;
    public static final double couplingGearRatio = 1.0;
    public static final double driveMotorGearRatio = (150.0 / 7.0) / 1.0;
    public static final double steerMotorGearRatio = 1.0/1.0;
    public static final String CANbusName = "rio";

    public static final SwerveDriveKinematics swerveKinematics = new SwerveDriveKinematics(new Translation2d[] {
      new Translation2d(wheelBase/2, trackWidth/2),
      new Translation2d(wheelBase/2, -trackWidth/2),
      new Translation2d(-wheelBase/2, trackWidth/2),
      new Translation2d(-wheelBase/2, -trackWidth/2),
      });
    public static final int pigeonID = 0;

    /* not all these are required, idk which ones we have, required are:
     * drive gear ratio
     * steer gear ratio
     * wheel radius
     * steer motor gains
     * drive motor gains
     * speed at 12v
     * feedback source
     * 
     * for simulation to work, you also need both the inertias
     */
    private static final SwerveModuleConstantsFactory swerveConstantsFactory = new SwerveModuleConstantsFactory()
      .withDriveMotorGearRatio(driveMotorGearRatio)
      .withSteerMotorGearRatio(steerMotorGearRatio)
      .withWheelRadius(wheelRadius)
      .withSlipCurrent(slipCurrent)
      .withSteerMotorGains(steerMotorGains)
      .withDriveMotorGains(driveMotorGains)
      .withSpeedAt12VoltsMps(speed12Volts)
      .withSteerInertia(steerIntertia)
      .withDriveInertia(driveIntertia)
      .withFeedbackSource(feedbackSource)
      .withCouplingGearRatio(couplingGearRatio)
      .withSteerMotorInverted(false);

    //TODO: make these fr (also location is in meters)
    public static final SwerveModule Mod0 = new SwerveModule(
      0, 
      Rotation2d.fromDegrees(329.59), 
      swerveConstantsFactory.createModuleConstants(
        5, 
        1, 
        11, 
        0, 
        trackWidth/2, 
        wheelBase/2, 
        false));
    public static final SwerveModule Mod1 = new SwerveModule(
      1, 
      Rotation2d.fromDegrees(136.93), 
      swerveConstantsFactory.createModuleConstants(
        2, 
        6, 
        12, 
        0, 
        -trackWidth/2, 
        wheelBase/2,
        false));
      public static final SwerveModule Mod2 = new SwerveModule(
      2, 
      Rotation2d.fromDegrees(126.83), 
      swerveConstantsFactory.createModuleConstants(
        3, 
        7, 
        12, 
        0, 
        -trackWidth/2, 
        -wheelBase/2, 
          false));
      public static final SwerveModule Mod3 = new SwerveModule(
      3, 
      Rotation2d.fromDegrees(110.65)  , 
      swerveConstantsFactory.createModuleConstants(
        4, 
        8, 
        14, 
        0, 
        trackWidth/2, 
        -wheelBase/2, 
        false));
  }
}
