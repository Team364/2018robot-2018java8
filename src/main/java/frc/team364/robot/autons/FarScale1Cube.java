package frc.team364.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.*;

public class FarScale1Cube extends CommandGroup {

    public FarScale1Cube() {
        //TODO: Add sensors to IntakeSystem to determine if we are holding a cube
        addSequential(new DriveStraightForCounts(16000, false));
        addSequential(new TurnToHeading(-80));
        addSequential(new DriveStraightForCounts(15000, false));
        addSequential(new TurnToHeading(90));
        addSequential(new DriveStraightForCounts(2000, false));
        addSequential(new LiftBothStages());
        addSequential(new FlipClawDown());
        addSequential(new OuttakeCube());
        addParallel(new FlipClawUp());
        addSequential(new DropBothStages());
        addParallel(new DriveStraightForCounts(2500, true));
    }
}