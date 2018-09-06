/*
 *  George and Keanu:
 *  This is the TeleopDriveCommand. This runs whenever there isn't another command
 *  running that requries the DriveSystem class. In Execute, the drive motors are
 *  given an output from the joysticks using a variable in the OI (Operator Interface) class.
 *  The shifters are also set using the triggers from each joystick.
 */

package frc.team364.robot.commands.teleop;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TeleopDriveCommand extends Command {

    public double leftControllerInput;
    public double rightControllerInput;
    public static Command RampDown;
    public boolean rampDownSequence;
    public boolean forward;
    public double leftVelocity;
    public double rightVelocity;
    /**
     * Command used for teleop control specific to the drive system
     */
    public TeleopDriveCommand() {
        requires(Robot.driveSystem);
        RampDown = new RampDown(forward);
    }

    @Override
    protected void initialize() {
        rampDownSequence = false;
    }

    @Override
    protected void end() {
        // This will probably never be called.
        Robot.driveSystem.stop();
    }

    @Override
    protected void execute() {
        rightControllerInput = Robot.oi.driverController.getRawAxis(1);
        leftControllerInput = Robot.oi.driverController.getRawAxis(5);
        rightVelocity = Robot.driveSystem.rightRear.getSelectedSensorVelocity(0);
        leftVelocity = Robot.driveSystem.leftRear.getSelectedSensorVelocity(0);
        SmartDashboard.putBoolean("RampDown: ", rampDownSequence);
        SmartDashboard.putData("RampDownStatus: ", RampDown);
        SmartDashboard.putNumber("Velocity: ", Robot.driveSystem.leftRear.getSelectedSensorVelocity(0));//Velocity in feet
       

        //normal tank drive control
        
        Robot.driveSystem.tankDrive(leftControllerInput, rightControllerInput);


        //Executing ramping down command
        if(rampDownSequence){
        if((leftControllerInput <= 0.5) && (rightControllerInput <= 0.5) && (Math.abs(leftControllerInput) <= 0.5)){
            RampDown.start();
            forward = true;
        }else if((leftControllerInput <= -0.5) && (rightControllerInput <= -0.5) && (Math.abs(leftControllerInput) <= 0.5)){
            RampDown.start();
            forward = false;
        }else{
           // RampDown.cancel();
        }
    }else if((Math.abs(leftControllerInput) >= 0.5) && (Math.abs(rightControllerInput) >= 0.5)){
        rampDownSequence = true;
    }
    //These will turn off the sequence before it is attempted to be executed
    //IF turning, deactivate sequence
        if(Math.abs(leftControllerInput - rightControllerInput) >= 0.3){
            rampDownSequence = false;
        }


       

        if(Robot.oi.shiftHigh.get()) {
            Robot.driveSystem.shiftHigh();
        } else if(Robot.oi.shiftLow.get()) {
            Robot.driveSystem.shiftLow();
        } else {
            Robot.driveSystem.noShiftInput();
        }

        SmartDashboard.putNumber("GetLeftRear: ", Robot.driveSystem.leftRear.getMotorOutputPercent());
        SmartDashboard.putNumber("GetRightRear: ", Robot.driveSystem.rightRear.getMotorOutputPercent());
        SmartDashboard.putNumber("GetLeftContr: ", leftControllerInput);
        SmartDashboard.putNumber("GetRightContr: ", rightControllerInput);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
