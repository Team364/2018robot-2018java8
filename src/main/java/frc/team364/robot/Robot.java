package frc.team364.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team364.robot.autons.*;
import frc.team364.robot.subsystems.*;

public class Robot extends TimedRobot {

    public static DriveSystem driveSystem;
    public static LiftSystem liftSystem;
    public static BuddySystem buddySystem;
    public static IntakeSystem intakeSystem;
    public static ClawSystem clawSystem;
    public String gameData = "";

    public static OI oi;

    public static Command leftAutonSwitch;
    public static Command rightAutonSwitch;
    public static Command farAutonScale;
    public static Command closeAutonScale;

    public UsbCamera camera;

    /**
     * robotInit()
     * Note the setPeriod(0.05) function. This is a function with the
     * TimedRobot class that sets the robot loop period (50ms in this case).
     * This will allow the motion profiling code to run at a constant rate without
     * fluctuation. 
     */
	@Override
    public void robotInit() {
        setPeriod(0.02);
	    driveSystem = new DriveSystem();
	    liftSystem = new LiftSystem();
	    buddySystem = new BuddySystem();
        intakeSystem = new IntakeSystem();
        clawSystem = new ClawSystem();
	    oi = new OI();
	    leftAutonSwitch = new LeftSwitch2Cube();
        rightAutonSwitch = new FarScale1Cube();
        farAutonScale = new FarScale1Cube();
        closeAutonScale = new CloseScale3Cube();
        camera = CameraServer.getInstance().startAutomaticCapture("Video", 0);
        camera.setResolution(640, 480);
        driveSystem.resetEncoders();
        driveSystem.resetHeading();
    }

    @Override
    public void disabledInit() { }

    @Override
    public void autonomousInit() {
        Scheduler.getInstance().removeAll();
	    gameData = DriverStation.getInstance().getGameSpecificMessage();
	    if(gameData.charAt(0) == 'L') {
            if(oi.autoSelectorButton.get()) {
                if(farAutonScale != null) {
                    System.out.println("Far scale");
                    farAutonScale.start();
                }
            } else {
	            if(leftAutonSwitch != null) {
                   leftAutonSwitch.start();
               }
            }
        } else {
            if(oi.autoSelectorButton.get()) {
                if(closeAutonScale != null) {
                    System.out.println("Close scale");
                    closeAutonScale.start();
                }
            } else {
	            if(rightAutonSwitch != null) {
	                rightAutonSwitch.start();
               }
            }
        }
        driveSystem.resetHeading();
        driveSystem.resetEncoders();
    }

    @Override
    public void autonomousPeriodic() {
        putSmartDashVars();
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        Scheduler.getInstance().removeAll();
        driveSystem.leftRear.configOpenloopRamp(0, 0);
        driveSystem.rightRear.configOpenloopRamp(0, 0); 
    }

    @Override
    public void testInit() { 

    }

    @Override
    public void disabledPeriodic() {
        putSmartDashVars();
    }

    @Override
    public void teleopPeriodic() {
	    Scheduler.getInstance().run();
        putSmartDashVars();
    }

    @Override
    public void testPeriodic() { 

    }

    private void putSmartDashVars() {
        SmartDashboard.putNumber("Gyro Angle", driveSystem.getGyroAngle());
        SmartDashboard.putNumber("Left Encoder Counts", driveSystem.getLeftEncoderPosition());
        SmartDashboard.putNumber("Right Encoder Counts", driveSystem.getRightEncoderPosition());
        //SmartDashboard.putString("Current auto", gameData.charAt(0));
    }
}
