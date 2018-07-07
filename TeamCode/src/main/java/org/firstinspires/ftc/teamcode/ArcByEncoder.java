package org.firstinspires.ftc.teamcode;

public class ArcByEncoder {

    public static void Main(String args[]){
        System.out.println(getLengthOfArc(3,3));

    }

    public static double getLengthOfArc(double x, double y){
        return Math.PI*(3*(x+y) - Math.sqrt(((3*x+y)*(x+3*y))));
    }


}
