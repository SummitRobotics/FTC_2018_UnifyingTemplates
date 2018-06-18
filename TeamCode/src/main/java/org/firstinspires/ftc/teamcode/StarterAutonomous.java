package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
@Disabled
public class StarterAutonomous extends LinearOpMode {
    Drive driveClass = new Drive();
    StarterHardwareMap robot = new StarterHardwareMap();

    //Everything in this method tells the bot what it actually needs to do
    @Override
    public void runOpMode() {
        //This initializes the hardware map, which just gets all the electronics setup on our bot
        robot.init(hardwareMap);
        robot.leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //This sets both motors to run without encoders, and should be done at the star of every OpMode that doesn't require the use of encoders
        //Encoders are largely used for autonomous, though do have some uses in TeleOp
        //Basically they're a more accurate way of tracking distance traveled, as opposed to time
        //In the case that you're making a class where you are using encoders, just change "RUN_WITHOUT_ENCODER" to "RUN_WITH_ENCODER"
        //You should also make sure to reset the encoders before activating them by using "STOP_AND_RESET_ENCODER"

        //This puts a message in the log on the phone that shows that the bot got up and running probably and is ready to go
        telemetry.addData("Status", "Ready to run.");
        telemetry.update();
        //Just to point it out, you have to put "telemetry.update();" every time you want it to place all the updates you've made into the log on the FTC app
        //So just keep that in mind when messing with telemetry, it can be easy to forget and really annoying

        //This is forcing the bot to wait for someone to press the start button on the phone before it can move on to the rest of the method
        waitForStart();

        //These are the methods we're using to move the bot, you can see an explanation of them in the Drive class, but for now I'll just show what each of these would do
        //Drives forwards for 2 seconds at 0.6 power
        driveClass.driveTime(2.0, 0.6);
        //Turns right (clockwise) for 1 second at 0.5 power
        driveClass.turnRightTime(1.0, 0.5);
        //Drives backwards for 1.5 seconds at 0.6 power
        driveClass.driveTime(1.5, -0.6);
        //Turns left (counter clockwise) for 0.5 seconds at 0.5 power
        driveClass.turnLeftTime(0.5, -0.5);
    }
}
