package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "ColorSensorTest", group = "Sensor")
public class ColorSensorLinearOpMode extends LinearOpMode {
    ColorSensorTelemtry sensor = new ColorSensorTelemtry();

    @Override
    public void runOpMode() throws InterruptedException {
        sensor.init(hardwareMap);
        waitForStart();
        while (opModeIsActive() && !isStopRequested()) {
            sensor.getDetectedColor(telemetry);
            telemetry.update();
        }
    }
}
