package org.firstinspires.ftc.teamcode;

public class Drive {

    StarterAutonomous AutoOpMode = new StarterAutonomous();
    StarterHardwareMap robot = new StarterHardwareMap();

    public void moveFwd(double time, double power){

        while(AutoOpMode.gameTime.seconds() <= time){
            robot.leftDrive.setPower(power);
            robot.rightDrive.setPower(power);
        }

    }

    public void moveBkw(double time, double power){

        while(AutoOpMode.gameTime.seconds() <= time){
            robot.leftDrive.setPower(-power);
            robot.rightDrive.setPower(-power);
        }

    }

    public void turnLeft(double time, double power){

        while(AutoOpMode.gameTime.seconds() <= time){
            robot.leftDrive.setPower(-power);
            robot.rightDrive.setPower(power);
        }

    }

    public void turnRight(double time, double power){

        while(AutoOpMode.gameTime.seconds() <= time){
            robot.leftDrive.setPower(power);
            robot.rightDrive.setPower(-power);
        }

    }

}
