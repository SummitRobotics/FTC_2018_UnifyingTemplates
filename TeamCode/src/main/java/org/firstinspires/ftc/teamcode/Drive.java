package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;

public class Drive {
    private ElapsedTime gameTime = new ElapsedTime();
    StarterHardwareMap robot = new StarterHardwareMap();
    //I'm too tired to make up a bs explanation for this stuff right now so do it for me Aidan

    //These are the methods used in your autonomous class to make the robot actually go
    //Methods allow you to easily run chunks of code you may want to use more than once by simply typing the name of the method and giving it any values it needs
    //This method, for example, only needs two values: "time" and "power", so, when calling it, all I would have to write is something like:
    // drive(3.0, 0.6);
    //Which would make the robot move forwards at 0.6 power for 3 seconds
    public void driveTime(double time, double power){
        time += gameTime.seconds();
        //This is more for convenience than anything
        //I won't get too into the logic here, but basically all you need to know is it makes setting the time a lot easier

        while(gameTime.seconds() <= time){
            robot.leftDrive.setPower(power);
            robot.rightDrive.setPower(power);
        }
        //This is what makes the robot move.  We're doing this using a "while" loop
        //While loops work similarly to if statements, when the code comes across them, it checks if the conditions are true, and, if they are, it runs the statement
        //The only difference is, once the statement has been run, it'll go back to the top and check if the conditions are true again and will keep doing so until they are false
        //Once the conditions are false it exits the while loop and moves on to the next thing
        //Inside the while loop, the motor power for both motors are being set to the inputted power
        //This also means that we can use this function to move the bot backwards as well, if we wish to
        //We just have to place a negative number for the power when calling it
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
        //And then we set the power to 0 at the end because apparently that's part of the rules or something but who reads those amiright
    }

    //These other two methods methods are fundamentally the same as the first one
    //The main difference is that one of the motors is set to the negative of the inputted power value, allowing the bot to turn on the spot
    public void turnLeftTime(double time, double power){
        time += gameTime.seconds();

        while(gameTime.seconds() <= time){
            robot.leftDrive.setPower(-power);
            robot.rightDrive.setPower(power);
        }
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }

    //Both of these turning methods could be combined into one if you really wanted to
    //You'd just have to remember which direction requires a negative power number and which requires a positive
    //For example, if I were to call turnRight but set the power to -0.5, the bot would instead turn left
    //If you do opt for that method, one thing I would recommend is to always have a comment above your method saying which is which
    public void turnRightTime(double time, double power){
        time += gameTime.seconds();

        while(gameTime.seconds() <= time){
            robot.leftDrive.setPower(power);
            robot.rightDrive.setPower(-power);
        }
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }
}
