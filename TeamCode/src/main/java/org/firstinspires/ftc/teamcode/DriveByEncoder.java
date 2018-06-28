package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class DriveByEncoder {

    StarterAutonomousEncoderDrive opMode = new StarterAutonomousEncoderDrive();
    StarterHardwareMap robot = new StarterHardwareMap(true);

    //Measure the distance from the front wheel axel to the rear wheel axel for 4WD
    private static final double robotLength = 18;
    //Measure the distance from the center of a left-side wheel to the center of a corresponding right-side wheel (or vice versa)
    private static final double robotWidth = 18;
    //Figure in any gearing ratio between the motor output and the wheel output here. Ratio of 1:1 = 1, 2:1 = 1, 1:2 = 0.5, etc.
    private static final double gearRatio = 1;
    private static final double wheelDiameter = 4;

    //CPR for an Andymark NeveRest 60 Classic Gearmotor: 1680
    //Andymark NeveRest Orbital 20 Gearmotor: 537.6
    //Tetrix Motor: 1440
    //For any other motor, look for "Encoder Counts Per Revolution" (or CPR for short) on the motor's tech specs.
    //If using a non-integrated encoder, god help you.
    private static final double countsPerRevolution = 1680;


    public double getTicks(double inches){
        return inches * ((countsPerRevolution * gearRatio) / (wheelDiameter * Math.PI));
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
        double diameter = getTurningRadius(robotLength, robotWidth) * 2;
        double inchesOfRotation = (diameter * Math.PI) * (angle / 360);
        double ticks = getTicks(inchesOfRotation);

        robot.leftDrive.setTargetPosition((int)ticks);
        robot.rightDrive.setTargetPosition((int)-ticks);

        robot.leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION); robot.leftDrive.setPower(Math.abs(power));
        robot.rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION); robot.rightDrive.setPower(Math.abs(power));

        if((robot.leftDrive.isBusy() == false) && (robot.rightDrive.isBusy() == false)){
            robot.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }

    }
    public double getTurningRadius (double robotLength, double robotWidth){
        return Math.sqrt((Math.pow((robotLength/2), 2) + (Math.pow((robotWidth/2), 2))));

    }
}

