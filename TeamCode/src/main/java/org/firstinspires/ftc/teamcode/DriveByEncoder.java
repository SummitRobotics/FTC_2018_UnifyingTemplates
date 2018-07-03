package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
//This class has the methods which allow us to instruct the robot to drive and rotate autonomously, when given a number of inches.
public class DriveByEncoder {

    //We're calling the hardwareMap, so that this class actually applies to our robot. We set "encoders" to true so that our robot knows to activate and reset the encoders.
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

    //This method is used for finding the number of "ticks" a motor encoder needs to go to in order to move the number of inches that it was given.
    //But what is a "tick"?
    //Every encoder works by detecting when the motor axel rotates a certain distance, in order to measure rotation.
    //The CPR is how many times the encoder will detect a movement in 1 revolution.
    //For the Andymark NeveRest 60 motors, the CPR is 1680. So, for 1 rotation of the motor, the encoder will "tick" 1680 times.
    public double getTicks(double inches){
        //In order to how many ticks are in "x" inches, we take the CPR and multiply it by the gear ratio (if the wheel is rotating more times than the motor due to being geared up/down), then divide this number by the circumference of the wheel (in inches)
        return inches * ((countsPerRevolution * gearRatio) / (wheelDiameter * Math.PI));
    }

    //We use this method for driving a certain number of inches at a certain power.
    public void driveByEncoder(double leftInches, double rightInches, double power){
        //Create 2 variables to hold the number of ticks the motors need to rotate to in order to go the inputted number of inches.
        //Here's where we use the "getTicks" method.
        double leftTicks = getTicks(leftInches);
        double rightTicks = getTicks(rightInches);

        //Now we set the encoders' target (or it's goal, if it helps to think about it that way) to the number of ticks we just figured.
        robot.leftDrive.setTargetPosition((int)leftTicks);
        robot.rightDrive.setTargetPosition((int)rightTicks);

        //Now we tell the motors to rotate to that goal, at the given power.
        robot.leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftDrive.setPower(Math.abs(power));
        robot.rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightDrive.setPower(Math.abs(power));

        //This will unfreeze the robot from the target (goal) given above once that goal is met.
        //To do that, we detect when both motors are no longer "busy", in other words they've met their goal and stopped moving.
        //Notice that we're requiring both motors to stop moving before moving in order to stop this command (and move on to another command)
        //We do this for maximum accuracy. If you need to move between commands rapidly, feel free to change "and"(&&) to "or"(||).
        //This means the robot will move on to the next command if either of the motors reach their goal.
        if((robot.leftDrive.isBusy() == false) && (robot.rightDrive.isBusy() == false)){
            robot.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }

    //Here we're inputting an angle to rotate to and a power to do that rotation at, in order to do a "point-turn" (where the robot rotates/turns on it's center point)
    public void rotateByEncoder(double angle, double power){
        //In order to do this we have to do a bit of math to convert that angle to inches to turn.
        //First, we have to find the diameter of this rotation. We do this by calling the "getTurningRadius" method, and multiplying it by 2 to get diameter (radius = diameter/2). See the getTurningRadius method for more information about how we get that value.
        double diameter = getTurningRadius(robotLength, robotWidth) * 2;
        //Now, knowing the diameter, we need to know the circumference, and the percentage of that circumference that we're actually turning to. To do this, we find the circmference of the turning circle (diameter * pi), and multiply it by the percentage of 360 that the inputted angle is.
        double inchesOfRotation = (diameter * Math.PI) * (angle / 360);
        //Now we know how many inches the robot will rotate to. But, in order to make this work ,we have to convert inches to ticks just like we did in the "driveByEncoder" method. So, we input the inches to the "getTicks" method again.
        double ticks = getTicks(inchesOfRotation);

        //In order to rotate, one motor must be running the opposite direction of the other. So, we set the left motors' target to whatever the ticks value is, and the right motors to go to the same target, but backwards.
        robot.leftDrive.setTargetPosition((int)ticks);
        robot.rightDrive.setTargetPosition((int)-ticks);

        //Everything from this point on in the method is the exact same as in "driveByEncoder". See there for more info.
        robot.leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftDrive.setPower(Math.abs(power));
        robot.rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightDrive.setPower(Math.abs(power));

        if((robot.leftDrive.isBusy() == false) && (robot.rightDrive.isBusy() == false)){
            robot.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }

    }

    //note that this method is HIGHLY experimental and aidan killed himself over the course of 4 days designing the algorithim for it.
    //This is the method we use to find the turning radius, or the radius of the circle which circumscribes the rectangle formed by your robot's drive frame.
    //If your robot's drive frame isn't a rectangle, then fuck you, go make your own code.
    //If this still doesn't make sense, that's ok, go find someone to draw a diagram of how this works for you.
    //But in practice, this uses pythagorean's theorem to take a right-triangle (which is formed based on the length and width of your robot) which intersects the circumscribed "turning circle" at some point, and find the hypotenuse.
    //Because the hypotenuse goes from the center/origin of the circle to some intersection point on the circumference, hypotenuse = radius. 
    public double getTurningRadius (double robotLength, double robotWidth){
        return Math.sqrt((Math.pow((robotLength/2), 2) + (Math.pow((robotWidth/2), 2))));

    }
}

