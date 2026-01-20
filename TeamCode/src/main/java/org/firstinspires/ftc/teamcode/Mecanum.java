package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "abdi tele-op android", group = "TeleOp")
public class Mecanum extends LinearOpMode {

    private DcMotor frontLeft, frontRight, backLeft, backRight;

    @Override
    public void runOpMode() {

        frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft   = hardwareMap.get(DcMotor.class, "backLeft");
        backRight  = hardwareMap.get(DcMotor.class, "backRight");

        // Reverse left side motors
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {

            // ---------------------------
            // 1. Joystick Input
            // ---------------------------

            double y  = -gamepad1.left_stick_y;     // Forward/back
            double x  = gamepad1.left_stick_x;      // Strafe
            double rx = gamepad1.right_stick_x;     // Rotate

            // Deadzone filtering
            y  = Math.abs(y)  < 0.05 ? 0 : y;
            x  = Math.abs(x)  < 0.05 ? 0 : x;
            rx = Math.abs(rx) < 0.05 ? 0 : rx;

            // Exponential scaling → smooth control
            y  = Math.pow(y, 3);
            x  = Math.pow(x, 3);
            rx = Math.pow(rx, 3);

            // Slow Mode (precision)
            double speedMult = gamepad1.right_bumper ? 0.35 : 1.0;

            // ---------------------------
            // 2. Mecanum math
            // ---------------------------

            double fl = y + x + rx;
            double bl = y - x + rx;
            double fr = y - x - rx;
            double br = y + x - rx;

            double max = Math.max(1.0,
                    Math.max(Math.abs(fl),
                            Math.max(Math.abs(bl),
                                    Math.max(Math.abs(fr), Math.abs(br)))) );

            fl /= max;
            fr /= max;
            bl /= max;
            br /= max;

            // Apply speed multiplier
            fl *= speedMult;
            fr *= speedMult;
            bl *= speedMult;
            br *= speedMult;

            // ---------------------------
            // 3. Output to motors
            // ---------------------------

            frontLeft.setPower(fl);
            frontRight.setPower(fr);
            backLeft.setPower(bl);
            backRight.setPower(br);

            // ---------------------------
            // 4. Telemetry
            // ---------------------------

            telemetry.addLine("Powers:");
            telemetry.addData("FL", "%.2f", fl);
            telemetry.addData("FR", "%.2f", fr);
            telemetry.addData("BL", "%.2f", bl);
            telemetry.addData("BR", "%.2f", br);

            telemetry.addLine("\nJoystick:");
            telemetry.addData("Y", "%.2f", y);
            telemetry.addData("X", "%.2f", x);
            telemetry.addData("RX", "%.2f", rx);

            telemetry.addData("Mode", speedMult < 1 ? "SLOW" : "NORMAL");
            telemetry.update();
        }
    }
}


