package org.firstinspires.ftc.teamcode.WebcamAndSensors;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "ColorSensorTest", group = "Sensor")
public class ColorSensorLinearOpMode extends LinearOpMode {
    ColorSensorTelemtry sensor = new ColorSensorTelemtry();
    ColorSensorTelemtry.detectedColor detectedColor;

    @Override
    public void runOpMode() throws InterruptedException {
        sensor.init(hardwareMap);
        waitForStart();
        while (opModeIsActive() && !isStopRequested()) {
            detectedColor = sensor.getDetectedColor(telemetry);
            telemetry.addData("Color detected: " , detectedColor);
            telemetry.update();
        }
    }
}
