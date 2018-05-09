package frc.team364.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.*;

public class LeftSwitch2Cube extends CommandGroup {

    public LeftSwitch2Cube() {
        //TODO: Add sensors to IntakeSystem to determine if we are holding a cube
        addSequential(new DriveStraightForCounts(1500));
        addSequential(new TurnToHeading(-50));
        addSequential(new DriveStraightForCounts(8000));
        addSequential(new TurnToHeading(50));
        addParallel(new LiftSecondStage());
        addParallel(new FlipClawDown());
        addSequential(new DriveStraightForCounts(1000));
        addSequential(new OuttakeCube());
        addParallel(new DropSecondStage());
        addSequential(new DriveStraightForCounts(-1000));
        addParallel(new OpenPincher());
        addSequential(new TurnToHeading(-90));
        addSequential(new DriveStraightForCounts(1000));
        addSequential(new IntakeCube());
        addParallel(new ClosePincher());
        addParallel(new IntakeCube());
        addSequential(new DriveStraightForCounts(-1000));
        addParallel(new LiftSecondStage());
        addSequential(new TurnToHeading(90));
        addSequential(new DriveStraightForCounts(1000));
        addSequential(new OuttakeCube());
        addParallel(new FlipClawDown());
        addParallel(new DropSecondStage());
        addSequential(new DriveStraightForCounts(-1000));
    }
}
