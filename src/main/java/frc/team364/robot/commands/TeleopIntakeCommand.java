/*
 * George and Keanu:
 * This is the default intake command and will run during teleop since
 * it is the default command of IntakeSystem. Hopefully you're picking up
 * on how this works now.
 */

package frc.team364.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.OI;
import frc.team364.robot.Robot;

public class TeleopIntakeCommand extends Command {

    public boolean intake = OI.intakeButton.get();
    public boolean outtake = OI.outtakeButton.get();
    public boolean flipClaw = OI.clawButton.get();

    public TeleopIntakeCommand() {
        requires(Robot.intakeSystem);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        if(Robot.oi.intakeButton.get()) {
            Robot.intakeSystem.intake();
        } else if(Robot.oi.outtakeButton.get()) {
            Robot.intakeSystem.outtake();
        } else {
            Robot.intakeSystem.stop();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.intakeSystem.stop();
    }

}
