
package frc.team364.robot.commands.teleop;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;
import edu.wpi.first.wpilibj.Joystick;

public class TeleopDriveCommand extends Command {
    public Joystick leftStick;
    public Joystick rightStick;

    public TeleopDriveCommand() {
        requires(Robot.driveSystem);
        leftStick = new Joystick(0);
        rightStick = new Joystick(1);
    }

    @Override
    protected void end() {
        Robot.driveSystem.stop();
    }

    @Override
    protected void execute() {
        Robot.driveSystem.tankDrive(leftStick.getRawAxis(1), rightStick.getRawAxis(1));
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
