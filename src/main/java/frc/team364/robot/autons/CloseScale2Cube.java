package frc.team364.robot.autons;

import java.sql.DriverPropertyInfo;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.*;

public class CloseScale2Cube extends CommandGroup {

    public CloseScale2Cube() {
        //TODO: Add sensors to IntakeSystem to determine if we are holding a cube
        addSequential(new DriveStraightForCounts(15000, false));
        addSequential(new TurnToHeading(-35));
        addSequential(new DriveStraightForCounts(4500, false));
        addSequential(new FlipClawDown());
        addSequential(new LiftBothStages());
        addSequential(new OuttakeCube());
        addParallel(new FlipClawUp());
        addSequential(new DropBothStages());
        addParallel(new DriveStraightForCounts(2500, true));
    }
}