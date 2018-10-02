package frc.team364.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team364.robot.RobotMap;
import frc.team364.robot.commands.teleop.TeleopIntakeCommand;
import frc.team364.robot.Robot;

public class IntakeSystem extends Subsystem {

    private VictorSPX leftIntake;
    private VictorSPX rightIntake;


   /**
     * IntakeSystem()
     * used to intake cubes into claw for transport and outtake cubes for scoring
     */
    public IntakeSystem() {
        leftIntake = new VictorSPX(RobotMap.intakeLeft);
        rightIntake = new VictorSPX(RobotMap.intakeRight);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new TeleopIntakeCommand());
    }
    /**
     * intake()
     * runs the intake motors at full power
     */
    public void intake() {
        leftIntake.set(ControlMode.PercentOutput, 1);
        rightIntake.set(ControlMode.PercentOutput, 1);
    }
    /**
     * intended for auto
     * - if the robot is moving backwards then the intake will run slower
     */
    public void intakeWhileMoving(boolean backwards) {
        if(!backwards){
            leftIntake.set(ControlMode.PercentOutput, 0.5);
            rightIntake.set(ControlMode.PercentOutput, 0.5);
        }else{ 
            leftIntake.set(ControlMode.PercentOutput, 1);
            rightIntake.set(ControlMode.PercentOutput, 1);
        }
       
    }
    /**
     * outtake()
     * runs the intake motors at full power in reverse
     */
    public void outtake() {
        leftIntake.set(ControlMode.PercentOutput, -1);
        rightIntake.set(ControlMode.PercentOutput, -1);
    }
    /**
     * outtakeForPressure()
     * runs the intake motors in reverse at a speed directly porportional to how far in the trigger is pushed, hence, pressure
     */  
    public void outtakeForPressure(){

            leftIntake.set(ControlMode.PercentOutput, Robot.oi.controller.getRawAxis(3));
            rightIntake.set(ControlMode.PercentOutput, Robot.oi.controller.getRawAxis(3));
    }
    /**
     * intakeStop()
     * sets the power for the intake motors to zero
     */
    public void intakeStop() {
        leftIntake.set(ControlMode.PercentOutput, 0);
        rightIntake.set(ControlMode.PercentOutput, 0);
    }

}