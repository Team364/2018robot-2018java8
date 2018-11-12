package frc.team364.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team364.robot.autons.*;
import frc.team364.robot.subsystems.*;

public class Robot extends TimedRobot {

    public static DriveSystem driveSystem;
    public static Command auto;

	@Override
    public void robotInit() {
        setPeriod(0.02);
	    driveSystem = new DriveSystem();
<<<<<<< HEAD
	    liftSystem = new LiftSystem();
        intakeSystem = new IntakeSystem();
        clawSystem = new ClawSystem();
	    oi = new OI();
	    leftAutonSwitch = new LeftSwitchRedStick();
        rightAutonSwitch = new RightSwitchRedStick();
        farAutonScale = new FollowPathAuto();
        closeAutonScale = new CloseScale3Cube();
        //flippyShit = new FlippyShit();
        camera = CameraServer.getInstance().startAutomaticCapture("Video", 0);
        camera.setResolution(320, 240);
        driveSystem.resetEncoders();
        driveSystem.resetHeading();
=======
        auto = new DriveForwardAuto();
>>>>>>> c6f78589a35c0b920c2ed32eaf2ab52f328cff1a
    }

    @Override
    public void autonomousInit() {
        Scheduler.getInstance().removeAll();
        auto.start();
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        Scheduler.getInstance().removeAll();
        driveSystem.leftRear.configOpenloopRamp(0, 0);
        driveSystem.rightRear.configOpenloopRamp(0, 0); 
    }

    @Override
    public void teleopPeriodic() {
	    Scheduler.getInstance().run();
    }

<<<<<<< HEAD
    private void putSmartDashVars() {
        SmartDashboard.putNumber("Gyro Angle", driveSystem.getGyroAngle());
        SmartDashboard.putNumber("Left Encoder Counts", driveSystem.getLeftEncoderPosition());
        SmartDashboard.putNumber("Right Encoder Counts", driveSystem.getRightEncoderPosition());
    }
=======
>>>>>>> c6f78589a35c0b920c2ed32eaf2ab52f328cff1a
}
