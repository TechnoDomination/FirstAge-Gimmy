package org.firstinspires.ftc.teamcode.OpModes.Auto;

import static java.lang.Math.PI;

import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.GoBildaPinPointOdo.Localizer;
import org.firstinspires.ftc.teamcode.GoBildaPinPointOdo.Poses;
import org.firstinspires.ftc.teamcode.Positions;
import org.firstinspires.ftc.teamcode.Subsystems.Drive;
import org.firstinspires.ftc.teamcode.Action.CustomActions;

@Autonomous(name = "AutoRed", group = "Auto")
public class AutoStartRedGoal extends LinearOpMode {
    @Override
    public void runOpMode() {

        Localizer localizer = new Localizer(hardwareMap, new Poses(48,55,PI*0.95));
        Drive drive = new Drive(hardwareMap);
        CustomActions customActions = new CustomActions(hardwareMap);

        waitForStart();

        Actions.runBlocking(
                new ParallelAction(
                        telemetryPacket -> {
                            localizer.update();
                            customActions.update();

                            telemetry.addData("X pos", Localizer.pose.getX());
                            telemetry.addData("Y pos", Localizer.pose.getY());
                            telemetry.addData("Heading pos",- Localizer.pose.getHeading());
                            //for(String string: customActions.getTelemetry()) telemetry.addLine(string);
                            telemetry.update();

                            return true;
                        },

        new SequentialAction(
                customActions.shootMiddle,
                new SleepAction(1),
                Positions.ShootingPositionRed.runToExact,
                new SleepAction(0.5),
                Action -> {
                    drive.stopDrive();
                    return false;
                }
          )
        )
        );
    }
}
