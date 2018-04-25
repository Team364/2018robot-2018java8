package frc.team364.robot.commands;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

import java.io.File;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;

public class FollowPath extends Command {

    private TankModifier trajectory;
    private EncoderFollower left;
    private EncoderFollower right;

    private double leftCalculatedOutput;
    private double rightCalculatedOutput;
    private double heading;
    private double desiredHeading;
    private double angleDifference;
    private double turn;
    private File leftFile = new File("/home/lvuser/mp_left.csv");
    private File rightFile = new File("/home/lvuser/mp_right.csv");
    private Trajectory leftTraj;
    private Trajectory rightTraj;    

    public FollowPath() {
        requires(Robot.driveSystem);
    }

    @Override
    protected void initialize() {
        leftTraj = Pathfinder.readFromCSV(leftFile);
        rightTraj = Pathfinder.readFromCSV(rightFile);
        left = new EncoderFollower(leftTraj);
        right = new EncoderFollower(rightTraj);
        left.configureEncoder(0, 4096, 0.1524);
        right.configureEncoder(0, 4096, 0.1524);
        left.configurePIDVA(0.25, 0, 0, 1/6, 0);
        right.configurePIDVA(0.25, 0, 0, 1/5, 0);
    }

    @Override
    protected void execute() {
        leftCalculatedOutput = left.calculate(Robot.driveSystem.getLeftEncoderPosition());
        rightCalculatedOutput = right.calculate(Robot.driveSystem.getRightEncoderPosition());
        
        heading = Robot.driveSystem.getGyroAngle();
        desiredHeading = Pathfinder.r2d(left.getHeading());

        angleDifference = Pathfinder.boundHalfDegrees(desiredHeading - heading);
        turn = 0.8 * (-1.0/80.0) * angleDifference;

        Robot.driveSystem.setLeftDrivePower(leftCalculatedOutput + turn);
        Robot.driveSystem.setRightDrivePower(rightCalculatedOutput - turn);
    }

	@Override
	protected boolean isFinished() {
		return false;
    }
    
    @Override
    protected void end() {

    }

}