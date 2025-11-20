package org.firstinspires.ftc.teamcode.WebcamAndSensors;


import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class LimelightAprilTag extends OpMode {

    private Limelight3A limelight;
    private IMU imu;

    @Override
    public void init() {
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.pipelineSwitch(0); //april tag pipeline from the limelight settings thing
        imu = hardwareMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot hubOrientation = new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD);
        imu.initialize(new IMU.Parameters(hubOrientation));
    }

    @Override
    public void start() {
        limelight.start();
    }

    @Override
    public void loop() {
        YawPitchRollAngles heading = imu.getRobotYawPitchRollAngles();
        limelight.updateRobotOrientation(heading.getYaw()); //gets yaw
        LLResult llResult = limelight.getLatestResult(); //takes data from limelight

        if (llResult != null && llResult.isValid()) {
            Pose3D botPose = llResult.getBotpose_MT2(); //gets all the information positions, yaw, pitch, and roll

            telemetry.addData("Target x: ", llResult.getTx());
            telemetry.addData("Target y: ", llResult.getTy());
            telemetry.addData("Target area: ", llResult.getTa());
            telemetry.addData("Yaw" , botPose.getOrientation().getYaw());
            telemetry.update();
        }
    }
}
