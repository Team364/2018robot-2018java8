package frc.team364.robot;

public class RobotMap {

    // Drive objects
    public static final int leftFrontDrive = 14;
    /**
     * has encoder
     */
    public static final int leftRearDrive = 15;
    public static final int rightFrontDrive = 10;
    /**
     * has encoder
     */
    public static final int rightRearDrive = 11;
    public static final int shifterPort1 = 3;
    public static final int shifterPort2 = 4;

    // First stage elevator objects
    public static final int firstStage1 = 8;//was 3
    public static final int firstStage2 = 13;
    public static final int firstStageBottomLimit = 1;
    public static final int firstStageTopLimit = 0;

    // Second stage elevator objects
    public static final int secondStage1 = 5;
    public static final int secondStage2 = 4;
    public static final int secondStageBottomLimit = 2;
    public static final int secondStageTopLimit = 3;

    // Intake objects
    public static final int intakeLeft = 1;
    public static final int intakeRight = 2;

    // Intake/Claw objects
    public static final int clawPistonPort1 = 0;//formerly 1--having electrical problems so Flipping claw and buddy
    public static final int clawPistonPort2 = 7;//formerly 6
    public static final int pinchPistonPort1 = 2;
    public static final int pinchPistonPort2 = 5;

    // Buddy bar objects
    public static final int buddyBarPistonPort1 = 1;//formerly 0
    public static final int buddyBarPistonPort2 = 6;//formerly 7
}
