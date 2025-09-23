package org.firstinspires.ftc.teamcode.WebcamAndSensors;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "ColorSensor", group = "Sensor")
public class ColorSensor extends OpMode {
ColorSensorTelemtry sensor = new ColorSensorTelemtry();

    @Override
    public void init() {
        sensor.init(hardwareMap);

    }

    @Override
    public void loop() {
    sensor.getDetectedColor(telemetry);
    }
}
