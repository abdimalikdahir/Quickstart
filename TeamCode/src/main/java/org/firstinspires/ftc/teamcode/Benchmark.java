package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;
@TeleOp
public class Benchmark extends LinearOpMode {


    private DcMotor backLeft, backRight, frontLeft, frontRight, flyWheel;
    private TouchSensor touchSensor;

    @Override
    public void runOpMode() {
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        flyWheel = hardwareMap.get(DcMotor.class, "flyWheel");

        touchSensor = hardwareMap.get(TouchSensor.class, touchSensor);

        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        backLeft.setTargetPosition(1000);
        backRight.setTargetPosition(1000);
        frontLeft.setTargetPosition(1000);
        frontRight.setTargetPosition(1000);

        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backLeft.setPower(0.3);
        backRight.setPower(0.3);
        frontLeft.setPower(0.3);
        frontRight.setPower(0.3);

        if (touchSensor.isPressed()) {
            telemetry.addData("Touch Sensor is Working", touchSensor.isPressed());
        }

        if (backLeft.isBusy()) {
            telemetry.addData("Motor BACK LEFT is Working", backLeft.isBusy());
        }

        if (backRight.isBusy()) {
            telemetry.addData("Motor BACK RIGHT is Working", backRight.isBusy());
        }

        if (frontLeft.isBusy()) {
            telemetry.addData("Motor FRONT LEFT is Working", frontLeft.isBusy());
        }

        if (frontRight.isBusy()) {
            telemetry.addData("Motor FRONT RIGHT is Working", frontRight.isBusy());
        }
        telemetry.update();
    }
}