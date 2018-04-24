package frc.team364.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team364.robot.autons.LeftSwitch2Cube;
import frc.team364.robot.subsystems.BuddySystem;
import frc.team364.robot.subsystems.DriveSystem;
import frc.team364.robot.subsystems.IntakeSystem;
import frc.team364.robot.subsystems.LiftSystem;

public class Robot extends IterativeRobot {

    public static DriveSystem driveSystem;
    public static LiftSystem liftSystem;
    public static BuddySystem buddySystem;
    public static IntakeSystem intakeSystem;
    public static String gameData = "";

    public static OI oi;

    public static Command leftAutonSwitch;
    public static Command rightAutonSwitch;

	@Override
    public void robotInit() {
	    driveSystem = new DriveSystem();
	    liftSystem = new LiftSystem();
	    buddySystem = new BuddySystem();
	    intakeSystem = new IntakeSystem();
	    oi = new OI();
	    leftAutonSwitch = new LeftSwitch2Cube();
	    rightAutonSwitch = new LeftSwitch2Cube();
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
