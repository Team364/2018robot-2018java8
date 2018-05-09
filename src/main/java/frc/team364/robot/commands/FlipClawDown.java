package frc.team364.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;


public class FlipClawDown extends Command {

    public FlipClawDown() {
        requires(Robot.intakeSystem);
    }

    @Override
    protected void initialize() {
        Robot.intakeSystem.clawOff();
    }

    @Override
    protected void execute() {
        Robot.intakeSystem.flipClawDown();
    }

    @Override
    protected boolean isFinished() {
        return true;
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