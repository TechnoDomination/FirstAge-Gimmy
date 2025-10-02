package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.PIDF.PIDFController;
import org.firstinspires.ftc.teamcode.PIDF.PIDFParams;

public class Shooter {

    public static Drive instance;
    public DcMotorEx ShooterMotor;

    public Shooter (HardwareMap hardwareMap){
        ShooterMotor = hardwareMap.get(DcMotorEx.class, "FrontLeftDCMotor");
    }
}
