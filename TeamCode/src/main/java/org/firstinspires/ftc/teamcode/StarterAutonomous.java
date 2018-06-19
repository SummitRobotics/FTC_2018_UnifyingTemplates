package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
@Disabled
public class StarterAutonomous extends LinearOpMode {

    Drive driveClass = new Drive();
    StarterHardwareMap robot = new StarterHardwareMap(false);
    ElapsedTime gameTime = new ElapsedTime();



    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        robot.leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);




        telemetry.addData("Status", "Ready to run.");
        telemetry.update();

        waitForStart();

        driveClass.driveByTime(2.0, 0.6);
        driveClass.turnRightByTime(1.0, 0.5);
        driveClass.driveByTime(1.5, -0.6);
        driveClass.turnLeftByTime(0.5, -0.5);
    }
}
