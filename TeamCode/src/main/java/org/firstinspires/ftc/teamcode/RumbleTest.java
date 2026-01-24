package org.firstinspires.ftc.teamcode;

<<<<<<< HEAD
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
=======
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
>>>>>>> c10ab50917c49f7d913d086fa5258888dd287ab7
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp
<<<<<<< HEAD
public class RumbleTest {

    @Override
    public void init() {


    }

    @Override
    public void loop() {
        if() {
            gamepad1.rumble(100);


        }
=======
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

>>>>>>> c10ab50917c49f7d913d086fa5258888dd287ab7
            }



        }
<<<<<<< HEAD
                =======


                >>>>>>> c10ab50917c49f7d913d086fa5258888dd287ab7
