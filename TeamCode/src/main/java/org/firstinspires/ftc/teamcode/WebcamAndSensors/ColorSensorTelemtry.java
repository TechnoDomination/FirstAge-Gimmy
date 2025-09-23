package org.firstinspires.ftc.teamcode.WebcamAndSensors;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ColorSensorTelemtry {
    NormalizedColorSensor colorSensor; //variable for color sensor

        public enum detectedColor{ //needed to state what the colors are when scanning
            GREEN,
            PURPLE,
            UNKNOWN,
        }

        public void init(HardwareMap hardwareMap){
            colorSensor = hardwareMap.get(NormalizedColorSensor.class, "sensor_color_distance"); //configuration
        }

        public detectedColor getDetectedColor(Telemetry telemetry) {
            NormalizedRGBA colors = colorSensor.getNormalizedColors(); //returns 4 values RGB = red green and blue and A = Alpha (light when it comes to color sensor)

            float normRed, normGreen, normBlue; // no matter how far the ball is the color sensor can track the color and not think it is a diffrent color based on lighting ( get same reading no matter how far away the ball is)
            normRed = colors.red / colors.alpha;
            normGreen = colors.green / colors.alpha;
            normBlue = colors.blue / colors.alpha;

            telemetry.addData("red", normRed);
            telemetry.addData("blue", normBlue);
            telemetry.addData("green", normGreen); // telemtry for the diffrent color balls.
            telemetry.update();

            /*
            purple, green
            purple = 2.25>=, 0, 2.25>=
            green = 0, 0, 9>=
             */

            if(normRed == 2.25 && normGreen == 0 && normBlue == 2.25){
                return detectedColor.PURPLE;
            }

            else if(normRed == 0 && normGreen == 9 && normBlue == 0){
                return detectedColor.GREEN;
            }
            else{
                return detectedColor.UNKNOWN;
            }


        }

        ;
}

