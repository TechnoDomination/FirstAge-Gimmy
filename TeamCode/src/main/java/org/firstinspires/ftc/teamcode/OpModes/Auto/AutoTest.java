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
import com.acmerobotics.roadrunner.ftc.Action;

@Autonomous(name = "AutoTest", group = "Auto")
public class AutoTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        Localizer localizer = new Localizer(hardwareMap, new Poses(48, 55.7, PI * 0.95));
        Drive drive = new Drive(hardwareMap);

        waitForStart();
        Action.runBlocking(
                new ParallelAction (
                telemetryPacket -> {
                    localizer.update();
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
