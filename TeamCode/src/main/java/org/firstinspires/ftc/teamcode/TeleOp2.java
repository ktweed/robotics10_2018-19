package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="TeleOp2", group="Linear Opmode")

public class TeleOp2 extends LinearOpMode {

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

        left_rear.setDirection(DcMotorSimple.Direction.REVERSE);
        left_front.setDirection(DcMotorSimple.Direction.REVERSE);

        //
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        telemetry.log().setCapacity(4);


        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Encoder Readouts
            int lfpos = left_front.getCurrentPosition();
            int lrpos = left_rear.getCurrentPosition();
            int rfpos = right_front.getCurrentPosition();
            int rrpos = right_rear.getCurrentPosition();

            // Left Side Tank Control

            if (gamepad1.left_stick_y > 0.1) {

                left_rear.setPower(1);
                left_front.setPower(1);

            }

            if (gamepad1.left_stick_y < -0.1) {

                left_rear.setPower(-1);
                left_front.setPower(-1);

            }

            if (gamepad1.left_stick_y < 0.1) {

                if (gamepad1.left_stick_y > -0.1) {

                    left_rear.setPower(0);
                    left_front.setPower(0);

                }

            }


            // Right Side Tank Control

            if (gamepad1.right_stick_y > 0.1) {

                right_rear.setPower(1);
                right_front.setPower(1);

            }

            if (gamepad1.right_stick_y < -0.1) {

                right_rear.setPower(-1);
                right_front.setPower(-1);

            }

            if (gamepad1.right_stick_y < 0.1) {

                if (gamepad1.right_stick_y > -0.1) {

                    right_rear.setPower(0);
                    right_front.setPower(0);

                }

            }


            // Movement / Distance Tests

            if (gamepad1.x) {

                right_front.setPower(1);
                right_rear.setPower(1);
                left_front.setPower(1);
                left_rear.setPower(1);
                sleep(1000);
                right_front.setPower(0);
                right_rear.setPower(0);
                left_front.setPower(0);
                left_rear.setPower(0);

            }

            if (gamepad1.y) {

                right_front.setPower(1);
                right_rear.setPower(1);
                left_front.setPower(1);
                left_rear.setPower(1);
                sleep(2000);
                right_front.setPower(0);
                right_rear.setPower(0);
                left_front.setPower(0);
                left_rear.setPower(0);

            }

            if (gamepad1.a) {

                right_front.setPower(1);
                right_rear.setPower(1);
                left_front.setPower(1);
                left_rear.setPower(1);
                sleep(3000);
                right_front.setPower(0);
                right_rear.setPower(0);
                left_front.setPower(0);
                left_rear.setPower(0);

            }

            if (gamepad1.b) {

                right_front.setPower(1);
                right_rear.setPower(1);
                left_front.setPower(1);
                left_rear.setPower(1);
                sleep(4000);
                right_front.setPower(0);
                right_rear.setPower(0);
                left_front.setPower(0);
                left_rear.setPower(0);

            }

            if (gamepad1.dpad_up) {

                // Get to within 10 of encoder position 1000 on all motors

                // Left Front Motor
                if (lfpos < 995) {
                    left_front.setPower(0.3);

                } else if (lfpos > 1005) {

                    left_front.setPower(-0.3);

                } else left_front.setPower(0);

                // Right Front Motor
                if (rfpos < 995) {
                    right_front.setPower(0.3);

                } else if (rfpos > 1005) {

                    right_front.setPower(-0.3);

                } else right_front.setPower(0);



            }

            if (gamepad1.dpad_down) {

                right_front.setPower(-1);
                right_rear.setPower(-1);
                left_front.setPower(1);
                left_rear.setPower(1);
                sleep(1000);
                right_front.setPower(0);
                right_rear.setPower(0);
                left_front.setPower(0);
                left_rear.setPower(0);

            }

            if (gamepad1.dpad_left) {

                right_front.setPower(1);
                right_rear.setPower(-1);
                left_front.setPower(-1);
                left_rear.setPower(1);
                sleep(1000);
                right_front.setPower(0);
                right_rear.setPower(0);
                left_front.setPower(0);
                left_rear.setPower(0);

            }

            if (gamepad1.dpad_right) {

                right_front.setPower(-1);
                right_rear.setPower(1);
                left_front.setPower(1);
                left_rear.setPower(-1);
                sleep(1000);
                right_front.setPower(0);
                right_rear.setPower(0);
                left_front.setPower(0);
                left_rear.setPower(0);

            }

            // Telemetry
            telemetry.addData("Left Front", lfpos);
            telemetry.addData("Left Rear", lrpos);
            telemetry.addData("Right Front", rfpos);
            telemetry.addData("Right Rear", rrpos);
            telemetry.update();

        }
    }
}
