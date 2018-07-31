package frc.team364.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
 //Potentiometer import edu.wpi.first.wpilibj.AnalogInput;
import frc.team364.robot.RobotMap;
import frc.team364.robot.commands.teleop.TeleopClawCommand;

public class ClawSystem extends Subsystem {

    private DoubleSolenoid pincher;
    private DoubleSolenoid claw;
     //Potentiometer private AnalogInput pot;

    public ClawSystem() {
        pincher = new DoubleSolenoid(RobotMap.pinchPistonPort1, RobotMap.pinchPistonPort2);
        claw = new DoubleSolenoid(RobotMap.clawPistonPort1, RobotMap.clawPistonPort2);
     //Potentiometer pot = new AnalogInput(0);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new TeleopClawCommand());
    }

    public void flipClawDown() {
        claw.set(DoubleSolenoid.Value.kForward);
    }

    public void flipClawUp() {
        claw.set(DoubleSolenoid.Value.kReverse);
    }

    public void clawOff() {
        claw.set(DoubleSolenoid.Value.kOff);
    }

    public void openPincher() {
        pincher.set(DoubleSolenoid.Value.kForward);
    }

    public void closePincher() {
        pincher.set(DoubleSolenoid.Value.kReverse);
    }

    public void pincherOff() {
        pincher.set(DoubleSolenoid.Value.kOff);
    }

    /*Potentiometer
    public double getPotVoltage(){
        return  pot.getVoltage();
    }*/
    

}