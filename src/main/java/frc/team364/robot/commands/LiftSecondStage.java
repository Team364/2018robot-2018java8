package frc.team364.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;


public class LiftSecondStage extends Command {

    public LiftSecondStage() {
        requires(Robot.liftSystem);
    }

    @Override
    protected void initialize() {
        Robot.liftSystem.stopBoth();
    }

    @Override
    protected void execute() {
       Robot.liftSystem.secondStageControl(1);
    }

    @Override
    protected boolean isFinished() {
        return Robot.liftSystem.getSecondStageTopLimit();
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
