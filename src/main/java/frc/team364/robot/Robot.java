package frc.team364.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team364.robot.autons.LeftSwitch2Cube;
import frc.team364.robot.subsystems.BuddySystem;
import frc.team364.robot.subsystems.DriveSystem;
import frc.team364.robot.subsystems.IntakeSystem;
import frc.team364.robot.subsystems.LiftSystem;

public class Robot extends TimedRobot {

    public static DriveSystem driveSystem;
    public static LiftSystem liftSystem;
    public static BuddySystem buddySystem;
    public static IntakeSystem intakeSystem;
    public String gameData = "";

    public static OI oi;

    public static Command leftAutonSwitch;
    public static Command rightAutonSwitch;

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
        setPeriod(0.05);
	driveSystem = new DriveSystem();
	liftSystem = new LiftSystem();
	buddySystem = new BuddySystem();
	intakeSystem = new IntakeSystem();
	oi = new OI();
	leftAutonSwitch = new LeftSwitch2Cube();
        rightAutonSwitch = new LeftSwitch2Cube();
        camera = CameraServer.getInstance().startAutomaticCapture();
        camera.setResolution(640, 480);
        camera.setExposureManual(100);
        camera.setBrightness(100);
        camera.setFPS(30);
    }

    @Override
    public void disabledInit() { }

    @Override
    public void autonomousInit() {
	    gameData = DriverStation.getInstance().getGameSpecificMessage();
	    if(gameData.charAt(0) == 'L') {
	        if(leftAutonSwitch != null) {
                leftAutonSwitch.start();
            }
        } else {
	        if(rightAutonSwitch != null) {
	            rightAutonSwitch.start();
            }
        }
    }

    @Override
    public void autonomousPeriodic() {
	    Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() { }

    @Override
    public void testInit() { }

    @Override
    public void disabledPeriodic() { }

    @Override
    public void teleopPeriodic() {
	    Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() { }
}
