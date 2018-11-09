package frc.team364.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.auto.drive.*;
import frc.team364.robot.commands.auto.intake.*;
import frc.team364.robot.commands.auto.lift.*;

public class RightSwitch2Cube extends CommandGroup {

    public RightSwitch2Cube() {
        
        addSequential(new DriveStraightForCounts(1500, false, false));
        addSequential(new TurnToHeading(25));
        addSequential(new DriveStraightForCounts(5000, false, false));
        addSequential(new TurnToHeading(-25));
        addSequential(new DriveStraightForCounts(1000, false, false));
        addParallel(new LiftSecondStage());
        addSequential(new DriveStraightForCounts(2000, false, false));
        addSequential(new OuttakeCube());
        addParallel(new DropSecondStage());
        addSequential(new DriveStraightForCounts(1000, true, false));
        addSequential(new TurnToHeading(-90));
        addSequential(new DriveStraightForCounts(1000, false, false));
        addSequential(new IntakeCube());
        addSequential(new DriveStraightForCounts(1000, true, false));
        addParallel(new LiftSecondStage());
        addSequential(new TurnToHeading(90));
        addSequential(new DriveStraightForCounts(1000, false, false));
        addSequential(new OuttakeCube());
        addSequential(new DriveStraightForCounts(1000, true, false));
    }
}
