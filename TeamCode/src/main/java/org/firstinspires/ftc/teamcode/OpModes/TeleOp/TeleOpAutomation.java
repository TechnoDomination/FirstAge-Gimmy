package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Drive;
import org.firstinspires.ftc.teamcode.Subsystems.Hopper;
import org.firstinspires.ftc.teamcode.Subsystems.Shooter;

@TeleOp(name = "TeleOp", group = "TeleOp")
public class TeleOpAutomation extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Drive drive = new Drive(hardwareMap);
        Shooter shooter = new Shooter(hardwareMap);
        Hopper hopper = new Hopper(hardwareMap);
        waitForStart();
        drive.update(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

        //shooter
        if (gamepad1.a) {
            while (gamepad1.a) {
             shooter.ShooterMotor.setPower(0.4);
            }
        }
        if (gamepad1.b) {
            while (gamepad1.b) {
                shooter.ShooterMotor.setPower(0.15);
            }
        }
        if (gamepad1.y) {
            while (gamepad1.y) {
                shooter.ShooterMotor.setPower(0.57);
            }
        }
        if (gamepad1.x) {
            while (gamepad1.x) {
                shooter.ShooterMotor.setPower(0.65);
            }
        }



    }
}
