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

    public IntakeSystem() {
        leftIntake = new VictorSPX(RobotMap.intakeLeft);
        rightIntake = new VictorSPX(RobotMap.intakeRight);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new TeleopIntakeCommand());
    }

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

    public void outtake() {
        leftIntake.set(ControlMode.PercentOutput, -1);
        rightIntake.set(ControlMode.PercentOutput, -1);
    }
    
    public void outtakeForPressure(){

            leftIntake.set(ControlMode.PercentOutput, -Robot.oi.controller.getRawAxis(3));
            rightIntake.set(ControlMode.PercentOutput, -Robot.oi.controller.getRawAxis(3));
    }

    public void intakeStop() {
        leftIntake.set(ControlMode.PercentOutput, 0);
        rightIntake.set(ControlMode.PercentOutput, 0);
    }

}