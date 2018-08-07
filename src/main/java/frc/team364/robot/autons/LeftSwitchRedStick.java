package frc.team364.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.auto.claw.*;
import frc.team364.robot.commands.auto.drive.*;
import frc.team364.robot.commands.auto.intake.*;
import frc.team364.robot.commands.auto.lift.*;
import frc.team364.robot.commands.auto.misc.*;

public class LeftSwitchRedStick extends CommandGroup {
    /**
     * <p>1 move away from wall 
     * <p>2 Turn Left
     * <p>3 Drive Foward
     * <p>4 Turn towards left switch
     * <p>5 Lift Second Stage as Robot Drives
     * <p>6 Drive towards left switch
     * <p>7 Flip Claw Down
     * <p>8 Shoot Cube
     * <p>9 
     */

    public LeftSwitchRedStick() {
       addSequential(new DriveStraightForCounts(1500, false, false));//1
       addSequential(new TurnToHeading(-23));//2
       addSequential(new DriveStraightForCounts(5500, false, false));//3
       addSequential(new TurnToHeading(26));//4
       addParallel(new LiftSecondStage());//5
       addSequential(new DriveStraightForCounts(3800, false, false));//6
       addSequential(new FlipClawDown());//7
       addSequential(new OuttakeCube());//8
       addParallel(new DropSecondStage());//9
       addSequential(new DriveStraightForCounts(1500, true, false));//Back up
       //SecondCube
       addSequential(new TurnToHeading(34));//Turn towards second cube
       addSequential(new DriveStraightForCountsIntake(3000, false, false));//Drive into cube
       addSequential(new WaitCommand(0.2));
       addSequential(new ShortIntakeCube());//Intake cube
       addSequential(new DriveStraightForCountsIntake(2400, true, false));//Back up from Cube Stack
       addSequential(new TurnToHeading(-33));//Turn Towards switch
       addSequential(new ResetEncoders());
       addSequential(new LiftSecondStageHalfway());
       addSequential(new ResetEncoders());
       addSequential(new DriveStraightForCounts(2000, false, false));
       addSequential(new OuttakeCube());
       addParallel(new DropSecondStage());
       addSequential(new DriveStraightForCounts(1500, true, false));

    }
}
