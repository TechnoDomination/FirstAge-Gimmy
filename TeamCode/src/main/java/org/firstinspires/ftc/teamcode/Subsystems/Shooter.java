package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.PIDF.PIDFController;
import org.firstinspires.ftc.teamcode.PIDF.PIDFParams;

public class Shooter {

    public static Shooter instance;
    public DcMotorEx ShooterMotor;

    public Shooter (HardwareMap hardwareMap){
        ShooterMotor = hardwareMap.get(DcMotorEx.class, "FrontLeftDCMotor");
        ShooterMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        ShooterMotor.setPower(0);
        ShooterMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        instance = this;
    }
}
