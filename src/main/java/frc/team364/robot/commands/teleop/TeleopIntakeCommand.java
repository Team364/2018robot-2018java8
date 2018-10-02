/*
 * George and Keanu:
 * This is the default intake command and will run during teleop since
 * it is the default command of IntakeSystem. Hopefully you're picking up
 * on how this works now.
 */

package frc.team364.robot.commands.teleop;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;

public class TeleopIntakeCommand extends Command {

    /**
     * Command used for teleop control specific to the intake system
     */
    public TeleopIntakeCommand() {
        requires(Robot.intakeSystem);
    }

    @Override
    protected void execute() {
       
 // Run the intake and outtake are run on triggers(axis)
        //If the trigger is pressed more than halfway then the intake will run
        if(Robot.oi.controller.getRawAxis(4) > 0.5) {
            Robot.intakeSystem.intake();
            System.out.println("Intake is running");
        //If the trigger is pressed lightly then the outtake for variable trigger pressure will run
        } else if(Robot.oi.controller.getRawAxis(3) > 0.2) {
            Robot.intakeSystem.outtakeForPressure();
            System.out.println("Outtake is running");
        } else {
        //If neither trigger is being pressed then the outtake will run
            Robot.intakeSystem.intakeStop();
        }

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.intakeSystem.intakeStop();
    }

}
