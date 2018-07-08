package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class StarterAutonomousTimeDrive extends LinearOpMode {

    DriveByTime driveByTime = new DriveByTime();
    StarterHardwareMap robot = new StarterHardwareMap(false);
    ElapsedTime gameTime = new ElapsedTime();



    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        telemetry.addData("Status", "Ready to run.");
        telemetry.update();

        waitForStart();
        //For an explanation of everything that just happened (Referred to as the Opmode initialization) above, please see "StarterAutonomousEncoderDrive.java"

        //The main difference between driving by time and encoders is how we tell the motors what their goal is.
        //With time drive, we're telling the motors to spin at "x" power until a certain amount of time has passed.
        //Here, we're telling the motors to drive for a certain amount of time at a certain speed.
        //To turn, we want one side of wheels spinning the opposite direction of the others. Whichever side is spinning in reverse is the direction of the turn.

        //Drives forward at 0.6 speed for 2 seconds
        driveByTime.driveByTime(2.0, 0.6, 0.6);
        //Turns left at half power for 1 second
        driveByTime.driveByTime(1.0, -0.5, 0.5);
        //Goes backwards at 0.6 power for 1.5 seconds
        driveByTime.driveByTime(1.5, -0.6,-0.6);
        //Turns right at half power for half a second
        driveByTime.driveByTime(0.5, 0.5, -0.5);
    }
}
