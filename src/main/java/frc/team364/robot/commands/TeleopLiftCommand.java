package frc.team364.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;
import frc.team364.robot.subsystems.LiftSystem;

public class TeleopLiftCommand extends Command {

    public LiftSystem liftSystem = Robot.liftSystem;
    public boolean liftUp = Robot.oi.liftButton.get();
    public boolean liftDown = Robot.oi.dropButton.get();
    public int counts = 0;

    public TeleopLiftCommand() {
        requires(Robot.liftSystem);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void end() {
    }

    @Override
    protected void execute() {

        if(liftUp) {
            liftSystem.firstStageControl(1);
            liftSystem.secondStageControl(1);
        } else if(liftDown) {
            liftSystem.firstStageControl(-1);
            liftSystem.secondStageControl(-1);
        } else {
            counts = liftSystem.getEncoderCounts();
            liftSystem.keepFirstStagePosition(counts);
        }

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
