package org.firstinspires.ftc.teamcode;


public class Drive {

    //These are your instance variables. They're declared before any methods, and can be accessed by any method in this class.

    //This creates an object of your op mode, "StarterAutonomous", so that we can view how long that op mode has been running. See "ElapsedTime gameTime" in StarterAutonomous.java for more info
    StarterAutonomous opMode = new StarterAutonomous();

    //This creates an instance of your hardware map, which is in the "StarterHardwareMap.java" class. See there for more info.
    StarterHardwareMap robot = new StarterHardwareMap();


    //These are the methods used in your autonomous op mode to make the robot drive
    //Methods allow you to easily run chunks of code you may want to use more than once by simply typing the name of the method and giving it any values it needs

    //This method, for example, needs two parameters: "time" (which is in seconds) and "power" (which is a value from -1 to 1) so, when calling it, all you would have to write is:
    // drive(3.0, 0.6);
    //This method would then be "called", which would run any code inside the method, with the "parameters" passed in as values for how the method will run.
    //So, the robot move forwards at 0.6 power for 3 seconds
    public void driveByTime(double time, double power){
        time += opMode.gameTime.seconds();
        //Here we're adding "time" to however long the opMode has already been running, so that a drive method can be called at any time during the match and will always run for however many seconds specified in the "time" parameter.

        while(opMode.gameTime.seconds() <= time){
            robot.leftDrive.setPower(power);
            robot.rightDrive.setPower(power);
        }
        //This is what makes the robot move.  We're doing this using a "while" loop
        //A while loop is kind of self-explanatory. While the conditions inside the parenthesis are true, the code inside the while loop will execute. Once it executes, it'll check to make sure the conditions are still true, and keep executing the code over and over.
        //Once the conditions are false it exits the while loop and moves on to the next thing

        //Inside the while loop, the motors are being set to the speed that we told it to in the "power" parameter.
        //Remember that negative power makes the motors spin in the other direction (so the robot will move backwards)
        //So, if you want to use this method to make the robot move backwards instead of forwards, you would just change the power parameter to a negative number (when you call the method in your autonomous)).
    }

    //These other two methods methods are almost the same as the first one, but you'll notice that one side of the motors is set to negative power.
    //This means that one motor (or set of motors) will be running forwards at power, and the other side will be running backwards at power.
    //Which makes the robot turn. Remember that whatever direction you're trying to turn, you should set that side as negative in the code.
    public void turnLeftByTime(double time, double power){
        time += opMode.gameTime.seconds();

        while(opMode.gameTime.seconds() <= time){
            robot.leftDrive.setPower(-power);
            robot.rightDrive.setPower(power);
        }
    }

    //Both of these turning methods could be combined into one if you really wanted to
    //You'd just have to remember which direction requires a negative power number and which requires a positive
    //For example, if I were to call turnRight but set the power to -0.5, the bot would instead turn left
    //If you do opt for that method, one thing I would recommend is to always have a comment above your method saying which is which
    public void turnRightByTime(double time, double power){
        time += opMode.gameTime.seconds();

        while(opMode.gameTime.seconds() <= time){
            robot.leftDrive.setPower(power);
            robot.rightDrive.setPower(-power);
        }
    }
}
