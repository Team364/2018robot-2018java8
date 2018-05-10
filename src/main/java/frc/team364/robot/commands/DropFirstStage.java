package frc.team364.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;


public class DropFirstStage extends Command {

    public DropFirstStage() {
        requires(Robot.liftSystem);
        setTimeout(1);
    }

    @Override
    protected void initialize() {
        Robot.liftSystem.stopBoth();
    }

    @Override
    protected void execute() {
        Robot.liftSystem.firstStageControl(1);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        Robot.liftSystem.stopBoth();
    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}
