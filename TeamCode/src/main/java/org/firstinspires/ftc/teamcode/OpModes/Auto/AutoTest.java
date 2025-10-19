package org.firstinspires.ftc.teamcode.OpModes.Auto;
import static java.lang.Math.PI;

import android.app.Notification;

import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.ParallelAction;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.GoBildaPinPointOdo.Localizer;
import org.firstinspires.ftc.teamcode.GoBildaPinPointOdo.Poses;
import org.firstinspires.ftc.teamcode.Positions;
import org.firstinspires.ftc.teamcode.Subsystems.Drive;
import com.acmerobotics.roadrunner.ftc.Actions;

@Autonomous(name = "AutoTest", group = "Auto")
public class AutoTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        Localizer localizer = new Localizer(hardwareMap, new Poses(0, 0, 0.0));
        Drive drive = new Drive(hardwareMap);

        waitForStart();
        Actions.runBlocking(
                new ParallelAction (
                telemetryPacket -> {
                    localizer.update();
                    telemetry.addData("X pos", Localizer.pose.getX());
                    telemetry.addData("Y pos", Localizer.pose.getY());
                    telemetry.addData("Heading pos", Localizer.pose.getHeading());
                    telemetry.update();
                    return true;
                },

        new SequentialAction(
                    Positions.MoveForward.runToExact,
                    new SleepAction(0.5)
            )
                )
        );
    }
}
