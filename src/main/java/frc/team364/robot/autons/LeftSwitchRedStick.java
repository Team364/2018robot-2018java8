package frc.team364.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.auto.claw.*;
import frc.team364.robot.commands.auto.drive.*;
import frc.team364.robot.commands.auto.intake.*;
import frc.team364.robot.commands.auto.lift.*;
import frc.team364.robot.commands.auto.misc.*;

public class LeftSwitchRedStick extends CommandGroup {

    public LeftSwitchRedStick() {
       addSequential(new DriveStraightForCounts(1500, false, false));//Move away from wall
       addSequential(new TurnToHeading(-26));//Turn left
       addSequential(new DriveStraightForCounts(5000, false, false));//Drive forward
       addSequential(new TurnToHeading(20));//Turn towards switch
       addParallel(new LiftSecondStage());
       addSequential(new DriveStraightForCounts(2800, false, false));//Drive to switch
       addSequential(new FlipClawDown());
       addSequential(new OuttakeCube());
       addParallel(new DropSecondStage());
       addSequential(new DriveStraightForCounts(1500, true, false));//Back up
       //SecondCube
       addSequential(new TurnToHeading(37));//Turn towards second cube
       addSequential(new DriveStraightForCountsIntake(3000, false, false));//Drive into cube
       addSequential(new WaitCommand(0.2));
       addSequential(new ShortIntakeCube());//Intake cube
       addSequential(new DriveStraightForCountsIntake(2000, true, false));//Back up from Cube Stack
       addSequential(new TurnToHeading(-33));//Turn Towards switch
       addSequential(new ResetEncoders());
       addParallel(new LiftSecondStageHalfway());
       addSequential(new DriveStraightForCounts(2000, false, false));
       addSequential(new OuttakeCube());
       addParallel(new DropSecondStage());
       addSequential(new DriveStraightForCounts(1500, true, false));

    }
}
