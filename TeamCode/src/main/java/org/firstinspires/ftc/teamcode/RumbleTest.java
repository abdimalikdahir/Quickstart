package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp
public class RumbleTest extends LinearOpMode{
    TouchSensor touchSensor;
    @Override
    public void runOpMode() {
        touchSensor = hardwareMap.get(TouchSensor.class, "touchSensor");
        waitForStart();

        if(opModeIsActive())
        {

        }
        while(opModeIsActive())
        {
            if(!touchSensor.isPressed()) {
                gamepad1.rumble(100);
                telemetry.addData("IS PRESSED" , !touchSensor.isPressed());


            }
            telemetry.update();
        }

    }



}


