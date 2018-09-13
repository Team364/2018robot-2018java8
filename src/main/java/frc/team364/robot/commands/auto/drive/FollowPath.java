package frc.team364.robot.commands.auto.drive;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;

import java.io.File;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team364.robot.Robot;

public class FollowPath extends Command {

    private EncoderFollower left;
    private EncoderFollower right;

    private double leftCalculatedOutput;
    private double rightCalculatedOutput;
    public double leftOututCalculated;
    private double heading;
    private double desiredHeading;
    private double angleDifference;
    private double turn;
    
    private File leftFile;
    private File rightFile;
    private Trajectory leftTraj;
    private Trajectory rightTraj;    

    public FollowPath(String leftFileName, String rightFileName) {
        leftFile = new File(leftFileName);
        rightFile = new File(rightFileName);
        requires(Robot.driveSystem);
    }

    /**
     * @return the leftCalculatedOutput
     */
    public double getLeftCalculatedOutput() {
        return leftCalculatedOutput;
    }

    @Override
    protected void initialize() {
        leftTraj = Pathfinder.readFromCSV(leftFile);
        rightTraj = Pathfinder.readFromCSV(rightFile);
        left = new EncoderFollower(leftTraj);
        right = new EncoderFollower(rightTraj);
        left.configureEncoder(0, 4096, 0.1524);
        right.configureEncoder(0, 4096, 0.1524);
        left.configurePIDVA(0.25, 0, 0, 1/10, 0);
        right.configurePIDVA(0.25, 0, 0, 1/10, 0);
        Robot.driveSystem.resetEncoders();
        Robot.driveSystem.resetHeading();
    }

    @Override
    protected void execute() {
        leftCalculatedOutput = left.calculate(Robot.driveSystem.getLeftEncoderPosition());
        rightCalculatedOutput = right.calculate(Robot.driveSystem.getRightEncoderPosition());
        
        heading = Robot.driveSystem.getGyroAngle();
        desiredHeading = Pathfinder.r2d(left.getHeading());

        angleDifference = Pathfinder.boundHalfDegrees(desiredHeading - heading);
        turn = 0; //0.51* (-1.0/80.0) * angleDifference

        Robot.driveSystem.setLeftDrivePower(leftCalculatedOutput + turn);
        Robot.driveSystem.setRightDrivePower((rightCalculatedOutput - turn)*-1);

        SmartDashboard.putNumber("Trag leftCalculatedOutput: ", leftCalculatedOutput);
        SmartDashboard.putNumber("Trag rightCalculatedOutput: ", rightCalculatedOutput);
        SmartDashboard.putNumber("Trag heading: ", heading);
        SmartDashboard.putNumber("Trag desiredHeading: ", desiredHeading);
        SmartDashboard.putNumber("Trag angleDifference: ", angleDifference);
        SmartDashboard.putNumber("Trag turn: ", turn);
        SmartDashboard.putNumber("Trag leftEncoderCounts: ", Robot.driveSystem.getLeftEncoderPosition());
        SmartDashboard.putNumber("Trag rightEncoderCounts: ", Robot.driveSystem.getRightEncoderPosition());


    }

	@Override
	protected boolean isFinished() {
		return left.isFinished() && right.isFinished();
    }
    
    @Override
    protected void end() {

    }

}