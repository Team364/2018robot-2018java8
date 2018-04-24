/*
 * George and Keandre:
 * This is the DriveSystem class. It holds objects for all of the motor controllers,
 * shift pistons, PID, and the navX. It also has functions for running DriveToDistance and
 * TurnToHeading.
 */

package frc.team364.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team364.robot.PIDCalc;
import frc.team364.robot.RobotMap;
import frc.team364.robot.commands.TeleopDriveCommand;

public class DriveSystem extends Subsystem {

    public final TalonSRX leftFront;
    public final TalonSRX leftRear;
    public final TalonSRX rightFront;
    public final TalonSRX rightRear;
    public final DoubleSolenoid shifter;
    public final AHRS navX;
    public final PIDCalc pid;
    public double pidOutput;

    public DriveSystem() {
        leftFront = new TalonSRX(RobotMap.leftFrontDrive);
        leftRear = new TalonSRX(RobotMap.leftRearDrive);
        rightFront = new TalonSRX(RobotMap.rightFrontDrive);
        rightRear = new TalonSRX(RobotMap.rightRearDrive);
        shifter = new DoubleSolenoid(RobotMap.shifterPort1, RobotMap.shifterPort2);

        leftFront.follow(leftRear);
        rightFront.follow(rightRear);

        leftRear.config_kP(0, 0.25, 100);
        leftRear.config_kF(0, 1, 100);

        rightRear.config_kP(0, 0.25, 100);
        rightRear.config_kF(0, 1, 100);

        navX = new AHRS(SPI.Port.kMXP);

        pid = new PIDCalc(0.03, 0, 0, 0);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new TeleopDriveCommand());
    }

    public void tankDrive(double left, double right) {
        leftRear.set(ControlMode.PercentOutput, left);
        rightRear.set(ControlMode.PercentOutput, right);
    }

    public void stop() {
        leftRear.set(ControlMode.PercentOutput, 0);
        rightRear.set(ControlMode.PercentOutput, 0);
    }

    public void driveStraightToEncoderCounts(int counts) {
        leftRear.set(ControlMode.Position, counts);
        rightRear.set(ControlMode.Position, counts);
    }

    public boolean withinEncoderCountRange(int counts) {

        double leftRearPos = leftRear.getSelectedSensorPosition(0);
        double rightRearPos = rightRear.getSelectedSensorPosition(0);

        return leftRearPos >= (counts - 10) && leftRearPos <= (counts + 10) && rightRearPos >= (counts - 10) && rightRearPos <= (counts + 10);

    }

    public void resetHeading() {
        navX.reset();
    }

    public void turnToHeading(double heading) {
        pidOutput = pid.calculateOutput(heading, navX.getYaw());
        leftRear.set(ControlMode.PercentOutput, pidOutput);
        rightRear.set(ControlMode.PercentOutput, -pidOutput);
    }

    public boolean reachedHeading(double heading) {
        if(navX.getYaw() <= (heading + 1) && navX.getYaw() >= (heading - 1)) {
            return true;
        } else {
            return false;
        }
    }

    public void shiftHigh() {
        shifter.set(DoubleSolenoid.Value.kForward);
    }

    public void shiftLow() {
        shifter.set(DoubleSolenoid.Value.kReverse);
    }

    public void noShiftInput() {
        shifter.set(DoubleSolenoid.Value.kOff);
    }
}
