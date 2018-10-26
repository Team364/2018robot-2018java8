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
    public static Command auto;

	@Override
    public void robotInit() {
        setPeriod(0.02);
	    driveSystem = new DriveSystem();
        auto = new DriveForwardAuto();
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
    public void testInit() { 

    }

    @Override
    public void teleopPeriodic() {
	    Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() { 

    }
}
