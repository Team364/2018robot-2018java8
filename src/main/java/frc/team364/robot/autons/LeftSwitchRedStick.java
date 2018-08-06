package frc.team364.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.auto.claw.*;
import frc.team364.robot.commands.auto.drive.*;
import frc.team364.robot.commands.auto.intake.*;
import frc.team364.robot.commands.auto.lift.*;
import frc.team364.robot.commands.auto.misc.*;

public class LeftSwitchRedStick extends CommandGroup {

    public LeftSwitchRedStick() {
       addSequential(new DriveStraightForCounts(1500, false, false));
       addSequential(new TurnToHeading(-22));
       addSequential(new DriveStraightForCounts(5000, false, false));
       addSequential(new TurnToHeading(20));
       addParallel(new LiftSecondStage());
       addSequential(new DriveStraightForCounts(2500, false, false));
       addSequential(new FlipClawDown());
       addSequential(new OuttakeCube());
       addParallel(new DropSecondStage());
       addSequential(new DriveStraightForCounts(1500, true, false));
       //SecondCube
       addSequential(new TurnToHeading(37));
       addSequential(new DriveStraightForCountsIntake(3000, false, false));
       addSequential(new WaitCommand(0.2));
       addSequential(new ShortIntakeCube());
       addSequential(new DriveStraightForCountsIntake(2000, true, false));
       addSequential(new TurnToHeading(-33));
       addSequential(new ResetEncoders());
       addParallel(new LiftSecondStageHalfway());
       addSequential(new DriveStraightForCounts(2000, false, false));
       addSequential(new OuttakeCube());
       addParallel(new DropSecondStage());
       addSequential(new DriveStraightForCounts(1500, true, false));

    }
}
