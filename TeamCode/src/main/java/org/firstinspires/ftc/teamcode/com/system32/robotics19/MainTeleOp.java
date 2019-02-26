package org.firstinspires.ftc.teamcode.com.system32.robotics19;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="MainTeleOp", group="Linear Opmode")

public class MainTeleOp extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    // Motor Variable Initialization
    private DcMotor left_rear = null;
    private DcMotor left_front = null;
    private DcMotor right_rear = null;
    private DcMotor right_front = null;

    @Override
    public void runOpMode() {

        // Initialize Hardware
        left_rear = hardwareMap.get(DcMotor.class, "left_rear");
        left_front = hardwareMap.get(DcMotor.class, "left_front");
        right_rear = hardwareMap.get(DcMotor.class, "right_rear");
        right_front = hardwareMap.get(DcMotor.class, "right_front");

        right_rear.setDirection(DcMotorSimple.Direction.REVERSE);
        right_front.setDirection(DcMotorSimple.Direction.REVERSE);

        double leftPower;
        double rightPower;

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        telemetry.log().setCapacity(4);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Left Side Tank Control

            leftPower = 0;

            if (gamepad1.left_stick_y > 0.05 || gamepad1.left_stick_y < -0.05) {

                leftPower = gamepad1.left_stick_y;

            }

            left_rear.setPower(leftPower);
            left_front.setPower(leftPower);

            // Right Side Tank Control

            rightPower = 0;

            if (gamepad1.right_stick_y > 0.05 || gamepad1.right_stick_y < -0.05) {

                rightPower = gamepad1.right_stick_y;

            }

            right_rear.setPower(rightPower);
            right_front.setPower(rightPower);

        }
    }
}
