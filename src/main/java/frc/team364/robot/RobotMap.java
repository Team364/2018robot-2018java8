package frc.team364.robot;

public class RobotMap {

    // Drive objects
    public static final int leftFrontDrive = 3;
    /**
     * has encoder
     */
    public static final int leftRearDrive = 2;
    public static final int rightFrontDrive = 1;
    /**
     * has encoder
     */
    public static final int rightRearDrive = 0;
    public static final int shifterPort1 = 3;
    public static final int shifterPort2 = 4;

    // First stage elevator objects
    public static final int firstStage1 = 4;//was 3
    public static final int firstStage2 = 5;
    public static final int firstStageBottomLimit = 1;
    public static final int firstStageTopLimit = 0;

    // Second stage elevator objects
    public static final int secondStage1 = 6;
    public static final int secondStage2 = 7;
   
    // Intake objects
    public static final int intakeLeft = 8;
    public static final int intakeRight = 9;

    // Intake/Claw objects
    public static final int clawPistonPort1 = 0;//formerly 1--having electrical problems so Flipping claw and buddy
    public static final int clawPistonPort2 = 7;//formerly 6
    public static final int pinchPistonPort1 = 2;
    public static final int pinchPistonPort2 = 5;

  }
