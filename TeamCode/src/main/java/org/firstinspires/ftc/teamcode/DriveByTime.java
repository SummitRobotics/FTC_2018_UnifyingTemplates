package org.firstinspires.ftc.teamcode;

public class DriveByTime {

    StarterAutonomousTimeDrive opMode = new StarterAutonomousTimeDrive();
    StarterHardwareMap robot = new StarterHardwareMap(false);

    public void driveByTime(double time, double leftPower, double rightPower) {
        time += opMode.gameTime.seconds();

        while (opMode.gameTime.seconds() <= time) {
            robot.leftDrive.setPower(leftPower);
            robot.rightDrive.setPower(rightPower);
        }

    }
}