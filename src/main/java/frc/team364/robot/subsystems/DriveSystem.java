package frc.team364.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
<<<<<<< HEAD
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team364.robot.PIDCalc;
import frc.team364.robot.Robot;
import frc.team364.robot.RobotMap;
=======
>>>>>>> c6f78589a35c0b920c2ed32eaf2ab52f328cff1a
import frc.team364.robot.commands.teleop.TeleopDriveCommand;


public class DriveSystem extends Subsystem {

    public TalonSRX leftFront;
    public TalonSRX leftRear;
    public TalonSRX rightFront;
    public TalonSRX rightRear;
<<<<<<< HEAD
    public DoubleSolenoid shifter;
    public AHRS navX;
    public PIDCalc pidNavX;
    public PIDCalc pidLeft;
    public PIDCalc pidRight;
    public PIDCalc pidRampDown;
    public double pidOutputNavX;
    public double pidOutputLeft;
    public double pidOutputRight;
    public double pidOutputRampDown;
    public Pathfinder pathfinder;
=======
>>>>>>> c6f78589a35c0b920c2ed32eaf2ab52f328cff1a

    public DriveSystem() {
        
        leftFront = new TalonSRX(14);
        leftRear = new TalonSRX(15);
        rightFront = new TalonSRX(10);
        rightRear = new TalonSRX(11);

        leftFront.follow(leftRear);
        rightFront.follow(rightRear);
<<<<<<< HEAD

	    // Config PF on left side
        leftRear.config_kP(0, 0.25, 100);
        leftRear.config_kF(0, 1, 100);

	    // Config PF on right side
        rightRear.config_kP(0, 0.25, 100);
        rightRear.config_kF(0, 1, 100);

	    // Init the navX, Pathfinder, and PIDCalc
        navX = new AHRS(SPI.Port.kMXP);
        pathfinder = new Pathfinder();
        pidNavX = new PIDCalc(0.0005, 0.1, 50, 0, "NavX");
        pidLeft = new PIDCalc(0.0005, 0, 0, 0, "Left");
        pidRight = new PIDCalc(0.0005, 0, 0, 0, "Right");
        pidRampDown = new PIDCalc(0.0001, 0, 0, 0, "RampDown");
=======
>>>>>>> c6f78589a35c0b920c2ed32eaf2ab52f328cff1a
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
    public void driveForPower(double power){
        rightRear.set(ControlMode.PercentOutput, power);
        leftRear.set(ControlMode.PercentOutput, power);
    }
    public void stop() {
        leftRear.set(ControlMode.PercentOutput, 0);
        rightRear.set(ControlMode.PercentOutput, 0);
        }
<<<<<<< HEAD
    }
        /**
     * turnToHeading()
     * Slows the robot down
     */ 
    
    public void rampDown() {
        
        pidOutputRampDown = pidNavX.calculateOutput(0, Robot.driveSystem.leftRear.getMotorOutputPercent());
        SmartDashboard.putNumber("PidOutputRamp: ", pidOutputRampDown);
        leftRear.set(ControlMode.PercentOutput, -pidOutputRampDown); //Was multiplied by 0.6
        rightRear.set(ControlMode.PercentOutput, pidOutputRampDown);

}


    /**
     * reachedHeading()
     * Determines if the drivetrain has stopped
     */ 
    public boolean reachedSmoothStop() {
        if(Math.abs(Robot.driveSystem.leftRear.getMotorOutputPercent()) <= 0.01) {
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
    /*
    public TankModifier configTrajectory(Waypoint[] points) {
        Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.05, 1.7, 2.0, 60.0);
        Trajectory trajectory = Pathfinder.generate(points, config);
        // 2.16 feet in meters = 0.658368
        TankModifier modifier = new TankModifier(trajectory).modify(0.658368);
        return modifier;
    }
*/
    public void resetEncoders() {
        leftRear.setSelectedSensorPosition(0, 0, 0);
        rightRear.setSelectedSensorPosition(0, 0, 0);
    }

=======
>>>>>>> c6f78589a35c0b920c2ed32eaf2ab52f328cff1a
}
