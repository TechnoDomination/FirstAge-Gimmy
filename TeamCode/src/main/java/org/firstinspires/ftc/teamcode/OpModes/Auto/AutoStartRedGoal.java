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

@Autonomous(name = "AutoRed", group = "Auto")
public class AutoStartRedGoal extends LinearOpMode {
    @Override
    public void runOpMode() {

        Localizer localizer = new Localizer(hardwareMap, new Poses(48,55.7,PI*0.95));
        Drive drive = new Drive(hardwareMap);

        new SequentialAction(
                Positions.MoveOutTriangleRedGoal.runToExact,
                new SleepAction(0.5),
                Positions.ShootingPositionRed.runToExact,
                new SleepAction(0.5)
        );
    }
}
