package frc.team364.robot.commands.auto.lift;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;


public class LiftSecondStage extends Command {
    /**
     * LiftSecondStage()
     * The second stage receives full power for 1 second
     */
    public LiftSecondStage() {
        requires(Robot.liftSystem);
        setTimeout(1);
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