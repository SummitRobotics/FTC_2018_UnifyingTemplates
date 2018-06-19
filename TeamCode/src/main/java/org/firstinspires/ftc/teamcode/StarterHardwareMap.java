package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class StarterHardwareMap {

    public DcMotor leftDrive;
    public DcMotor rightDrive;

    HardwareMap hwMap;

    boolean isEncoderInUse;
    public StarterHardwareMap(boolean encoders) {

        isEncoderInUse = encoders;

    }
    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        leftDrive = hwMap.get(DcMotor.class, "left_drive");
        rightDrive = hwMap.get(DcMotor.class, "right_drive");
        leftDrive.setDirection(DcMotor.Direction.REVERSE);

        leftDrive.setPower(0);
        rightDrive.setPower(0);

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

        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}
