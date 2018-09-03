package frc.team364.robot.commands.teleop;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;


public class RampDown extends Command {


    public RampDown() {
        requires(Robot.driveSystem);
        setTimeout(1);
    }

    @Override
    protected void initialize() {
        Robot.driveSystem.pidRampDown.setPIDParameters(1, 0.01, 0, 1); // Robot.driveSystem.pidNavX.setPIDParameters(0.05, 0.01, 0, 0);
        Robot.driveSystem.stop();
        Robot.driveSystem.resetHeading();
        Robot.driveSystem.pidRampDown.resetPID();
        Robot.driveSystem.pidLeft.resetPID();
        Robot.driveSystem.pidRight.resetPID();
    }

    @Override
    protected void execute() {
        Robot.driveSystem.rampDown();
    }

    @Override
    protected boolean isFinished() {

        return Robot.driveSystem.reachedSmoothStop() || isTimedOut();
    }

    @Override
    protected void end() {
        Robot.driveSystem.stop();
        Robot.driveSystem.resetHeading();
    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}
