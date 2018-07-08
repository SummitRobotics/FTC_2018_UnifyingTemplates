package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;


public class MatchTime {

    public MatchTime(){

    }

   private static ElapsedTime matchTime = new ElapsedTime();


   public static double getTime(){
       return matchTime.seconds();
   }

}
