package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
public class VariablePractice extends OpMode {
    @Override
    public void init() {

        String TeamName = "Lions Spark";
        int teamNumber = 30392;
        double motorSpeed = 0.75;
        boolean clawClosed = true;
        int motorAngle = 90;
        telemetry.addData("Team Name", TeamName);
        telemetry.addData("Team Number", teamNumber);
        telemetry.addData("Motor Speed", motorSpeed);
        telemetry.addData("Motor Angle", motorAngle);
        telemetry.addData("Claw State", clawClosed);


    }


    @Override
    public void loop() {

        /*
        !. change the String variable "name" to your team name.
        2. create an int called "motorAngle" and store an angle between 0-180. display this in your init method



        */
    }
}
