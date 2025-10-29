package org.firstinspires.ftc.teamcode.Subsystems;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


import org.firstinspires.ftc.teamcode.PIDF.PIDFController;
import org.firstinspires.ftc.teamcode.PIDF.PIDFParams;


public class Shooter {


    public static Shooter instance;
    public DcMotorEx ShooterMotor;


    public Shooter (HardwareMap hardwareMap){
        ShooterMotor = hardwareMap.get(DcMotorEx.class, "ShooterMotor");
        ShooterMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ShooterMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        ShooterMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        instance = this;
    }


    public void setVelocityRPM(double targetRPM) {
        // Prevent setting a velocity above the motor's capability.


        // Convert RPM to ticks per second.
        double targetVelocityTPS = (targetRPM / 60) * 28;
        ShooterMotor.setVelocity(targetVelocityTPS);


    }


    public void zero(){


        ShooterMotor.setPower(0);
    }
}
