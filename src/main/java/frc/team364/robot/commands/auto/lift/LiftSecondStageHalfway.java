package frc.team364.robot.commands.auto.lift;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;


public class LiftSecondStageHalfway extends Command {
    /**
     * LiftSecondStageHalfway()
     * Auto Command - The second stage runs at full power for 1.5 seconds
     */
    public LiftSecondStageHalfway() {
        requires(Robot.liftSystem);
        setTimeout(1.5);
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