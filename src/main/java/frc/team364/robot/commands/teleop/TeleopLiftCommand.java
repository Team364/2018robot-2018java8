package frc.team364.robot.commands.teleop;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;
import frc.team364.robot.subsystems.LiftSystem;

public class TeleopLiftCommand extends Command {
    public static double currentCount;
    public LiftSystem liftSystem = Robot.liftSystem;
   //public boolean liftUp = Robot.oi.liftButton.get();--aren't even used in code it seems
    //public boolean liftDown = Robot.oi.dropButton.get();
    public int counts = 0;
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
        if(liftSystem.getEncoderCounts() <= 0){
            liftSystem.resetEncoders();
        }
        if(Robot.oi.resetLiftEncoderButton.get()){
            liftSystem.resetEncoders();
        }
        if(Robot.oi.firstStageLiftButton.get()) {
            liftSystem.firstStageControl(-1);
            counts = liftSystem.getEncoderCounts();
        } else {
            if(Robot.oi.controller.getPOV() == 0) {
                liftSystem.firstStageControl(-1);
                liftSystem.secondStageControl(1);
                //counts = liftSystem.getEncoderCounts();
              //  auto = false;
                liftSystem.liftCountError = 200;
            } else if(Robot.oi.controller.getPOV() == 180) {
                liftSystem.firstStageControl(1);
                liftSystem.secondStageControl(-1);
                //counts = liftSystem.getEncoderCounts();
                 
                  liftSystem.liftCountError = 100;
               //  auto = false;
            } else {
               if(!auto){
             //   setTimeout(0.3);
                counts = liftSystem.getEncoderCounts();

               liftSystem.keepFirstStagePosition(counts);        
            }
            }
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
