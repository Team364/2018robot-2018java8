package frc.team364.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team364.robot.RobotMap;
import frc.team364.robot.commands.teleop.TeleopIntakeCommand;
import frc.team364.robot.Robot;

public class IntakeSystem extends Subsystem {

    private VictorSP leftIntake;
    private VictorSP rightIntake;


   /**
     * IntakeSystem()
     * used to intake cubes into claw for transport and outtake cubes for scoring
     */
    public IntakeSystem() {
        leftIntake = new VictorSP(RobotMap.intakeLeft);
        rightIntake = new VictorSP(RobotMap.intakeRight);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new TeleopIntakeCommand());
    }
    /**
     * intake()
     * runs the intake motors at full power
     */
    public void intake() {
        leftIntake.set(1);
        rightIntake.set(1);
    }
    /**
     * intended for auto
     * - if the robot is moving backwards then the intake will run slower
     */
    public void intakeWhileMoving(boolean backwards) {
        if(!backwards){
            leftIntake.set(0.5);
            rightIntake.set(0.5);
        }else{ 
            leftIntake.set(1);
            rightIntake.set(1);
        }
       
    }
    /**
     * outtake()
     * runs the intake motors at full power in reverse
     */
    public void outtake() {
        leftIntake.set(-1);
        rightIntake.set(-1);
    }
    /**
     * outtakeForPressure()
     * runs the intake motors in reverse at a speed directly porportional to how far in the trigger is pushed, hence, pressure
     */  
    public void outtakeForPressure(){

            leftIntake.set(Robot.oi.controller.getRawAxis(3));
            rightIntake.set(Robot.oi.controller.getRawAxis(3));
    }
    /**
     * intakeStop()
     * sets the power for the intake motors to zero
     */
    public void intakeStop() {
        leftIntake.set(0);
        rightIntake.set(0);
    }

}