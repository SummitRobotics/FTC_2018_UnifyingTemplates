package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotor;

public class Drive {

    StarterAutonomousTimeDrive opMode = new StarterAutonomousTimeDrive();
    StarterHardwareMap robot = new StarterHardwareMap(false);

    static final double countsPerRevolution = 537.6;
    static final double diameterOfWheel = 4.0;
    static final double gearRatio = 1.0;
    static final double lengthOfRobot = 18.0;

    static final double rotationalConstant = lengthOfRobot * Math.PI;


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


    public double getTicks(double inches){
        return inches * ((countsPerRevolution * gearRatio) / (diameterOfWheel * Math.PI));
    }


    public void driveByEncoder(double leftInches, double rightInches, double power){

        double leftTicks = getTicks(leftInches);
        double rightTicks = getTicks(rightInches);

        robot.leftDrive.setTargetPosition((int)leftTicks);
        robot.rightDrive.setTargetPosition((int)rightTicks);

        robot.leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION); robot.leftDrive.setPower(Math.abs(power));
        robot.rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION); robot.rightDrive.setPower(Math.abs(power));

        if((robot.leftDrive.isBusy() == false) && (robot.rightDrive.isBusy() == false)){
            robot.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }

    //clockwise rotation with positive angle
    public void rotateByEncoder(double angle, double power){
        double inches = (angle/360) * rotationalConstant;
        double ticks = getTicks(inches);

        robot.leftDrive.setTargetPosition((int)ticks);
        robot.leftDrive.setTargetPosition((int)ticks);

        robot.leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION); robot.leftDrive.setPower(Math.abs(power));
        robot.rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION); robot.rightDrive.setPower(Math.abs(power));

        if((robot.leftDrive.isBusy() == false) && (robot.rightDrive.isBusy() == false)){
            robot.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }

    }
}
