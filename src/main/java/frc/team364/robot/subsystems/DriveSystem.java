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
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;


/**
 * @author Landon Haugh
 * @version v1.0
 */ 
public class DriveSystem extends Subsystem {

    public TalonSRX leftFront;
    public TalonSRX leftRear;
    public TalonSRX rightFront;
    public TalonSRX rightRear;
    public DoubleSolenoid shifter;
    public AHRS navX;
    public PIDCalc pid;
    public double pidOutput;
    public Pathfinder pathfinder;

    /**
     * DriveSystem()
     * Constructor for the DriveSystem class
     * Maps all TalonSRX's and configures settings
     * Maps all pistons
     * Creates PID objects
     * Initializes navX
     * Initializes Pathfinder class
     */ 
    public DriveSystem() {
        leftFront = new TalonSRX(RobotMap.leftFrontDrive);
        leftRear = new TalonSRX(RobotMap.leftRearDrive);
        rightFront = new TalonSRX(RobotMap.rightFrontDrive);
        rightRear = new TalonSRX(RobotMap.rightRearDrive);

        shifter = new DoubleSolenoid(RobotMap.shifterPort1, RobotMap.shifterPort2);

	// Set the front drive motors to follow the rear
        leftFront.follow(leftRear);
        rightFront.follow(rightRear);

	// Config PF on left side
        leftRear.config_kP(0, 0.25, 100);
        leftRear.config_kF(0, 1, 100);

	// Config PF on right side
        rightRear.config_kP(0, 0.25, 100);
        rightRear.config_kF(0, 1, 100);

	// Init the navX, Pathfinder, and PIDCalc
        navX = new AHRS(SPI.Port.kMXP);
        pathfinder = new Pathfinder();
        pid = new PIDCalc(0.03, 0, 0, 0);
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
        rightRear.set(ControlMode.PercentOutput, right);
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
     * getLeftEncoderPosition()
     * @return returns the left encoder position in counts
     */ 
    public int getLeftEncoderPosition() {
        return leftRear.getSelectedSensorPosition(0);
    }

    /**
     * getRightEncoderPosition()
     * @return returns the right encoder position in counts
     */ 
    public int getRightEncoderPosition() {
        return rightRear.getSelectedSensorPosition(0);
    }


    /**
     * getGyroAngle()
     * @return returns the navX angle (yaw)
     */ 
    public double getGyroAngle() {
        return navX.getYaw();
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

    /**
     * driveStraightToEcnoderCounts()
     * Uses the TalonSRX PID to drive to a certain number of counts
     * @param counts specify encoder counts to drive to
     */ 
    public void driveStraightToEncoderCounts(int counts) {
        leftRear.set(ControlMode.Position, counts);
        rightRear.set(ControlMode.Position, counts);
    }

    /**
     * withinEncoderRange()
     * Checks if the drivetrain has reached the target counts
     * @param counts counts to reach
     * @return returns true if counts is within 10 of wanted counts
     */ 
    public boolean withinEncoderCountRange(int counts) {

        double leftRearPos = leftRear.getSelectedSensorPosition(0);
        double rightRearPos = rightRear.getSelectedSensorPosition(0);

        return leftRearPos >= (counts - 10) && leftRearPos <= (counts + 10) && rightRearPos >= (counts - 10) && rightRearPos <= (counts + 10);

    }

    /**
     * resetHeading()
     * Resets navX gyro heading
     */ 
    public void resetHeading() {
        navX.reset();
    }

    /**
     * turnToHeading()
     * Turns the robot to a specified heading using PIDCalc and the navX
     * @param heading heading to turn to
     */ 
    public void turnToHeading(double heading) {
        pidOutput = pid.calculateOutput(heading, navX.getYaw());
        leftRear.set(ControlMode.PercentOutput, pidOutput);
        rightRear.set(ControlMode.PercentOutput, -pidOutput);
    }

    /**
     * reachedHeading()
     * Determines if the drivetrain has reached the target heading
     * @param heading heading to be reached
     * @return returns true if the robot is within 2 degrees of wanted heading
     */ 
    public boolean reachedHeading(double heading) {
        if(navX.getYaw() <= (heading + 1) && navX.getYaw() >= (heading - 1)) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * shiftHigh()
     * Shifts the drivetrain into high gear
     */ 
    public void shiftHigh() {
        shifter.set(DoubleSolenoid.Value.kForward);
    }

    /**
     * shiftLow()
     * Shifts the drivetrain into low gear
     */ 
    public void shiftLow() {
        shifter.set(DoubleSolenoid.Value.kReverse);
    }

    /**
     * noShiftInput()
     * Leaves the shifters where they're at
     */ 
    public void noShiftInput() {
        shifter.set(DoubleSolenoid.Value.kOff);
    }

    /**
     * configTrajectory()
     * Creates a trajectory based on waypoints specified
     * Takes a long time to run, use a motion profile generator and load files from roboRIO instead
     * @param points waypoints to follow
     * @return returns a TankModifier based off our drivetrain
     */ 
    public TankModifier configTrajectory(Waypoint[] points) {
        Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.05, 1.7, 2.0, 60.0);
        Trajectory trajectory = Pathfinder.generate(points, config);
        // 2.16 feet in meters = 0.658368
        TankModifier modifier = new TankModifier(trajectory).modify(0.658368);
        return modifier;
    }

}
