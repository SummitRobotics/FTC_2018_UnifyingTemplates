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

    //Everything in this method tells the bot what it actually needs to do
    @Override
    public void runOpMode() {
        //This initializes the hardware map, which just gets all the electronics setup on our bot
        robot.init(hardwareMap);

        //This puts a message in the log on the phone that shows that the bot got up and running probably and is ready to go
        telemetry.addData("Status", "Ready to run.");
        telemetry.update();
        //Just to point it out, you have to put "telemetry.update();" every time you want it to place all the updates you've made into the log on the FTC app
        //So just keep that in mind when messing with telemetry, it can be easy to forget and really annoying

        //This is forcing the bot to wait for someone to press the start button on the phone before it can move on to the rest of the method
        waitForStart();

        //These are the methods we're using to move the bot, you can see an explanation of them in the Drive class, but for now I'll just show what each of these would do
        //Drives forwards for 2 seconds at 0.6 power
        drive(robot, 2.0, 0.6);
        //Turns right (clockwise) for 1 second at 0.5 power
        turn(robot, 1.0, 0.5);
        //Drives backwards for 1.5 seconds at 0.6 power
        drive(robot, 1.5, -0.6);
        //Turns left (counter clockwise) for 0.5 seconds at 0.5 power
        turn(robot, 0.5, -0.5);
    }
}
