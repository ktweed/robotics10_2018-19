package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="Basic: Linear OpMode", group="Linear Opmode")

public class BasicTeleOp extends LinearOpMode {

    private DcMotor leftRear = null;
    private DcMotor leftFront = null;
    private DcMotor rightRear = null;
    private DcMotor rightFront = null;
    private double leftPower;
    private double rightPower;

    @Override
    public void runOpMode() {

        leftRear = hardwareMap.get(DcMotor.class, "leftRear");
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightRear = hardwareMap.get(DcMotor.class, "rightRear");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");

        while(opModeIsActive()) {

            leftRear.setPower(leftPower);
            leftFront.setPower(leftPower);

            rightRear.setPower(rightPower);
            rightFront.setPower(rightPower);

            if(gamepad1.dpad_down) {

                rightPower = 1;
                leftPower = -1;

            } else if(gamepad1.dpad_up) {

                rightPower = -1;
                leftPower = 1;

            } else {

                rightPower = 0;
                leftPower = 0;

            }

        }

    }


}