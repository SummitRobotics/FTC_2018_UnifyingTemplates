package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp
public class StarterTeleop extends LinearOpMode {
    private ElapsedTime gameTime = new ElapsedTime();
    StarterHardwareMap robot = new StarterHardwareMap(true);

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        robot.leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.addData("Status", "Ready to run.");

        waitForStart();
        gameTime.reset();
        //Everything that just happened is explained in the StarterAutonomous class, so go there if you need an explanation

        //This while loop makes sure the car can only move while the OpMode is active, so that, if you press the stop button, it'll stop moving
        while (opModeIsActive()) {
            double driveFwd = gamepad1.right_trigger;
            double driveBkwd = gamepad1.left_trigger;
            double turn = gamepad1.right_stick_x;
            //Here you can see that different parts of the controller are being assigned to different variables
            //It's important that this is done at the beginning of the while loop, because if it were anywhere else in the loop, it would cause latency
            //And if it were outside of the while loop, it would just take the value of the controller inputs when it goes over the card and they would never be changed
            //So basically, putting these at the start of the while loop forces them to update constantly update so your bot doesn't get stuck moving forwards or turning slightly

            double leftPower = Range.clip((driveFwd - driveBkwd) + turn, -1.0, 1.0);
            double rightPower = Range.clip((driveFwd - driveBkwd) - turn, -1.0, 1.0);
            //Here we're creating the variables that will contain the values that we'll actually be setting the motor powers to
            //One very important thing here is that we keep the values between 1.0 and -1.0, as it can create issues if it goes past these, so, to do this, we're using Range.clip
            //Other than that, most of the math for acceleration, braking, and turning is pretty simple
            //driveFwd - driveBkwd is what creates the braking/reverse feature
            //But you may see we have to add the turn value for the left motor and take it away for the right motor
            //This is because we have to take into account the fact that, when pushing the stick on the controller to the right, the x-value is negative, while to the left is positive

            robot.leftDrive.setPower(leftPower);
            robot.rightDrive.setPower(rightPower);
            //And finally, after the calculations and the clips, this is where we set the motor powers to what they need to be.
        }
    }
}
