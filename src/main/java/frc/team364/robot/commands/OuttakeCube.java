package frc.team364.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;


public class OuttakeCube extends Command {

    public OuttakeCube() {
        requires(Robot.intakeSystem);
        setTimeout(0.5);
    }

    @Override
    protected void initialize() {
        Robot.intakeSystem.intakeStop();
    }

    @Override
    protected void execute() {
        Robot.intakeSystem.outtake();
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