package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

<<<<<<< HEAD
//This is your TeleOp-erated OpMode. This is the code that you will use during the driver-controlled part of the game to drive your robot with the Logitech Gamepad.
//The basic principle of this code is to take the input of triggers/joysticks and use those doubles(what java calls numbers with decimals) to assign power to the motors.
//Remember that buttons can return a boolean value of true or false, triggers can return a value between 0 and 1, and joysticks can return a value between -1 and 1 (-1 being all the way left, 1 being all the way right)
//Though you can use any of the buttons/triggers/joysticks to control the robot as long as they return some sort of value, we chose to have the right trigger make the robot go forward, the left trigger make it go backward, and the right stick for turning.
//(We chose these controls because they're the same as the controls for our drivers' favorite game, Rocket League. So we call them "Rocket League controls")
=======
>>>>>>> experimental

@TeleOp
//Extending to "LinearOpMode" means that this op mode will be executed linearly. In other words, the instructions will be executed from top to bottom.
public class StarterTeleop extends LinearOpMode {
    //Instance Variables. These are declared before any method and can be accessed in any part of this class.
    //ElapsedTime is a timer that keeps track of how long the OpMode has been running.
    private ElapsedTime gameTime = new ElapsedTime();
<<<<<<< HEAD
    //Here we're calling the hardware map of the robot. This will allow our code to access the individual parts (motors, servos, other electronics) of the robot, which will be represented as objects.
    //We want encoders to be running, since under teleop control encoders can be used to make sure all motors are in sync
    //If your motors don't have encoders on them (or they're not plugged in), change encoders to "false".
=======
>>>>>>> experimental
    StarterHardwareMap robot = new StarterHardwareMap(true);

    @Override
    //This method contains the instructions that will be run when you start your robot.
    public void runOpMode() {
        //We're initializing all the hardware objects and tying them to the actual component as listed on the phone's configuration file. See "StarterHardwareMap" for more info.
        robot.init(hardwareMap);

        //Tells the driver that the initialization has completed.
        telemetry.addData("Status", "Ready to run.");
        telemetry.update();

        //Waits until the "Play" button is pressed on the driver station.
        waitForStart();
        //Starts the timer.
        gameTime.reset();
<<<<<<< HEAD
=======
        //Everything that just happened is explained in the StarterAutonomous class, so go there if you need an explanation
>>>>>>> experimental

        //We want to repeatedly check the values of the buttons on the controller so that, when those values change (when we press/release them), the motor power changes correspondingly.
        //We use a while loop to do this. As long as the op mode is active, which means the robot is running, this bit of code will be run repeatedly.
        while (opModeIsActive()) {

            //The first thing this loop will do is check for changes to the values of the right trigger, left trigger, and right joystick.
            //This must be done at the beginning of the loop, otherwise the motor power will be assigned to the values of the gamepad during the last loop-through, which will make driving your robot feel laggy.
            double driveFwd = gamepad1.right_trigger;
            double driveBkw = gamepad1.left_trigger;
            //note that we're only using the "x' value of the right stick to turn. This is because we are only using the joystick to move left/right, so we only need the left/right values of the joystick, which is it's x-axis
            double turn = gamepad1.right_stick_x;


            double leftPower = Range.clip((driveFwd - driveBkw) - turn, -1.0, 1.0);
            double rightPower = Range.clip((driveFwd - driveBkw) + turn, -1.0, 1.0);
            //These variables are what will actually be passed to the motors.
            //Here we're using an algorithim where we input the "driveFwd, driveBkw, and turn" variables, and a value between -1 and 1 is outputted.
            //The first thing we're doing is taking the value of the right trigger (driveFwd) and subtracting it from the value of the left trigger (driveBkw). This will mean that the power will be the difference between the left and right trigger.
            //So, if driveFwd was 0, and drive Bkw was 1, then -1 would be returned. A negative power value will make the robot go backward, so subtracting one trigger from the other was successful.
            //Now, with the value of the two triggers calculated, we then either add or subtract the turn variable. The reason that one is added and subtracted is because the motors must be spinning opposite from eachother to make the robot spin.
            //So, if both triggers are at 0, and turn is at -1 (meaning the stick was all the way to the left), leftPower would be at -1 and rightPower would be at 1. Which would make the robot turn left.
            //Finally, we take all of this and input it into the "Range.clip" function, and set the min to -1 and the max to 1. This makes it so the motor power can not exceed -1 to 1, which is important because the motors can't accept a value past that.

            robot.leftDrive.setPower(leftPower);
            robot.rightDrive.setPower(rightPower);
            //And finally, after the calculations and the clips, this is where we set the motor powers to what they need to be.
        }
    }
}
