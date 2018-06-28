package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotor;

public class DriveByTime {

    StarterAutonomousTimeDrive opMode = new StarterAutonomousTimeDrive();
    StarterHardwareMap robot = new StarterHardwareMap(false);

    static final double countsPerRevolution = 537.6;
    static final double diameterOfWheel = 4.0;
    static final double gearRatio = 1.0;
    static final double lengthOfRobot = 17.0;
    static final double maxWidthOfRobot = 18.0;
    static final double widthOfRobot = 5.0;


    public void driveByTime(double time, double power) {
        time += opMode.gameTime.seconds();

        while (opMode.gameTime.seconds() <= time) {
            robot.leftDrive.setPower(power);
            robot.rightDrive.setPower(power);
        }
    }

    public void turnLeftByTime(double time, double power) {
        time += opMode.gameTime.seconds();

        while (opMode.gameTime.seconds() <= time) {
            robot.leftDrive.setPower(-power);
            robot.rightDrive.setPower(power);
        }
    }

    public void turnRightByTime(double time, double power) {
        time += opMode.gameTime.seconds();

        while (opMode.gameTime.seconds() <= time) {
            robot.leftDrive.setPower(power);
            robot.rightDrive.setPower(-power);
        }
    }

    public void driveByTime2(double time, double leftPower, double rightPower) {
        time += opMode.gameTime.seconds();

        while (opMode.gameTime.seconds() <= time) {
            robot.leftDrive.setPower(leftPower);
            robot.rightDrive.setPower(rightPower);
        }

    }
}