package frc.team364.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;


public class OpenPincher extends Command {

    public OpenPincher() {
        requires(Robot.intakeSystem);
    }

    @Override
    protected void initialize() {
        Robot.intakeSystem.pincherOff();
    }

    @Override
    protected void execute() {
        Robot.intakeSystem.openPincher();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        Robot.intakeSystem.pincherOff();
    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}