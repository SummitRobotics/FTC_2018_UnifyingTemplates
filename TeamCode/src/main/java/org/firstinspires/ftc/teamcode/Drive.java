package org.firstinspires.ftc.teamcode;


public class Drive {

    StarterAutonomous opMode = new StarterAutonomous();
    StarterHardwareMap robot = new StarterHardwareMap();

    public void driveByTime(double time, double power){
        time += opMode.gameTime.seconds();

        while(opMode.gameTime.seconds() <= time){
            robot.leftDrive.setPower(power);
            robot.rightDrive.setPower(power);
        }
    }

    public void turnLeftByTime(double time, double power){
        time += opMode.gameTime.seconds();

        while(opMode.gameTime.seconds() <= time){
            robot.leftDrive.setPower(-power);
            robot.rightDrive.setPower(power);
        }
    }

    public void turnRightByTime(double time, double power){
        time += opMode.gameTime.seconds();

        while(opMode.gameTime.seconds() <= time){
            robot.leftDrive.setPower(power);
            robot.rightDrive.setPower(-power);
        }
    }
}
