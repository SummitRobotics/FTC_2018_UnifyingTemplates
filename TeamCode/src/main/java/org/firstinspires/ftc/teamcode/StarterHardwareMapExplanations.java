package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

//Created by Jamey, 11:57 PM, 6/13/18
//NOTE TO AIDAN: I tried to write explanations for most everything here so the programmers can refer back to them if they wish to, or so we could refer to them for better thought-out explanations
//These explanations were written with the idea that the programmers would have minimal to no Java knowledge, and that they would come to us for explanations on the finer details, if they wanted it
//You probably have a much better understanding of everything that's going on here though, so feel free to change anything at your own discretion

public class StarterHardwareMapExplanations {
    public DcMotor leftDrive;
    public DcMotor rightDrive;
    //Here we're assigning variables to the DcMotor object so that we can later use them to initialize motors, servos, and anything else you need
    //These variables should be named similarly to the motors, servos, etc. hooked up to the bot, as we're going to use them in conjunction with each other later
    //You can add more motor variables exactly how you see it done above, and servo variables can be added through a similar process, but replacing "DcMotor" with "Servo"
    //Without quotes, of course
    //If you want to add any other types of device, but don't know how to, either ask Aidan or Jamey, or refer to the FTC documentation

    //NOTE TO AIDAN: I think it would be good to have them start out with a hardware map and an OpMode that simply have the basics to get a bot up and running and driving around
    //As they add more to the bot, such as an arm and a claw, the programmers can go in and add those parts to the HWMap and the OpMode, with our help of course
    //But the main idea is that it would help them get a better hands-on understanding of these classes instead of just copying and pasting them everywhere without really fully understanding them
    //And it might make the programmers feel like they'e contributing more to the construction and progression of the bot, which is always good

    HardwareMap hwMap;
    //Here we're assigning variable "hwMap" to be an object "HardwareMap", allowing us to use the variable hwMap in cases meant for HardwareMap objects
    //If that explanation went over your head, don't worry about this too much, but if you really do want to know more, just ask Aidan or Jamey

    //NOTE TO AIDAN: I have no idea if I used the right terms to explain this, or if this is even what this is doing
    //If I did happen to get it right, you should still probably reword the explanation with your superior Java knowledge
    //TL;DR: Fix it please I don't know what I'm doing

    //Constructor (this is just what it says in the example file, I don't know what's happening here either)X
    public StarterHardwareMapExplanations() {

    }

    //Here we're creating the method that we're actually going to use in other OpModes to help set everything up.  This is where the convenience of hardware maps comes in
    //When setup correctly, simply calling this method will get everything ready, saving tons of space, making everything look clean, and hopefully impressing judges with your understanding of Java
    public void init(HardwareMap ahwMap) {
        //Saves the HardwareMap reference to the "hwMap" variable, which is of the "HardwareMap" object
        //If you'd like a better explanation on exactly what that means, then ask Aidan or Jamey about it, but it's not too big a deal
        hwMap = ahwMap;

        //After you do that, you can start defining and initializing all you motors, servos, etc.
        //This is where the variables we created earlier come into play.  Each of those variables have to be assigned to the corresponding motor or servo on the bot
        leftDrive = hwMap.get(DcMotor.class, "left_drive");
        rightDrive = hwMap.get(DcMotor.class, "right_drive");
        //One thing we need to keep in mind is that, for this hardware map to work, we need to have a streamlined naming system
        //Motors on the left side of our bot need to be named "left_drive" and motors on the right side need to be named "right_drive"
        //Without quotes, of course
        //If the electronics on your bot aren't named the same way they're named here, everything will break and you will have a bad time
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        //You will also need to reverse one motor on the bot due to the fact that, when you attach the motors to each side, both sides will be flipped relevant to each other
        //This means that, inevitably, on side would be backwards
        //This specific setup is for AndyMark motors, since I'm pretty sure that's what we're using.  If not, just change "leftDrive" to "rightDrive"

        leftDrive.setPower(0);
        rightDrive.setPower(0);
        //This is simple, all we're doing is setting the power of both the motors to 0 just in case
        //You don't need to do this with other electronics to my knowledge, though you will have to set a start point for servos.  If you want to do this, but don't know how, just ask Aidan or Jamey

        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //This sets both motors to run without encoders.  Encoders are largely used for autonomous, though do have some uses in TeleOp
        //Basically they're a more accurate way of tracking distance traveled, as opposed to time
        //Since we probably won't be using them immediately, I have them defaulted to off here, but when we do add them, just change "RUN_WITHOUT_ENCODER" to "RUN_WITH_ENCODER"

        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //This changes what the motors do when power = 0.
        //In "Brake" mode, the motors will stop all forward movemement by applying a short burst of power in reverse, while in "Float" mode the robot will keep coasting with its forward momentum
        //In my experience, "Brake" mode makes the robot feel more snappy or responsive.
    }
}
