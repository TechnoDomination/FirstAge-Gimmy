package org.firstinspires.ftc.teamcode;


import static java.lang.Math.PI;

import com.acmerobotics.roadrunner.Vector2d;

import org.firstinspires.ftc.teamcode.Action.P2P;

public enum Positions {

    //Auto Red Goal - LOCALIZER = x:48, y:55, rotation:PI*0.95
    MoveOutTriangleRedGoal(new Vector2d(30, 30), PI*.25),
    ShootingPositionRed(new Vector2d(0, 0), PI*0.8),

    //Auto Blue Goal - LOCALIZER = x:-47.4, y:56.3, rotation:-PI*0.95
    MoveRightBlueGoal(new Vector2d(-13 , 55.8), 0.0),
    ShootingPositionsBlue(new Vector2d(0, 0), PI*0.67),
    MoveForward(new Vector2d(0,  10), 0.0);

    Positions(Vector2d vector, Double rotation) {
        runToExact = new P2P(vector, rotation);
    }


    public final P2P runToExact;
}
