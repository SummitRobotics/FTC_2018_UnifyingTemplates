package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


//Created by Jamey, 11:57 PM, 6/13/18


public class StarterHardwareMap {
    //These are your instance variables of the HardwareMap. These variables will be created and used in your opMode, each variable represents a component on your robot.

    public DcMotor leftDrive;
    public DcMotor rightDrive;
    //This creates a variable for your two motors (or both sides of motors if you have a 4 motor driveframe). If you're using more motors on your robot, create them here.


    HardwareMap hwMap;
    //Here we're creating an empty hardwareMap object, to intialize our hardware map.

    boolean isEncoderInUse;
    //This true or false statement will be used to tell the hardware map whether to enable encoders or not.

    //This is the constructor for your hardware map. A constructor is the code that runs when you create an "object" of the class (See StarterAutonomous.java for an example of when we make an object of this hardware map)
    //In short, this is the method that actually makes it so we can call the hardwareMap in other classes.
    //Inside this constructor, we have a boolean (true/false statement) variable "encoders" When this object is called in another class, you will tell the object if encoders are being used (true) or not (false)
    //It will then take whatever your input was and save it to the "isEncoderInUse" instance variable.
    // I recommend googling "What is a constructor java" for more info.
    public StarterHardwareMap(boolean encoders) {

        isEncoderInUse = encoders;

    }

    //Here we're creating the method that we use in other OpModes to help set everything up.  This is where the convenience of hardware maps comes in
    //When setup correctly, simply calling this method will get everything ready, saving tons of space and making everything look clean.
    public void init(HardwareMap ahwMap) {
        //Remember that empty hardwareMap object? This takes whatever you've passed to this init method and passes it into our previously blank hardware map.
        hwMap = ahwMap;
        //In general, you'll be passing "hardwareMap" into hardwareMap. This may seem redundant, but it keeps the hardware map in this class and the one being reference by this init method on the same page.

        //After you do that, you can start initializing all you motors, servos, etc, and giving them a reference to the actual component that you hopefully put on the config file on the phone.
        //This is where the variables we created earlier come into play.  Each of those variables have to be assigned to the corresponding motor or servo on the bot
        leftDrive = hwMap.get(DcMotor.class, "left_drive");
        rightDrive = hwMap.get(DcMotor.class, "right_drive");
        //One thing we need to keep in mind is that, for this hardware map to work, the names have to be consistent.
        //Motors on the left side of our bot need to be named "left_drive" and motors on the right side need to be named "right_drive" in the hardware configuration on the phone.
        //Without quotes, of course
        //If the electronics on your bot aren't named the same way they're named here, everything will break and you will have a bad time

        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        //You will also need to reverse one motor on the bot due to the fact that, when you attach the motors to each side, both sides will be flipped relevant to each other
        //This means that, inevitably, on side would be backwards
        //This specific setup is for AndyMark motors.  If your robot is still going backwards instead of forwards, just change "leftDrive" to "rightDrive"

        leftDrive.setPower(0);
        rightDrive.setPower(0);
        //This is simple, all we're doing is setting the power of both the motors to 0 just in case
        //You don't need to do this with other electronics to my knowledge, though you will have to set a start point for servos.  If you want to do this, but don't know how, just ask Aidan or Jamey

        //This if-else statement tells the robot whether to enable encoders or not.
        //If, when the hardware map is called, encoders are set to true, the motors will be told to run using encoders and will start the encoders at 0.
        //If it's set to false, the motors will run without encoders.
        //If there's no input, nothing will be done (In future, this should throw an error
        if(isEncoderInUse == true){
            leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }
        else if(isEncoderInUse == false){
            leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
        else{}
        //If, when this hardware map is called, encoders is set to true, then the motors' run mode will be set to "run using encoders" and the encoders will be reset to 0.
        //Else, if it was set to false, the motors will run without encoders.
        //If neither of these statements are true, nothing will happen (though this will probably break the opMode.)

        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //This changes what the motors do when power = 0.
        //In "Brake" mode, the motors will stop all forward movemement by applying a short burst of power in reverse, while in "Float" mode the robot will keep coasting with its forward momentum
        //In my experience, "Brake" mode makes the robot feel more snappy or responsive.
    }
}
