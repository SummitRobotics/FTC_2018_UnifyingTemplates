package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class StarterAutonomous extends LinearOpMode {
    StarterHardwareMap robot = new StarterHardwareMap();
    public ElapsedTime gameTime = new ElapsedTime();



    @Override
    public void runOpMode() {
        robot.init(hardwareMap);

        telemetry.addData("Status", "Ready to run.");
        telemetry.update();

        waitForStart();

        drive(robot, 2.0, 0.6);
        turn(robot, 1.0, 0.5);
        drive(robot, 1.5, -0.6);
        turn(robot, .5, -0.5);
    }

    public void drive(StarterHardwareMap robot, double duration, double power) {
        if (power > 0.6) {
            power = 0.6;
        }
        if (power < -0.6) {
            power = -0.6;
        }

        while (gameTime.seconds() < duration) {
            robot.leftDrive.setPower(power);
            robot.rightDrive.setPower(power);
        }
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }

    //When calling this statement, set "power" double to positive for right (clockwise) turn and negative for left (counter clockwise) turn
    public void turn(StarterHardwareMap robot, double duration, double power) {
        if (power > 0.5) {
            power = 0.5;
        }
        if (power < -0.5) {
            power = -0.5;
        }

        while (gameTime.seconds() < duration) {
            robot.leftDrive.setPower(power);
            robot.rightDrive.setPower(-power);
        }
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }
}
