package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.TouchSensor;

@TeleOp(name = "RumbleTest")
public class RumbleTest extends LinearOpMode {

    private TouchSensor touchSensor;

    @Override
    public void runOpMode() {

        touchSensor = hardwareMap.get(TouchSensor.class, "touchSensor");

        waitForStart();

        while (opModeIsActive()) {

            if (touchSensor.isPressed()) {
                gamepad1.rumble(100); // 100 ms rumble
                telemetry.addData("Touch Sensor", "PRESSED");
            } else {
                telemetry.addData("Touch Sensor", "NOT PRESSED");
            }

            telemetry.update();
        }
    }
}
