package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.pipelines.FFRectDetector;
import org.firstinspires.ftc.teamcode.pipelines.TeamMarkerPipeline;
//import org.firstinspires.ftc.teamcode.Util;


public class Vision extends SubsystemBase {
    private Telemetry telemetry;
    private FFRectDetector duckDetector;
    private TeamMarkerPipeline.Position currentPos;

    public Vision(HardwareMap hw, String webcamName, Telemetry tl) {
        duckDetector = new FFRectDetector(hw, webcamName);
        duckDetector.init();

        //switch left and right if camera mounted upside down
        duckDetector.setLeftRectangle(0.05, 0.3);
        duckDetector.setCenterRectangle(0.5, 0.3);
        duckDetector.setRightRectangle(0.95, 0.3);
        telemetry = tl;
        currentPos = duckDetector.getPosition();
    }

    @Override
    public void periodic() {
        currentPos = duckDetector.getPosition();

        //Util.logger(this, telemetry, Level.INFO, "Current Stack", currentStack);
    }

    public TeamMarkerPipeline.Position getCurrentPosition() {
        return currentPos;
    }
}