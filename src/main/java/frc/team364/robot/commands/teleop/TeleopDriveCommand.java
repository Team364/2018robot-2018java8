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
    /**
     * Command used for teleop control specific to the drive system
     */
    public TeleopDriveCommand() {
        requires(Robot.driveSystem);
        RampDown = new RampDown();
    }

    @Override
    protected void initialize() {
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
        SmartDashboard.putData("RampDownStatus: ", RampDown);
        SmartDashboard.putNumber("Velocity: ", Robot.driveSystem.leftRear.getSelectedSensorVelocity(0)*(1/1024)*(6* Math.PI));//Velocity in feet
       
        Robot.driveSystem.tankDrive(leftControllerInput, rightControllerInput);

        if((leftControllerInput <= 0.2) && (rightControllerInput <= 0.2)){
            RampDown.start();
        }else{
            RampDown.cancel();
        }

       

        if(Robot.oi.shiftHigh.get()) {
            Robot.driveSystem.shiftHigh();
        } else if(Robot.oi.shiftLow.get()) {
            Robot.driveSystem.shiftLow();
        } else {
            Robot.driveSystem.noShiftInput();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
