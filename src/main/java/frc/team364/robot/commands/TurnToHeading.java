package frc.team364.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;


public class TurnToHeading extends Command {

    private double wantedHeading;

    public TurnToHeading(double heading) {
        requires(Robot.driveSystem);
        wantedHeading = heading;
    }

    @Override
    protected void initialize() {
        Robot.driveSystem.stop();
        Robot.driveSystem.resetHeading();
        Robot.driveSystem.pidNavX.resetPID();
        Robot.driveSystem.pidLeft.resetPID();
        Robot.driveSystem.pidRight.resetPID();
        Robot.driveSystem.pidNavX.setPIDParameters(0.005, 0.01, 50, 0);
    }

    @Override
    protected void execute() {
        Robot.driveSystem.turnToHeading(wantedHeading);
    }

    @Override
    protected boolean isFinished() {
        return Robot.driveSystem.reachedHeading(wantedHeading);
    }

    @Override
    protected void end() {
        Robot.driveSystem.stop();
        Robot.driveSystem.resetHeading();
        System.out.println("Reached target heading." + Robot.driveSystem.getGyroAngle());
    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}
