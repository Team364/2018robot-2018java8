package frc.team364.robot.commands;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;
import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;

public class FollowPath extends Command {

    Waypoint[] points = new Waypoint[] {
        new Waypoint(10, 0, 0),
        new Waypoint(12, -5, Pathfinder.d2r(-90)),
        new Waypoint(12, -10, Pathfinder.d2r(-90)),
        new Waypoint(15, -13, 0)
    };

    private TankModifier trajectory;
    private EncoderFollower left;
    private EncoderFollower right;

    private double leftCalculatedOutput;
    private double rightCalculatedOutput;
    private double heading;
    private double desiredHeading;
    private double angleDifference;
    private double turn;

    public FollowPath() {
        requires(Robot.driveSystem);
    }

    @Override
    protected void initialize() {
        trajectory = Robot.driveSystem.configTrajectory(points);
        left = new EncoderFollower(trajectory.getLeftTrajectory());
        right = new EncoderFollower(trajectory.getRightTrajectory());
        left.configureEncoder(0, 4096, 0.1524);
        right.configureEncoder(0, 4096, 0.1524);
        left.configurePIDVA(0.25, 0, 0, 1/6, 0);
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