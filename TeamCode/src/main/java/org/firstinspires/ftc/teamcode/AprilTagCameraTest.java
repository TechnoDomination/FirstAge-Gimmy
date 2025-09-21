package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;

@TeleOp(name = "AprilTagTest", group = "Camera")
public class AprilTagCameraTest extends LinearOpMode {

    //Sees april tags and processes them
    private AprilTagProcessor processor;
    //gives robot capability to see
    private VisionPortal visionPortal;

    @Override
    public void runOpMode() throws InterruptedException {
        //call the init method
        initProcessor();

        waitForStart();
        while (opModeIsActive() && !isStopRequested()) {
            //calling telemetry
            telemetryProcessorAprilTag();
            telemetry.update();
            //When not using, turn off to save processor resources.
            if (gamepad1.dpad_up) {
                visionPortal.resumeStreaming();
            }
            if (gamepad1.dpad_down) {
                visionPortal.stopStreaming();
            }
            //So that cpu doesn't overload, and for stability
            sleep(20);
        }

        //When not using, saving processor resources.
        visionPortal.close();
    }

    //Initialize the april processor
    private void initProcessor() {
        //Create proccesor
        //Builder is to customize options for vision portal & processor
        processor = new AprilTagProcessor.Builder().build();
        //Create vision portal
        VisionPortal.Builder build = new VisionPortal.Builder();
        //Configuration
        build.setCamera(hardwareMap.get(WebcamName.class, "Webcam"));
        //Set up and enable the processor
        build.addProcessor(processor);
        //building the vision portal
        visionPortal = build.build();
    }

    //telemetry for webcam
    private void telemetryProcessorAprilTag() {
        //gives a list of the detections of april tags from camera
        List<AprilTagDetection> currentDetections = processor.getDetections();
        telemetry.addData("# of Tags Detected", currentDetections.size());
        //info for each detection
        for (AprilTagDetection detection: currentDetections) {
            //NOT NULL AND HAS VALUE FOR APRIL TAG DETECTION
            if (detection.metadata != null) {
                //%s = insert string, %d = insert decimal num
                telemetry.addLine(String.format("\n (ID %d) %s", detection.id, detection.metadata.name));
                // %6.1f is formatting
                telemetry.addLine(String.format("XYZ coordinates %6.1f %6.1f %6.1f  (inch): ", detection.ftcPose.x, detection.ftcPose.y, detection.ftcPose.z));
                telemetry.addLine(String.format("Pitch, Role, Yaw %6.1f %6.1f %6.1f  (deg)", detection.ftcPose.pitch, detection.ftcPose.roll, detection.ftcPose.yaw));
                telemetry.addLine(String.format("Range, Bearing, Elevation %6.1f %6.1f %6.1f  (inch, deg, deg)", detection.ftcPose.range, detection.ftcPose.bearing, detection.ftcPose.elevation));
            } else {
                //NULL - NO VALUE IN THE APRIL TAG DETECTION
                telemetry.addLine(String.format("\n==== (ID %d) Unknown ", detection.id));
                telemetry.addLine(String.format("Center %6.0f %6.0f   (pixels)", detection.center.x, detection.center.y));
            }
        }
    }
}
