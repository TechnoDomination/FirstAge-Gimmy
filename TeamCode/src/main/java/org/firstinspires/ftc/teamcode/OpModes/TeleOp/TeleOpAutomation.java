package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Drive;
import org.firstinspires.ftc.teamcode.Subsystems.Hopper;
import org.firstinspires.ftc.teamcode.Subsystems.Shooter;

@TeleOp(name = "TeleOp", group = "TeleOp")
public class TeleOpAutomation extends LinearOpMode {

    @Override
    public void runOpMode() {

        Drive drive = new Drive(hardwareMap);
        Shooter shooter = new Shooter(hardwareMap);
        Hopper hopper = new Hopper(hardwareMap);

        shooter.ShooterMotor.setPower(0.0);

        waitForStart();
        while (opModeIsActive() && !isStopRequested()) {
            hopper.update();
            telemetry.update();

            //drive
            drive.update(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

            //shooter
            if (gamepad1.a) {
                    shooter.ShooterMotor.setPower(0);
            }
            if (gamepad1.b) {
                    shooter.ShooterMotor.setPower(0.2);

            }
            if (gamepad1.y) {
                    shooter.ShooterMotor.setPower(0.57);

            }
            if (gamepad1.x) {

                    shooter.ShooterMotor.setPower(0.7);
            }

            telemetry.addData("Shooter Power:", shooter.ShooterMotor.getPower());

            //hopper
            if (gamepad1.right_bumper) {
                hopper.state = Hopper.State.UP;
            }
            if (gamepad1.left_bumper) {
                hopper.state = Hopper.State.DOWN;
            }

            telemetry.addData("Hopper: ", hopper.getHopperTelemetry());
        }
    }
}
