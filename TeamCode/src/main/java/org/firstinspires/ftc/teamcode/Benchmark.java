package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;

@TeleOp
public class Benchmark extends LinearOpMode {

    private DcMotor backLeft, backRight, frontLeft, frontRight;

    @Override
    public void runOpMode() {

        waitForStart();

        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);



        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);


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

        backLeft.setPower(0.6);
        backRight.setPower(0.6);
        frontLeft.setPower(0.6);
        frontRight.setPower(0.6);

        while (opModeIsActive()) {
            telemetry.addLine("Benchmark complete!");
            telemetry.addData("Motor BACK LEFT", backLeft.isBusy());
            telemetry.addData("Motor BACK RIGHT", backRight.isBusy());
            telemetry.addData("Motor FRONT LEFT", frontLeft.isBusy());
            telemetry.addData("Motor FRONT RIGHT", frontRight.isBusy());
            telemetry.update();
            idle();
        }

    }
}
