/*
 * George and Keanu:
 * This is the BuddySystem class. It holds all functions for controlling
 * the buddy bar system (lock and buddy bar deploy). Read the code and
 * see if you understand it.
 */

package frc.team364.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team364.robot.RobotMap;
import frc.team364.robot.commands.TeleopBuddyCommand;

public class BuddySystem extends Subsystem {

    private DoubleSolenoid buddyBar;
    private DoubleSolenoid locker;

    public BuddySystem() {
        buddyBar = new DoubleSolenoid(RobotMap.buddyBarPistonPort1, RobotMap.buddyBarPistonPort2);
        locker = new DoubleSolenoid(RobotMap.lockPistonPort1, RobotMap.lockPistonPort2);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new TeleopBuddyCommand());
    }

    public void setLock(boolean mode) {
        if(mode == true) {
            buddyBar.set(DoubleSolenoid.Value.kForward);
            locker.set(DoubleSolenoid.Value.kForward);
        } else {
            buddyBar.set(DoubleSolenoid.Value.kReverse);
            locker.set(DoubleSolenoid.Value.kReverse);
        }
    }

}

