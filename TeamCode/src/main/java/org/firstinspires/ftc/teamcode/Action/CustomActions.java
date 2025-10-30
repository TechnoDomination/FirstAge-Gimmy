package org.firstinspires.ftc.teamcode.Action;
import androidx.annotation.NonNull;

import org.firstinspires.ftc.teamcode.Subsystems.Hopper;
import org.firstinspires.ftc.teamcode.Subsystems.Shooter;
import org.firstinspires.ftc.teamcode.Subsystems.Drive;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.util.ElapsedTime;

public class CustomActions {
    Shooter shooter = Shooter.instance;
    Hopper hopper = Hopper.instance;
    public static CustomActions instance;

    public CustomActions(HardwareMap hardwareMap) {
        instance = this;
    }

    public void update() {
        hopper.update();
    }

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

    public Action shootMiddle = new Action() {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            shooter.ShooterMotorOne.setPower(0.57);

            return !shooter.isVelReached;
        }
    };

}
