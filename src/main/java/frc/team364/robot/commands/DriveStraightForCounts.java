package frc.team364.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;

public class DriveStraightForCounts extends Command {

    private int driveCounts;
    private boolean driveBackwards;

    public DriveStraightForCounts(int counts, boolean backwards) {
        requires(Robot.driveSystem);
        driveCounts = counts;
        driveBackwards = backwards;
        setTimeout(5);
    }

    @Override
    protected void initialize() {
        Robot.driveSystem.resetEncoders();
        Robot.driveSystem.resetHeading();
        Robot.driveSystem.stop();
        Robot.driveSystem.pidLeft.resetPID();
        Robot.driveSystem.pidRight.resetPID();
        Robot.driveSystem.pidNavX.resetPID();
        Robot.driveSystem.leftRear.configOpenloopRamp(0.6, 1);
        Robot.driveSystem.rightRear.configOpenloopRamp(0.6, 1);
    }

    @Override
    protected void execute() {
        Robot.driveSystem.driveStraightToEncoderCounts(driveCounts, driveBackwards);
    }

    @Override
    protected boolean isFinished() {
        return Robot.driveSystem.withinEncoderCountRange(driveCounts) || isTimedOut();
    }

    @Override
    protected void end() {
        Robot.driveSystem.resetEncoders();
        Robot.driveSystem.resetHeading();
        Robot.driveSystem.stop();
        Robot.driveSystem.leftRear.configOpenloopRamp(0, 0);
        Robot.driveSystem.rightRear.configOpenloopRamp(0, 0);
        System.out.println("Reached target distance.\nWanted: " + driveCounts + "Actual: " + Robot.driveSystem.getLeftEncoderPosition());
    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}
