package org.firstinspires.ftc.teamcode.Action;
import androidx.annotation.NonNull;

import org.firstinspires.ftc.teamcode.Subsystems.Hopper;
import org.firstinspires.ftc.teamcode.Subsystems.Shooter;
import org.firstinspires.ftc.teamcode.Subsystems.Drive;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.acmerobotics.roadrunner.Action;

public class CustomActions {
    Shooter shooter = Shooter.instance;
    Hopper hopper = Hopper.instance;
    public Drive drive = Drive.instance;
    public static CustomActions instance;

    public CustomActions(HardwareMap hardwareMap) {
        instance = this;
    }

    public void update() {
        hopper.update();
    }

    public Action stopDrive = new Action() {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {

            drive.stopDrive();

            return false;
        }
    };

    public Action hopperUp = new Action() {

        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            hopper.state = Hopper.State.UP;

            return !hopper.isTargetReached;
        }
    };

    public Action hopperDown = new Action() {

        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            hopper.state = Hopper.State.DOWN;

            return !hopper.isTargetReached;
        }
    };

    public Action shootFront = new Action() {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            shooter.setVelocityRPM(3100);

            return !shooter.isVelReached;
        }
    };
    public Action shootMiddle = new Action() {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            shooter.setVelocityRPM(3600);

            return !shooter.isVelReached;
        }
    };


    public Action shootBack = new Action() {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            shooter.setVelocityRPM(4600);

            return !shooter.isVelReached;
        }
    };

    public Action stopShooter = new Action() {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            shooter.stopMotor();

            return !shooter.isVelReached;
        }
    };

}
