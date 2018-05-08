/*
 * George and Keanu:
 * This is the default intake command and will run during teleop since
 * it is the default command of IntakeSystem. Hopefully you're picking up
 * on how this works now.
 */

package frc.team364.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;

public class TeleopIntakeCommand extends Command {

    // Variables for claw toggle
    private int clawState;
    private boolean clawLatch;
    private int pincherState;
    private boolean pincherLatch;

    public TeleopIntakeCommand() {
        requires(Robot.intakeSystem);
        clawState = 0;
        clawLatch = false;
        pincherState = 0;
        pincherLatch = false;
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
       
        // Run the intake/outtake on button press.
        // No toggle.
        if(Robot.oi.intakeButton.get()) {
            Robot.intakeSystem.intake();
        } else if(Robot.oi.outtakeButton.get()) {
            Robot.intakeSystem.outtake();
        } else {
            Robot.intakeSystem.intakeStop();
        }

        // This is a toggle algorithm. If the button is pressed, it will
        // set the mechanism to a certain state on the first loop when the
        // button is pressed. Each loop afterwards will turn the solenoid off
        // and wait until the button is depressed.
        if(Robot.oi.clawButton.get()) {
            if(!clawLatch) {
                if(clawState == 0) {
                    System.out.println("Flipping claw up.");
                    Robot.intakeSystem.flipClawUp();
                    clawLatch = true;
                } else {
                    System.out.println("Flipping claw down.");
                    Robot.intakeSystem.flipClawDown();
                    clawLatch = true;
                }
            } else {
                System.out.println("Off!");
                if(clawState == 1) {
                    clawState = 0;
                } else {
                    clawState = 1;
                }
                Robot.intakeSystem.clawOff();
            }
        } else {
            Robot.intakeSystem.clawOff();
            clawLatch = false;
        }

        if(Robot.oi.pinchButton.get()) {
            if(!pincherLatch) {
                if(pincherState == 0) {
                    Robot.intakeSystem.openPincher();
                    pincherLatch = true;
                } else {
                    Robot.intakeSystem.closePincher();
                    pincherLatch = true;
                }
            } else {
                if(pincherState == 1) {
                    pincherState = 0;
                } else {
                    pincherState = 1;
                }
                Robot.intakeSystem.clawOff();
            }
        } else {
            Robot.intakeSystem.pincherOff();
            pincherLatch = false;
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
