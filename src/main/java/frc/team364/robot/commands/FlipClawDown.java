package frc.team364.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;


public class FlipClawDown extends Command {

    public FlipClawDown() {
        requires(Robot.intakeSystem);
        setTimeout(0.1);
    }

    @Override
    protected void initialize() {
        Robot.intakeSystem.clawOff();
    }

    @Override
    protected void execute() {
        Robot.intakeSystem.flipClawUp();
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        Robot.intakeSystem.clawOff();
    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}