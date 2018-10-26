/*
 * This is the DriveSystem class. It holds objects for all of the motor controllers,
 * shift pistons, PID, and the navX. It also has functions for running DriveToDistance and
 * TurnToHeading.
 */

package frc.team364.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team364.robot.commands.teleop.TeleopDriveCommand;


public class DriveSystem extends Subsystem {

    public TalonSRX leftFront;
    public TalonSRX leftRear;
    public TalonSRX rightFront;
    public TalonSRX rightRear;

    public DriveSystem() {
        
        leftFront = new TalonSRX(14);
        leftRear = new TalonSRX(15);
        rightFront = new TalonSRX(10);
        rightRear = new TalonSRX(11);

        leftFront.follow(leftRear);
        rightFront.follow(rightRear);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new TeleopDriveCommand());
    }

    /**
     * tankDrive()
     * Sets manual control of the drivetrain for teleop
     * @param left sets the left drive power
     * @param right sets the right drive power
     */
    public void tankDrive(double left, double right) {
        leftRear.set(ControlMode.PercentOutput, left);
        rightRear.set(ControlMode.PercentOutput, -right);
    }

    /**
     * stop()
     * Stops the drive motors
     * Use this in auto to stop the drivetrain inbetween commands
     */ 
    public void stop() {
        leftRear.set(ControlMode.PercentOutput, 0);
        rightRear.set(ControlMode.PercentOutput, 0);
    }
    /**
     * setLeftDrivePower()
     * Use this for motion profiling to set the left drive power
     * @param power sets the left drive power
     */ 
    public void setLeftDrivePower(double power) {
        leftRear.set(ControlMode.PercentOutput, power);
    }

    /**
     * setRightDrivePower()
     * Use this for motion profiling to set the right drive power
     * @param power sets the right drive power
     */ 
    public void setRightDrivePower(double power) {
        rightRear.set(ControlMode.PercentOutput, power);
    }

    public void driveForPower(double power){
        setRightDrivePower(power);
        setLeftDrivePower(power);

    }
}
