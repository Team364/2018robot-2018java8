package frc.team364.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;


public class TurnToHeading extends Command {

    private double wantedHeading;
    private int iterations = 0;

    public TurnToHeading(double heading) {
        requires(Robot.driveSystem);
        wantedHeading = heading;
    }

    @Override
    protected void initialize() {
        Robot.driveSystem.stop();
        Robot.driveSystem.resetHeading();
        Robot.driveSystem.resetEncoders();
    }

    @Override
    protected void execute() {
        System.out.println("In Turn to heading!");
        System.out.println("Heading: ");
        System.out.println(Robot.driveSystem.getGyroAngle());
        Robot.driveSystem.turnToHeading(wantedHeading);
        iterations++;
    }

    @Override
    protected boolean isFinished() {
        return Robot.driveSystem.reachedHeading(wantedHeading) || iterations >= 30;
    }

    @Override
    protected void end() {
        Robot.driveSystem.resetEncoders();
        Robot.driveSystem.stop();
    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}
