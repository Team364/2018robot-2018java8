package frc.team364.robot.commands.teleop;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;
import frc.team364.robot.subsystems.LiftSystem;

public class TeleopLiftCommand extends Command {
    public LiftSystem liftSystem = Robot.liftSystem;
   //public boolean liftUp = Robot.oi.liftButton.get();--aren't even used in code it seems
    //public boolean liftDown = Robot.oi.dropButton.get();
    public boolean auto = true;

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
        auto = false;
        if(Robot.oi.firstStageLiftButton.get()) {
            liftSystem.firstStageControl(-1);
        } else {
            if(Robot.oi.controller.getPOV() == 0) {
                liftSystem.firstStageControl(-1);
                liftSystem.secondStageControl(1);
                
            } else if(Robot.oi.controller.getPOV() == 180) {
                liftSystem.firstStageControl(1);
                liftSystem.secondStageControl(-1);
              
            } else{
                liftSystem.firstStageControl(0);
                liftSystem.secondStageControl(0);
            }
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
