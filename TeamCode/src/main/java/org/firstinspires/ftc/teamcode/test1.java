package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name="Template: Linear OpMode", group="Linear Opmode")
@Disabled

public class test1 extends OpMode {


    @Override
    public void init() {

        // This runs on initialization
        telemetry.log().setCapacity(6);

        telemetry.addData("Testing Init", "Test Message 1");

    }

    @Override
    public void start() {

        // This runs once on start
        telemetry.addData("Testing Start", "Test Message 2");

    }

    @Override
    public void loop() {

        // This loops on start, after void start
        telemetry.addData("Testing Loop", "Test Message 3");

        // Sleep one second
        try
            {
                Thread.sleep(1000);
            }

        catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }

    }

    @Override
    public void stop() {
        // This runs once on stop
        telemetry.addData("Testing Stop", "Test Message 4");

    }}
