package frc.team364.robot.commands.teleop;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;
import frc.team364.robot.subsystems.LiftSystem;

public class TeleopLiftCommand extends Command {
    public static double currentCount;
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
        if(Robot.oi.firstStageLiftButton.get()) {
            liftSystem.firstStageControl(-1);
            counts = liftSystem.getEncoderCounts();
        } else {
            if(Robot.oi.operationStation.getRawAxis(1) < -0.5) {
                liftSystem.firstStageControl(-1);
                liftSystem.secondStageControl(1);
                counts = liftSystem.getEncoderCounts();
            } else if(Robot.oi.operationStation.getRawAxis(1) > 0.5) {
                liftSystem.firstStageControl(1);
                liftSystem.secondStageControl(-1);
                counts = liftSystem.getEncoderCounts();
            } else {
                //Ghetto but it works
                //liftSystem.firstStageControl(-0.06);
                //liftSystem.secondStageControl(0.06);
               //-- liftSystem.stopBoth();
               liftSystem.keepFirstStagePosition(counts);
            }
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
