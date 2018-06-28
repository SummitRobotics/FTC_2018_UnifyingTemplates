package org.firstinspires.ftc.teamcode;

//These are classes from the FTC offical code that we "import" to make our code actually work with the robot.
//Here, we're grabbing the class that allows us to indicate that this is an "Autonomous" opMode, a class that gives us the features of a LinearOpMode (explained below), and one that acts as a timer for the match.
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

//Here, we're telling the driver station app the name and category of our auto program. Since this is meant to be run during the autonomous part of the game, we label it "Autonomous"
@Autonomous(name= "Encoder Drive", group= "Autonomous")
//This names our class and tells it to use the features of a Linear Opmode, which tells the robot to run through this set of code once, step by step, as opposed to an Iterative opMode
public class StarterAutonomousEncoderDrive extends LinearOpMode {

    //These are the other classes which we call to make this Opmode work with our robot.
    //Some of the commands for the instructions we give to the robot, like "drive", are stored in other classes so that they can be used by multiple Opmodes.
    DriveByEncoder drive = new DriveByEncoder();
    StarterHardwareMap robot = new StarterHardwareMap(true);
    //Remember when we imported ElapsedTime above? Here we make use of it by initializing the timer.
    ElapsedTime gameTime = new ElapsedTime();



    @Override
    public void runOpMode() {
        //We're calling the init method of our hardwareMap in order to tell our code all the components of our robot.
        robot.init(hardwareMap);

        //This will tell the driver station (and the driver) when the initialization is complete and when to press the start button.
        telemetry.addData("Status", "Ready to run.");
        telemetry.update();

        //Nothing else will happen until the driver presses start, and the code will wait until then.
        waitForStart();
        //As soon as start is pressed, the timer will "reset", so that it's time is the same as the time since the opMode was started.
        gameTime.reset();

        // These are the instructions that the robot completes during the match. For more information about how these methods work, see "DriveByEncoder.java"
        //Robot will drive forward for 5 inches at 0.75 power.
        drive.driveByEncoder(5,5,0.75);
        //Robot will rotate 90 degrees clockwise at 0.5 power.
        drive.rotateByEncoder(90, 0.5);
        //Robot will drive forward for 12 inches at full power.
        drive.driveByEncoder(10, 10, 1);
    }
}
