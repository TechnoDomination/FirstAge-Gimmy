package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.GoBildaPinPointOdo.Localizer;
import org.firstinspires.ftc.teamcode.GoBildaPinPointOdo.Poses;
import org.firstinspires.ftc.teamcode.Subsystems.Drive;
import org.firstinspires.ftc.teamcode.PIDF.PIDFParams;
import org.firstinspires.ftc.teamcode.Positions;

@Config
@TeleOp (name = "Drive Tuning", group = "Tuning OpModes")
public class DriveTuning extends LinearOpMode {

    public static double p = 0.09, i = 0.0001, d = 0.01;
    public static double p2 = 0.06,i2 = 0.0001, d2 = 0.01;
    public static double p3 = 1.2,i3 = 0.0,d3 = 0.08;

    @Override
    public void runOpMode() {
        // telemetry = FtcDashboard.getInstance().getTelemetry();

        Localizer localizer = new Localizer(hardwareMap, new Poses(48, -61, 0.0));
        Drive drive = new Drive(hardwareMap);


        waitForStart();

        Actions.runBlocking(
                new ParallelAction(
                        telemetryPacket -> {
                            localizer.update();
                            drive.xPid.setPIDF(new PIDFParams(p,i,d));
                            drive.yPid.setPIDF(new PIDFParams(p2,i2,d2));
                            drive.rPid.setPIDF(new PIDFParams(p3,i3,d3));

                            telemetry.addData("X pos", Localizer.pose.getX());
                            telemetry.addData("Y pos", Localizer.pose.getY());
                            telemetry.update();
                            return true;
                        },
                        new SequentialAction(
                                Positions.MoveOutTriangleBlueGoal.runToExact,
                                // customActions.intakeForeArmSubEdge,
                                //  new SleepAction(1),
                                new SleepAction(1),
                                Action -> {
                                    drive.stopDrive();
                                    return false;
                                }
                        )
                )
        );

    }
}