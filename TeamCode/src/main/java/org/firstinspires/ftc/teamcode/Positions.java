package org.firstinspires.ftc.teamcode;


import static java.lang.Math.PI;

import com.acmerobotics.roadrunner.Vector2d;

import org.firstinspires.ftc.teamcode.Action.P2P;

public enum Positions {

    //Auto Red Goal - LOCALIZER = x:48, y:55.7, rotation:PI*0.95
    MoveOutTriangleRedGoal(new Vector2d(50.2, 29), 0.0),
    ShootingPositionRed(new Vector2d(28, 43.8), -PI*0.67),

    //Auto Blue Goal - LOCALIZER = x:-47.4, y:56.3, rotation:-PI*0.95
    MoveOutTriangleBlueGoal(new Vector2d(0, -10), 0.0),
    ShootingPositionsBlue(new Vector2d(-26.2, 47.4), PI*0.67),
    MoveForward(new Vector2d(0,  10), 0.0);

    Positions(Vector2d vector, Double rotation) {
        runToExact = new P2P(vector, rotation);
    }


    public final P2P runToExact;
}
