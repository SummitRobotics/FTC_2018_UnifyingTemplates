package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
@Disabled
public class StarterAutonomousExplanations extends LinearOpMode {
    StarterHardwareMap robot = new StarterHardwareMap();
    private ElapsedTime period = new ElapsedTime();
    //Variable "period", which is of object type "ElapsedTime" is now tracking the total amount of time elapsed in the match

    //NOTE TO AIDAN: I have little to know idea what's going on here as well.  Objects are still kind of confusing to me, if you couldn't tell

    //Everything in this method tells that bot what it actually needs to do
    @Override
    public void runOpMode() {
        //This initializes the hardware map, which just gets all the electronics setup on our bot
        robot.init(hardwareMap);

        //This puts a message in the log on the phone that shows that the bot got up and running probably and is ready to go
        telemetry.addData("Status", "Ready to run.");
        telemetry.update();
        //Just to point it out, you have to put "telemetry.update();" every time you want it to place all the updates you've made into the log
        //So just keep that in mind when messing with telemetry, it can be easy to forget

        //This is forcing the bot to wait for someone to press the start button on the phone before it can move on to the rest of the method
        waitForStart();

        //These are the methods we're using to move the bot, you can see an explanation of them below, but for now I'll just show what each of this would do
        //Drive forwards for 2 seconds at 0.6 power
        drive(robot, 2.0, 0.6);
        //Turns right (clockwise) for 1 second at 0.5 power
        turn(robot, 1.0, 0.5);
        //Drives backwards for 1.5 seconds at 0.6 power
        drive(robot, 1.5, -0.6);
        //Turns left (counter clockwise) for 0.5 seconds at 0.5 power
        turn(robot, 0.5, -0.5);
    }

    //These are the methods used to make the bot actually move in autonomous
    //Without methods, it's super messy getting your bot to move autonomously, but using them makes it really easy and clean
    public void drive(StarterHardwareMap robot, double duration, double power) {
        if (power > 0.6) {
            power = 0.6;
        }
        if (power < -0.6) {
            power = -0.6;
        }
        //These are clamps, keeping you from going over a certain speed, as that can cause issues.  These are most likely unnecessary, though, so feel free to remove them if you need to
        //If you don't remove them, though, I would encourage experimentation with what max speeds to find what's effective and changing them accordingly
        //Just make sure you don't go over a power of 1

        while (period.seconds() < duration) {
            robot.leftDrive.setPower(power);
            robot.rightDrive.setPower(power);
        }
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
        //This is what makes the robot move.  We're doing this using a "while" loop
        //While loops work similarly to if statements, when the code comes across them, it checks if the conditions are true, and, if they are, it runs the statement
        //The only difference with while loops is, once the statement has been run, it'll go back to the top and check if the conditions are true again and will keep doing so until they are false
        //Once the conditions are false it exits the while loop and moves on to the next thing, which is setting motor power to 0
        //Again, setting motor power to 0 is also probably unnecessary and may be removed if you want, but it's another "just in case" thing
    }

    //This method is different from the previous method in that, instead of allowing you to simply drive forwards and backwards, it turns the bot in place
    //The main difference from the above method, and the thing that makes the bot turn, is that it sets one of the motors to be the negative of the inputted power double
    //This means that the direction the bot turns will be dependant on whether or not the number you placed for the power double is positive
    //For example, if I wanted to bot to turn right (clockwise) for 3 seconds, I would call this statement like so:
    //turn(robot, 3.0, 0.5);
    //                 ^As you can see here, the power is positive, which would make the bot turn right
    public void turn(StarterHardwareMap robot, double duration, double power) {
        if (power > 0.5) {
            power = 0.5;
        }
        if (power < -0.5) {
            power = -0.5;
        }

        while (period.seconds() < duration) {
            robot.leftDrive.setPower(power);
            robot.rightDrive.setPower(-power);
        }
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }
}
