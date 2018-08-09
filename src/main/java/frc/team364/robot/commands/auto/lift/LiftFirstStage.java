package frc.team364.robot.commands.auto.lift;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;


public class LiftFirstStage extends Command {

    /**
     * LiftFirstStage()
     * The the first stage moves at full power for 1 second
     */
    public LiftFirstStage() {
        requires(Robot.liftSystem);
        setTimeout(1);
    }

    @Override
    protected void initialize() {
        Robot.liftSystem.stopBoth();
    }

    @Override
    protected void execute() {
       Robot.liftSystem.firstStageControl(-1);
       
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