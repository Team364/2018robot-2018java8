package frc.team364.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team364.robot.RobotMap;
import frc.team364.robot.commands.TeleopIntakeCommand;

public class IntakeSystem extends Subsystem {

    public VictorSPX leftIntake;
    public VictorSPX rightIntake;
    public DoubleSolenoid pincher;
    public DoubleSolenoid claw;

    public IntakeSystem() {
        leftIntake = new VictorSPX(RobotMap.intakeLeft);
        rightIntake = new VictorSPX(RobotMap.intakeRight);
        pincher = new DoubleSolenoid(RobotMap.pinchPistonPort1, RobotMap.pinchPistonPort2);
        claw = new DoubleSolenoid(RobotMap.clawPistonPort1, RobotMap.clawPistonPort2);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new TeleopIntakeCommand());
    }


    //TODO: Implement state controllers for these functions - the code below is a bad way to approach this
    public void intake() {
        leftIntake.set(ControlMode.PercentOutput, 1);
        rightIntake.set(ControlMode.PercentOutput, 1);
    }

    public void outtake() {
        leftIntake.set(ControlMode.PercentOutput, -1);
        rightIntake.set(ControlMode.PercentOutput, -1);
    }

    public void stop() {
        leftIntake.set(ControlMode.PercentOutput, 0);
        rightIntake.set(ControlMode.PercentOutput, 0);
    }

    public void flipClawDown() {
        claw.set(DoubleSolenoid.Value.kForward);
    }

    public void flipClawUp() {
        claw.set(DoubleSolenoid.Value.kReverse);
    }

    public void openPincher() {
        pincher.set(DoubleSolenoid.Value.kForward);
    }

    public void closePincher() {
        pincher.set(DoubleSolenoid.Value.kReverse);
    }

}
