package frc.team364.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class VisionCommand extends Command {

    public double[] x = Robot.visionSystem.x;
    public double[] a = Robot.visionSystem.a;
  

    public VisionCommand() {
        requires(Robot.visionSystem);
    }

    @Override
    protected void execute() {
        //See if you can move more of this into the visionSystem.
        if(Robot.oi.controller.getRawButton(2)){
           if(Robot.visionSystem.cubeInSight(x)) {
                if(Robot.visionSystem.lockedOn(Robot.visionSystem.x)){
                    System.out.println("Action would be executed ");
                   
            } else{
                System.out.println("The cube is reported to not be lined up");
            }
        }else{
            System.out.println("The cube is reported to not be in sight");
        }
    }
}

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    

}
