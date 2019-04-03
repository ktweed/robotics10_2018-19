package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="TeleOp1", group="Linear Opmode")

public class TeleOp1 extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor leftRear = null;
    private DcMotor leftFront = null;
    private DcMotor leftMiddle = null;
    private DcMotor rightRear = null;
    private DcMotor rightFront = null;
    private DcMotor rightMiddle = null;


    @Override
    public void runOpMode() {

        // Initialize Hardware
        leftRear = hardwareMap.get(DcMotor.class, "leftRear");
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftMiddle = hardwareMap.get(DcMotor.class, "leftMiddle");
        rightRear = hardwareMap.get(DcMotor.class, "rightRear");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightMiddle = hardwareMap.get(DcMotor.class, "rightMiddle");


        rightRear.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);

        //
        telemetry.addData("Status", "Initialized");
        telemetry.update();



        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {


            // Left Side Tank Control

            if (gamepad1.left_stick_y > 0.1) {

                // leftRear.setPower(1);
                // leftFront.setPower(1);

                leftRear.setPower(gamepad1.left_stick_y);
                leftFront.setPower(gamepad1.left_stick_y);

            }

            if (gamepad1.left_stick_y < -0.1) {

                // leftRear.setPower(-1);
                // leftFront.setPower(-1);

                leftRear.setPower(gamepad1.left_stick_y);
                leftFront.setPower(gamepad1.left_stick_y);

            }

            if (gamepad1.left_stick_y < 0.1) {

                if (gamepad1.left_stick_y > -0.1) {

                    leftRear.setPower(0);
                    leftFront.setPower(0);

                }

            }


            // Right Side Tank Control

            if (gamepad1.right_stick_y > 0.1) {

                // rightRear.setPower(1);
                // rightFront.setPower(1);

                rightRear.setPower(gamepad1.right_stick_y);
                rightFront.setPower(gamepad1.right_stick_y);

            }

            if (gamepad1.right_stick_y < -0.1) {

                // rightRear.setPower(-1);
                // rightFront.setPower(-1);

                rightRear.setPower(gamepad1.right_stick_y);
                rightFront.setPower(gamepad1.right_stick_y);

            }

            if (gamepad1.right_stick_y < 0.1) {

                if (gamepad1.right_stick_y > -0.1) {

                    rightRear.setPower(0);
                    rightFront.setPower(0);

                }

            }

            /* if (gamepad1.x) {

                rightFront.setPower(1);
                rightRear.setPower(1);
                leftFront.setPower(1);
                leftRear.setPower(1);
                sleep(1000);
                rightFront.setPower(0);
                rightRear.setPower(0);
                leftFront.setPower(0);
                leftRear.setPower(0);

            }

            if (gamepad1.y) {

                rightFront.setPower(1);
                rightRear.setPower(1);
                leftFront.setPower(1);
                leftRear.setPower(1);
                sleep(2000);
                rightFront.setPower(0);
                rightRear.setPower(0);
                leftFront.setPower(0);
                leftRear.setPower(0);

            }

            if (gamepad1.a) {

                rightFront.setPower(1);
                rightRear.setPower(1);
                leftFront.setPower(1);
                leftRear.setPower(1);
                sleep(3000);
                rightFront.setPower(0);
                rightRear.setPower(0);
                leftFront.setPower(0);
                leftRear.setPower(0);

            }

            if (gamepad1.b) {

                rightFront.setPower(1);
                rightRear.setPower(1);
                leftFront.setPower(1);
                leftRear.setPower(1);
                sleep(4000);
                rightFront.setPower(0);
                rightRear.setPower(0);
                leftFront.setPower(0);
                leftRear.setPower(0);

            }

            if (gamepad1.dpad_up) {

                rightFront.setPower(1);
                rightRear.setPower(1);
                leftFront.setPower(-1);
                leftRear.setPower(-1);
                sleep(1000);
                rightFront.setPower(0);
                rightRear.setPower(0);
                leftFront.setPower(0);
                leftRear.setPower(0);

            }

            if (gamepad1.dpad_down) {

                rightFront.setPower(-1);
                rightRear.setPower(-1);
                leftFront.setPower(1);
                leftRear.setPower(1);
                sleep(1000);
                rightFront.setPower(0);
                rightRear.setPower(0);
                leftFront.setPower(0);
                leftRear.setPower(0);

            } */

            if (gamepad1.dpad_left) {

                rightFront.setPower(1);
                rightRear.setPower(-1);
                leftFront.setPower(-1);
                leftRear.setPower(1);
                sleep(1000);
                rightFront.setPower(0);
                rightRear.setPower(0);
                leftFront.setPower(0);
                leftRear.setPower(0);

            }

            if (gamepad1.dpad_right) {

                rightFront.setPower(-1);
                rightRear.setPower(1);
                leftFront.setPower(1);
                leftRear.setPower(-1);
                sleep(1000);
                rightFront.setPower(0);
                rightRear.setPower(0);
                leftFront.setPower(0);
                leftRear.setPower(0);

            }
        }
    }
}
