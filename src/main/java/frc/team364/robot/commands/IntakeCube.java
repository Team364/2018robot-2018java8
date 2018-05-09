package frc.team364.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;


public class IntakeCube extends Command {

    public IntakeCube() {
        requires(Robot.intakeSystem);
        setTimeout(1.5);
    }

    @Override
    protected void initialize() {
        Robot.intakeSystem.intakeStop();
    }

    @Override
    protected void execute() {
        Robot.intakeSystem.intake();
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        Robot.intakeSystem.intakeStop();
    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}