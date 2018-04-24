package frc.team364.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class RobotMap {

    // Drive objects
    public static final int leftFrontDrive = 0;
    public static final int leftRearDrive = 1;
    public static final int rightFrontDrive = 2;
    public static final int rightRearDrive = 3;
    public static final int shifterPort1 = 0;
    public static final int shifterPort2 = 1;

    // First stage elevator objects
    public static final int firstStage1 = 4;
    public static final int firstStage2 = 5;
    public static final int firstStageBottomLimit = 0;
    public static final int firstStageTopLimit = 1;

    // Second stage elevator objects
    public static final int secondStage1 = 6;
    public static final int secondStage2 = 7;
    public static final int secondStageBottomLimit = 2;
    public static final int secondStageTopLimit = 3;

    // Intake objects
    public static final int intakeLeft = 8;
    public static final int intakeRight = 9;

    // Intake/Claw objects
    public static final int clawPistonPort1 = 2;
    public static final int clawPistonPort2 = 3;
    public static final int pinchPistonPort1 = 4;
    public static final int pinchPistonPort2 = 5;

    // Buddy bar objects
    public static final int buddyBarPistonPort1 = 6;
    public static final int buddyBarPistonPort2 = 7;
    public static final int lockPistonPort1 = 8;
    public static final int lockPistonPort2 = 9;
}
