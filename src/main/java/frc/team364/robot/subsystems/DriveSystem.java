package frc.team364.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
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
//Teleop
    public void tankDrive(double left, double right) {
        leftRear.set(ControlMode.PercentOutput, left);
        rightRear.set(ControlMode.PercentOutput, -right);
    }
//Auto
    public void setLeftDrivePower(double power) {
        leftRear.set(ControlMode.PercentOutput, power);
    }

    public void setRightDrivePower(double power) {
        rightRear.set(ControlMode.PercentOutput, power);
    }

    public void driveForPower(double power){
        setRightDrivePower(power);
        setLeftDrivePower(power);
    }
    public void stop() {
        leftRear.set(ControlMode.PercentOutput, 0);
        rightRear.set(ControlMode.PercentOutput, 0);
        }
}
