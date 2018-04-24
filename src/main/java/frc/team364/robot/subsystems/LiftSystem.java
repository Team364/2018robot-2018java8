/*
 * George and Keandre:
 * This is the LiftSystem class. It holds objects for all of the Talons, Victors, and
 * limit switches. We can add more sensors as we iterate the robot design over the offseason.
 */

package frc.team364.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team364.robot.RobotMap;
import frc.team364.robot.commands.TeleopLiftCommand;

public class LiftSystem extends Subsystem {

    public final TalonSRX firstStage1;
    public final TalonSRX firstStage2;
    public final VictorSPX secondStage1;
    public final VictorSPX secondStage2;
    public final DigitalInput firstStageTopLimit;
    public final DigitalInput firstStageBottomLimit;
    public final DigitalInput secondStageTopLimit;
    public final DigitalInput secondStageBottomLimit;

    public LiftSystem() {
        firstStage1 = new TalonSRX(RobotMap.firstStage1);
        firstStage2 = new TalonSRX(RobotMap.firstStage2);

        secondStage1 = new VictorSPX(RobotMap.secondStage1);
        secondStage2 = new VictorSPX(RobotMap.secondStage2);

        firstStage2.follow(firstStage1);
        secondStage2.follow(secondStage1);

        firstStage1.config_kP(0, 0.25, 100);

        firstStageTopLimit = new DigitalInput(RobotMap.firstStageTopLimit);
        firstStageBottomLimit = new DigitalInput(RobotMap.secondStageBottomLimit);

        secondStageTopLimit = new DigitalInput(RobotMap.secondStageTopLimit);
        secondStageBottomLimit = new DigitalInput(RobotMap.secondStageBottomLimit);
    }

    @Override
    protected void initDefaultCommand(){
        setDefaultCommand(new TeleopLiftCommand());
    }

    public void firstStageControl(double speed) {
        if (getFirstStageTopLimit()) {
            if(speed < 0) {
                firstStage1.set(ControlMode.PercentOutput, speed);
            }
        } else if(getFirstStageBottomLimit()) {
            if (speed > 0) {
                firstStage1.set(ControlMode.PercentOutput, speed);
            }
        } else {
            firstStage1.set(ControlMode.PercentOutput, 0);
        }
    }

    public void secondStageControl(double speed) {
        if (getSecondStageTopLimit()) {
            if(speed < 0) {
                secondStage1.set(ControlMode.PercentOutput, speed);
            }
        } else if(getSecondStageBottomLimit()) {
            if (speed > 0) {
                secondStage1.set(ControlMode.PercentOutput, speed);
            }
        } else {
            secondStage1.set(ControlMode.PercentOutput, 0);
        }
    }

    public void keepFirstStagePosition(int counts) {
        firstStage1.set(ControlMode.Position, counts);
    }

    public int getEncoderCounts() {
        return firstStage1.getSelectedSensorPosition(0);
    }

    public boolean getFirstStageTopLimit() {
        return firstStageTopLimit.get();
    }

    public boolean getFirstStageBottomLimit() {
        return firstStageBottomLimit.get();
    }

    public boolean getSecondStageTopLimit() {
        return secondStageTopLimit.get();
    }

    public boolean getSecondStageBottomLimit() {
        return secondStageBottomLimit.get();
    }

    public void stopBoth() {
        firstStage1.set(ControlMode.PercentOutput, 0);
        secondStage1.set(ControlMode.PercentOutput, 0);
    }

}
