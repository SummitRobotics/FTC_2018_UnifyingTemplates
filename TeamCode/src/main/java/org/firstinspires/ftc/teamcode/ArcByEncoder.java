package org.firstinspires.ftc.teamcode;

public class ArcByEncoder {

    public static double PerimiterOfElipseOfTurn(double x, double y){
        return Math.PI*(3*(x+y) - Math.sqrt(((3*x+y)*(x+3*y))));
    }


}
