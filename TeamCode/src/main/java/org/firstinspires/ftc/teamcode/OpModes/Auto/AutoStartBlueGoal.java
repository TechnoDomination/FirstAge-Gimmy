package org.firstinspires.ftc.teamcode.OpModes.Auto;

import static java.lang.Math.PI;

import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.GoBildaPinPointOdo.Localizer;
import org.firstinspires.ftc.teamcode.GoBildaPinPointOdo.Poses;
import org.firstinspires.ftc.teamcode.Positions;
import org.firstinspires.ftc.teamcode.Subsystems.Drive;

@Autonomous(name = "AutoBlue", group = "Auto")
public class AutoStartBlueGoal extends LinearOpMode {
    @Override
    public void runOpMode() {

        Localizer localizer = new Localizer(hardwareMap, new Poses(-47.4, 56.3, -PI * 0.95));
        Drive drive = new Drive(hardwareMap);

        new SequentialAction(
                Positions.MoveOutTriangleBlueGoal.runToExact,
                new SleepAction(0.5),
                Positions.ShootingPositionsBlue.runToExact,
                new SleepAction(0.5)
        );
    }
}
