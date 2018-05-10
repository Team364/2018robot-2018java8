package frc.team364.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.DriveStraightForCounts;
import frc.team364.robot.commands.LiftSecondStage;
import frc.team364.robot.commands.DropSecondStage;
import frc.team364.robot.commands.OuttakeCube;
import frc.team364.robot.commands.IntakeCube;
import frc.team364.robot.commands.TurnToHeading;

public class RightSwitch2Cube extends CommandGroup {

    public RightSwitch2Cube() {
        //TODO: Implement OuttakeCube() and IntakeCube() commands
        //TODO: Tune encoder counts and heading arguments
        //TODO: Add sensors to IntakeSystem to determine if we are holding a cube
        addSequential(new DriveStraightForCounts(1500, false));
        addSequential(new TurnToHeading(25));
        addSequential(new DriveStraightForCounts(5000, false));
        addSequential(new TurnToHeading(-25));
        addSequential(new DriveStraightForCounts(1000, false));
        addParallel(new LiftSecondStage());
        addSequential(new DriveStraightForCounts(2000, false));
        addSequential(new OuttakeCube());
        addParallel(new DropSecondStage());
        addSequential(new DriveStraightForCounts(-1000, true));
        addSequential(new TurnToHeading(-90));
        addSequential(new DriveStraightForCounts(1000, false));
        addSequential(new IntakeCube());
        addSequential(new DriveStraightForCounts(-1000, true));
        addParallel(new LiftSecondStage());
        addSequential(new TurnToHeading(90));
        addSequential(new DriveStraightForCounts(1000, false));
        addSequential(new OuttakeCube());
        addSequential(new DriveStraightForCounts(-1000, true));
    }
}
