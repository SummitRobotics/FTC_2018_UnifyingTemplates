package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class StarterAutonomousTimeDrive extends LinearOpMode {

    DriveByTime driveByTime = new DriveByTime();
    StarterHardwareMap robot = new StarterHardwareMap(false);
    ElapsedTime gameTime = new ElapsedTime();



    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        telemetry.addData("Status", "Ready to run.");
        telemetry.update();

        waitForStart();

        driveByTime.driveByTime(2.0, 0.6, 0.6);
        driveByTime.driveByTime(1.0, -0.5, 0.5);
        driveByTime.driveByTime(1.5, -0.6,-0.6;
        driveByTime.driveByTime(0.5, 0.5, -0.5);
    }
}
