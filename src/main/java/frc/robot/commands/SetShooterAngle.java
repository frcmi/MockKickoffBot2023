package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.OuttakeSubsystem;

public class SetShooterAngle extends Command {
    private OuttakeSubsystem outtakeSubsystem;
    private PIDController pidController = new PIDController(ShooterConstants.hoodKP, ShooterConstants.hoodKI, ShooterConstants.hoodKD, 0.02);
    private Rotation2d angle;

    public SetShooterAngle(OuttakeSubsystem outtakeSubsystem, Rotation2d angle) {
        this.outtakeSubsystem = outtakeSubsystem;
        this.angle = angle;

        addRequirements(outtakeSubsystem);
    }

    @Override
    public void execute() {
        pidController.calculate(outtakeSubsystem.get, angle.getRadians());
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
