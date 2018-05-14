package frc.team364.robot.commands.teleop;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;

import static frc.team364.robot.Robot.buddySystem;


public class TeleopBuddyCommand extends Command {

    public TeleopBuddyCommand() {
        requires(Robot.buddySystem);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {

        if(Robot.oi.buddyBarButton.get() == true) {
            buddySystem.setLock(false);
        } else if(Robot.oi.buddyBarButton.get() == false) {
            buddySystem.setLock(true);
        }

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}
