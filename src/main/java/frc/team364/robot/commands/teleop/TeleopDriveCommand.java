
package frc.team364.robot.commands.teleop;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;

public class TeleopDriveCommand extends Command {

    /**
     * Command used for teleop control specific to the drive system
     */
    public TeleopDriveCommand() {
        requires(Robot.driveSystem);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void end() {

        Robot.driveSystem.stop();
    }

    @Override
    protected void execute() {
        Robot.driveSystem.tankDrive(Robot.oi.leftStick.getRawAxis(1), Robot.oi.rightStick.getRawAxis(1));
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
