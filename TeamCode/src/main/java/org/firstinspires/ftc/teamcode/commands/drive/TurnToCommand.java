package org.firstinspires.ftc.teamcode.commands.drive;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

import java.util.logging.Level;

public class TurnToCommand extends CommandBase {

    private final Drivetrain drive;
    private final double angle;
    double desired, firstAngle;
    boolean weird = false;

    public static int redRightAngle = 197;
    public static int redLeftAngle = 172;
    public static int blueRightAngle = 195;
    public static int blueLeftAngle = 172;


    Telemetry tl;
    public TurnToCommand(Drivetrain drive, double angle) {
        this.drive = drive;
        this.angle = angle;
        addRequirements(drive);
    }

    public TurnToCommand(Drivetrain drive, double angle, boolean weird) {
        this.drive = drive;
        this.angle = angle;
        this.weird = weird;
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        double firstAngle = drive.getHeading();
        if (weird && firstAngle > 180) firstAngle = firstAngle - 360;
        desired = angle - firstAngle;


        drive.turn(Math.toRadians(desired));
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            drive.stop();
        }
    }

    @Override
    public void execute() {
        drive.update();
    }

    @Override
    public boolean isFinished() {
        return Thread.currentThread().isInterrupted() || !drive.isBusy();
    }

}
