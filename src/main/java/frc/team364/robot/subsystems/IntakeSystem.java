package frc.team364.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team364.robot.RobotMap;
import frc.team364.robot.commands.TeleopIntakeCommand;

public class IntakeSystem extends Subsystem {

    private VictorSPX leftIntake;
    private VictorSPX rightIntake;
    private DoubleSolenoid pincher;
    private DoubleSolenoid claw;
    private int state;

    public IntakeSystem() {
        leftIntake = new VictorSPX(RobotMap.intakeLeft);
        rightIntake = new VictorSPX(RobotMap.intakeRight);
        pincher = new DoubleSolenoid(RobotMap.pinchPistonPort1, RobotMap.pinchPistonPort2);
        claw = new DoubleSolenoid(RobotMap.clawPistonPort1, RobotMap.clawPistonPort2);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new TeleopIntakeCommand());
    }

    public void stateController() {
        switch(state) {
            case 0:
                intake();
                break;
            case 1:
                outtake();
                break;
            case 2:
                stop();
                break;
        }
    }

    public void changeState(int state) {
        this.state = state;
    }

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
