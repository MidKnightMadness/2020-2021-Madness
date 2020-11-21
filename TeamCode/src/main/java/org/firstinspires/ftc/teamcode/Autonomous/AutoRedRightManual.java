package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Chassis.Drive;
import org.firstinspires.ftc.teamcode.Chassis.SampleDrive;
import org.firstinspires.ftc.teamcode.Intake.Intake;
import org.firstinspires.ftc.teamcode.Intake.SampleIntake;
import org.firstinspires.ftc.teamcode.Outtake.Outtake;
import org.firstinspires.ftc.teamcode.Outtake.SampleOuttake;
import org.firstinspires.ftc.teamcode.Visual.SampleVisual;
import org.firstinspires.ftc.teamcode.Visual.Visual;
import org.firstinspires.ftc.teamcode.WobbleGoal.SampleWobbleGoal;
import org.firstinspires.ftc.teamcode.WobbleGoal.WobbleGoal;

import java.util.concurrent.Callable;

@Autonomous
public class AutoRedRightManual extends LinearOpMode {
    private Drive drive = new SampleDrive();
    private Intake intake = new SampleIntake();
    private Outtake outtake = new SampleOuttake();
    private WobbleGoal wobbleGoal = new SampleWobbleGoal();
    private SampleVisual visual = new SampleVisual();

    @Override
    public void runOpMode() {
        //create stop requested callable
        Callable<Boolean> stopRequestedCall = new Callable<Boolean>() {@Override public Boolean call() {return isStopRequested();}};

        drive.init(hardwareMap, telemetry);
        drive.isStopRequested = stopRequestedCall;
        telemetry.addLine("Drive initialized!");
        telemetry.update();
        //intake.init(hardwareMap, telemetry);
        //outtake.init(hardwareMap, telemetry);
        //wobbleGoal.init(hardwareMap, telemetry);
        //visual.init(hardwareMap, telemetry);
        //telemetry.addLine("Visual initialized!");
        telemetry.update();

        while (!isStarted() && !isStopRequested() && opModeIsActive()) {
            idle();
        }

        if(isStopRequested())
        {
            return;
        }

        //wobbleGoal.close();
        //Do we lift it????

        //move up to starting stack
        drive.move(-13, 12);
        sleep(10);
        //get starting stack
        //visual.update();
       // telemetry.addLine("Zone: " + visual.getStartStack());
        //telemetry.update();
        drive.move(13, 0);

        drive.move(-5, 58);
        drive.move(-38.25, 0);
        drive.move(0,-5);

        //move to correct drop zone
        /*
        if (visual.getStartStack() == Visual.STARTERSTACK .A) {
            drive.move(-5, 58);
        } else if (visual.getStartStack() == Visual.STARTERSTACK.B) {
            drive.move(-15, 78);
        } else {
            drive.move(-5, 100);
        }

        //release wobble goal
        //wobbleGoal.open();

        //move to shooting positions
        if (visual.getStartStack() == Visual.STARTERSTACK.A) {
            drive.move(-40.25, -20);
        } else if (visual.getStartStack() == Visual.STARTERSTACK.B) {
            drive.move(-30.25, -40);
        } else {
            drive.move(-40.25, -63);
        }
         */

        //shoot power shots
        //outtake.start();
        //outtake.feed();
        drive.move(-7.5, 0);
        //outtake.feed();
        drive.move(-7.5, 0);
        //outtake.feed();
        //outtake.stop();


        telemetry.addLine("Program End :)");

        //visual.stop();
    }
}