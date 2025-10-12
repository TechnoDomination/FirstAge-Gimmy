package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Hopper {

    public static Hopper instance;
    public DcMotorEx HopperMotor;

    public Hopper (HardwareMap hardwareMap){

        HopperMotor = hardwareMap.get(DcMotorEx.class, "FrontLeftDcMotor");
        HopperMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        HopperMotor.setPower(0);
        HopperMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        instance = this;
    }


}
