package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

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
