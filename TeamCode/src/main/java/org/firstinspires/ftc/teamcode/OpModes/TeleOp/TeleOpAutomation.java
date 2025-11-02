package org.firstinspires.ftc.teamcode.OpModes.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


import org.firstinspires.ftc.teamcode.Subsystems.Drive;
import org.firstinspires.ftc.teamcode.Subsystems.Hopper;
import org.firstinspires.ftc.teamcode.Subsystems.Shooter;


@TeleOp(name = "TeleOp", group = "TeleOp")
public class TeleOpAutomation extends LinearOpMode {


    double motorMaxRPM = 6000;
    double ticksPerRev = 28;
    double desiredRPM;
    double velocityB = 0;
    double velocityA;
    double velocityY;
    double velocityX;


    @Override
    public void runOpMode() {


        Drive drive = new Drive(hardwareMap);
        Shooter shooter = new Shooter(hardwareMap);
        Hopper hopper = new Hopper(hardwareMap);




        waitForStart();
        while (opModeIsActive() && !isStopRequested()) {
            hopper.update();
            telemetry.update();


            //drive
            drive.update(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);


            //shooter
            if (gamepad1.a) {
                shooter.stopMotor();
            }
            if (gamepad1.b) {
                shooter.setVelocityRPM(3600);//setPower(0.47)

            }
            if (gamepad1.y) {
                shooter.setVelocityRPM(3100);
            }
            if (gamepad1.x) {
                //shooter.setVelocityRPM(4000); //setPower(0.7)
            }


            telemetry.addData("Shooter Power For Left Motor:", shooter.ShooterMotorLeft.getVelocity());
            telemetry.addData("Shooter Power For Right Motor:", shooter.ShooterMotorRight.getVelocity());
            telemetry.addData("Left PIDFCoeff : ", shooter.ShooterMotorLeft.getPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER));
            telemetry.update();
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
