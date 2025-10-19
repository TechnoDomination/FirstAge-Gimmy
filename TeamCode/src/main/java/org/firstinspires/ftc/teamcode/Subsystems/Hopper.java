package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Hopper {
    private final Servo HopperServo;
    public State state = State.REST;
    public boolean isTargetReached = false;
    public static Hopper instance;

    public enum State {
        UP,
        DOWN,
        REST
    }

    public Hopper (HardwareMap hardwareMap) {
        HopperServo = hardwareMap.get(Servo.class, "HopperServo");

        instance = this;
    }
    public void update() {
        switch (state) {
            case UP:
                HopperServo.setPosition(0.6);
                break;
            case DOWN:
                HopperServo.setPosition(0);
                break;
            case REST:
                HopperServo.setPosition(0);
                break;
        }

        if (state == State.UP && HopperServo.getPosition() == 0.5) {
            isTargetReached = true;
        } else if (state == State.DOWN && HopperServo.getPosition() == 0) {
            isTargetReached = true;
        } else if (state == State.REST && HopperServo.getPosition() == 0) {
            isTargetReached = true;
        } else {
            isTargetReached = false;
        }
    }

    public String getClawTelemetry() {
        String telemetry = "";
        telemetry = telemetry + "\n Hopper Pos = " + HopperServo.getPosition();
        telemetry = telemetry + "\n ";
        return telemetry;
    }

}
