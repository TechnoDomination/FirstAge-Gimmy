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
                HopperServo.setPosition(0.5);
                break;
            case DOWN:
                HopperServo.setPosition(0);
                break;
            case REST:
                HopperServo.setPosition(0);
                break;
        }
    }



}
