package frc.team364.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;


public class DropSecondStage extends Command {

    private int iterations = 0;

    public DropSecondStage() {
        requires(Robot.liftSystem);
    }

    @Override
    protected void initialize() {
        Robot.liftSystem.stopBoth();
    }

    @Override
    protected void execute() {
        Robot.liftSystem.secondStageControl(-1);
        iterations++;
    }

    @Override
    protected boolean isFinished() {
        return iterations >= 30;
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
