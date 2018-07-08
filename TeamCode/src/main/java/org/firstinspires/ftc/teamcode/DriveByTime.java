package org.firstinspires.ftc.teamcode;

//This is the class that we will call when we want to drive the motors for a certain amount of time.
public class DriveByTime {

    //Here, we're calling the OpMode which we plan to use this class in
    //TODO - Make so "DriveByTime" class can be called by multiple opModes
    static MatchTime gameTime = new MatchTime();
    //We're also calling the hardware map so this class has accsess to the motors.
    //Because time driving doesn't require the use of encoders, we set encoders to false when calling the hardwareMap
    StarterHardwareMap robot = new StarterHardwareMap(false);

    //This is the method which is used for applying power to the motors.
    public void driveByTime(double time, double leftPower, double rightPower) {
        //Here we add the inputted time to the current Game Time, so the motors know to run for however long after this method is called.
        time += MatchTime.getTime();

        //We use a while loop to keep power applied until the time parameter is met (In other words, until the match timer exceeds our "Time" value.
        while (MatchTime.getTime() <= time) {
            robot.leftDrive.setPower(leftPower);
            robot.rightDrive.setPower(rightPower);
        }

    }
}