package frc.team364.robot.commands.auto.misc;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;

public class DriveStraightForCountsIntakeQuick extends Command {

    private int driveCounts;
    private boolean driveBackwards;
    private boolean driveWithGyro;

    public DriveStraightForCountsIntakeQuick(int counts, boolean backwards, boolean useGyro) {
        requires(Robot.driveSystem);
        driveCounts = counts;
        driveBackwards = backwards;
        driveWithGyro = useGyro;
        System.out.println("Backwards: " + backwards);
        setTimeout(0.7);
        Robot.driveSystem.resetEncoders();
        Robot.driveSystem.resetHeading();
        Robot.driveSystem.stop();
        Robot.driveSystem.pidLeft.resetPID();
        Robot.driveSystem.pidRight.resetPID();
        Robot.driveSystem.pidNavX.resetPID();
        Robot.driveSystem.pidNavX.setPIDParameters(0.1, 0.1, 0, 0);
        requires(Robot.intakeSystem);
    }

    @Override
    protected void initialize() {
        Robot.intakeSystem.intakeStop();
        Robot.driveSystem.resetEncoders();
        Robot.driveSystem.resetHeading();
        Robot.driveSystem.stop();
        Robot.driveSystem.pidLeft.resetPID();
        Robot.driveSystem.pidRight.resetPID();
        Robot.driveSystem.pidNavX.resetPID();
        Robot.driveSystem.pidNavX.setPIDParameters(0.1, 0.1, 0, 0);
    }

    @Override
    protected void execute() {
        Robot.driveSystem.driveStraightToEncoderCounts(driveCounts, driveBackwards, driveWithGyro);
        Robot.intakeSystem.intakeWhileMoving(driveBackwards);
    }

    @Override
    protected boolean isFinished() {
        return Robot.driveSystem.withinEncoderCountRange(driveCounts) || isTimedOut();
    }

    @Override
    protected void end() {
        Robot.intakeSystem.intakeStop();
        Robot.driveSystem.resetEncoders();
        Robot.driveSystem.resetHeading();
        Robot.driveSystem.stop();
        System.out.println("Reached target distance.\nWanted: " + driveCounts + "Actual: " + Robot.driveSystem.getLeftEncoderPosition());
    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}
