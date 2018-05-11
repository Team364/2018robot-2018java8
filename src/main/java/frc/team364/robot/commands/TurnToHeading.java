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
    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}
