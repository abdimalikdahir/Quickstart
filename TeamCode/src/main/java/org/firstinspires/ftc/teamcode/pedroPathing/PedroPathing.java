package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.StateMachine;

import java.util.Timer;

@TeleOp
public class PedroPathing extends OpMode {
    private Follower follower;

    private Timer pathTimer, opModeTimer;

public enum PathState {
        // START POSITION_END POSITION
        // DRIVE > MOVEMENT STATE
        // SHOOT > ATTEMPT TO SCORE

        DRIVE_STARTPOS_SHOOT_POS,

        SHOOT_PRELOAD
}
    PathState pathState;

    private final Pose startPose = new Pose(124.1,122.3,Math.toRadians(37));
    private final Pose shootpose = new Pose(93,92.5, Math.toRadians(45));

    private PathChain driveStartStartPosShootPos;

    public void buildpaths() {
        // put in coordinates for starting pose > ending pos
        driveStartStartPosShootPos = follower.pathBuilder()
                .addPath(new BezierLine(startPose,shootpose))
                .setLinearHeadingInterpolation(startPose.getHeading(), shootpose.getHeading())
                .build();

    }

    public void statepathupdate() {
        switch (pathState) {
            case DRIVE_STARTPOS_SHOOT_POS:
                follower.followPath(driveStartStartPosShootPos, true);
                pathState = pathState.SHOOT_PRELOAD;
                break;
            case SHOOT_PRELOAD:
                // check is follower done it's path?
                if (follower.isBusy()) {
                    // TODO add logic to flywheel shooter
                    telemetry.addLine("Done Path 1");
                    // transition to next state
                }
                break;
            default:
                telemetry.addLine("No State Commanded");
                break;
        }
    }




    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }

}
