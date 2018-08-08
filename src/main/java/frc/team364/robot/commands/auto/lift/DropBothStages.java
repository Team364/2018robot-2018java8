package frc.team364.robot.commands.auto.lift;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;


public class DropBothStages extends Command {

    public DropBothStages(boolean scale) {
        requires(Robot.liftSystem);
        if(scale){
      setTimeout(1.5);
        } else{
            setTimeout(0.75);
        }
    }

    @Override
    protected void initialize() {
        Robot.liftSystem.stopBoth();
    }

    @Override
    protected void execute() {
        Robot.liftSystem.firstStageControl(1);
        Robot.liftSystem.secondStageControl(-1);
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
