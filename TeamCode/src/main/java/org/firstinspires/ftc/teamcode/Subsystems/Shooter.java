package org.firstinspires.ftc.teamcode.Subsystems;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;


public class Shooter {


    public static Shooter instance;
    public DcMotorEx ShooterMotorTwo;
    public DcMotorEx ShooterMotorOne;
    DcMotorEx motorExLeft;
    public boolean isVelReached = false;

    public void PIDFCoefficients(){
        PIDFCoefficients pidfOrig = motorExLeft.getPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER);

    }
    public Shooter (HardwareMap hardwareMap){
        ShooterMotorOne = hardwareMap.get(DcMotorEx.class, "ShooterMotor One");
        ShooterMotorTwo = hardwareMap.get(DcMotorEx.class, "ShooterMotor Two");
        ShooterMotorOne.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ShooterMotorTwo.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ShooterMotorOne.setDirection(DcMotorSimple.Direction.FORWARD);
        ShooterMotorTwo.setDirection(DcMotorSimple.Direction.REVERSE);
        ShooterMotorOne.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ShooterMotorTwo.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        instance = this;
    }

    public void setVelocityRPM(double targetRPM) {
        // Prevent setting a velocity above the motor's capability.
        // Convert RPM to ticks per second.
        double targetVelocityTPS = (targetRPM / 60) * 28;
        ShooterMotorOne.setVelocity(targetVelocityTPS);
        ShooterMotorTwo.setVelocity(targetVelocityTPS);
    }



    }

