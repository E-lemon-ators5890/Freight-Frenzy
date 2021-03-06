package org.firstinspires.ftc.teamcode.autons.lm1.blue;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class BlueParkWarehouseCommand extends SequentialCommandGroup {
    public BlueParkWarehouseCommand(Drivetrain drivetrain, Intake intake, Telemetry telemetry) {
        //declare variables here

        addCommands(
                new DriveForwardCommand(drivetrain, 20),
                new TurnToCommand(drivetrain, -93, true),
                new DriveForwardCommand(drivetrain, -90)
        );
    }
}