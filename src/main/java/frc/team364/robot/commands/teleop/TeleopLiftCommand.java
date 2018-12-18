package frc.team364.robot.commands.teleop;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;
import frc.team364.robot.subsystems.LiftSystem;
import edu.wpi.first.networktables.*;
import frc.team364.robot.PIDCalc;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.HLUsageReporting.Null;

public class TeleopLiftCommand extends Command {
    public LiftSystem liftSystem = Robot.liftSystem;
    public double liftOutput;
    public NetworkTableEntry centerY;
    public NetworkTableEntry area;
    public PIDCalc pid;
    public double pidOutput;
    public PIDCalc pida;
    public double pidOutputa;
    public double[] y;
   //public boolean liftUp = Robot.oi.liftButton.get();--aren't even used in code it seems
    //public boolean liftDown = Robot.oi.dropButton.get();
    public boolean auto = true;

    public TeleopLiftCommand() {
        requires(Robot.liftSystem);
    }

    @Override
    protected void initialize() {
        NetworkTableInstance inst = NetworkTableInstance.getDefault();
        NetworkTable table = inst.getTable("GRIP/contours");
        centerY = table.getEntry("centerY");
        pid = new PIDCalc(0.003, 0.001, 0.0, 0.0, "follow");
    }

    @Override
    protected void end() {
    }

    
    @Override
    protected void execute() {
        auto = false;
        if(Robot.oi.firstStageLiftButton.get()) {
            liftSystem.firstStageControl(-1);
        } else if(Robot.oi.controller.getRawButton(9)){
            double[] defaultValue = {160.0};
            y = centerY.getDoubleArray(defaultValue);
            SmartDashboard.putNumberArray("yarray", y);
            if(y.length >= 1) {
                pidOutput = pid.calculateOutput(160, y[0]);
                liftOutput = pidOutput;
                liftSystem.firstStageControl(-liftOutput);
                liftSystem.secondStageControl(liftOutput);
            }
        }else {
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
