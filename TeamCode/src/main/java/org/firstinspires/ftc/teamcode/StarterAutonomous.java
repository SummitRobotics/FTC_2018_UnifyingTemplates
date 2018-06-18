package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
@Disabled
public class StarterAutonomous extends LinearOpMode {

    //These are your instance variables. They're declared before any methods and can be accessed by any part of this class.

    //Creates an object of the Drive class, which allows us to use the methods declared there to drive the robot. See "Drive.java" for more details.
    Drive driveClass = new Drive();
    //Calls the hardware map for your robot. See "StarterHardwareMap.java" for more info.
    //If your're using a hardware map that isn't the starter one, change "StarterHardwareMap" to the name of your hardware map class in both places in this statement.
    //The "encoders: false" parameter indicates whether encoders are being used or not. Change it to "true" if you are using encoders in this opMode.
    StarterHardwareMap robot = new StarterHardwareMap(false);
    //This object tracks how long the opMode has been running.
    ElapsedTime gameTime = new ElapsedTime();


    //This method is the instructions to your robot. Everything in this method is what actually runs when you start your robot.
    //Because this opMode is linear, it will take all the instructions in this method and run through them step-by-step. Once it reaches the end of the method, the robot will stop.
    @Override
    public void runOpMode() {
        //This calls the hardware map, which will initialize all the hardware on the robot as objects in the code.
        robot.init(hardwareMap);

        robot.leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //This sets both motors to run without encoders, and should be done at the star of every OpMode that doesn't require the use of encoders


        //This puts a message in the log on the phone that shows that the bot got up and running probably and is ready to go
        telemetry.addData("Status", "Ready to run.");
        telemetry.update();
        //Just to point it out, you have to put "telemetry.update();" every time you want it to place all the updates you've made into the log on the FTC app
        //So just keep that in mind when messing with telemetry, it can be easy to forget and really annoying

        //This is forcing the bot to wait for someone to press the start button on the phone before it can move on to the rest of the method
        waitForStart();

        //These are the methods we're using to move the bot, you can see an explanation of them in the Drive class, but for now I'll just show what each of these would do
        //Drives forwards for 2 seconds at 0.6 power
        driveClass.driveByTime(2.0, 0.6);
        //Turns right (clockwise) for 1 second at 0.5 power
        driveClass.turnRightByTime(1.0, 0.5);
        //Drives backwards for 1.5 seconds at 0.6 power
        driveClass.driveByTime(1.5, -0.6);
        //Turns left (counter clockwise) for 0.5 seconds at 0.5 power
        driveClass.turnLeftByTime(0.5, -0.5);
    }
}
