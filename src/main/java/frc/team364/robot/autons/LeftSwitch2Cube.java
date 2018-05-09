package frc.team364.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.DriveStraightForCounts;
import frc.team364.robot.commands.LiftSecondStage;
import frc.team364.robot.commands.DropSecondStage;
import frc.team364.robot.commands.TurnToHeading;

public class LeftSwitch2Cube extends CommandGroup {

    public LeftSwitch2Cube() {
        //TODO: Implement OuttakeCube() and IntakeCube() commands
        //TODO: Tune encoder counts and heading arguments
        //TODO: Add sensors to IntakeSystem to determine if we are holding a cube
        addSequential(new DriveStraightForCounts(1500));
        addSequential(new TurnToHeading(-50));
        addSequential(new DriveStraightForCounts(8000));
        addSequential(new TurnToHeading(50));
        addSequential(new DriveStraightForCounts(1000));
        //addParallel(new LiftSecondStage());
        //addSequential(new DriveStraightForCounts(2000));
        //addSequential(new OuttakeCube());
        //addParallel(new DropSecondStage());
        //addSequential(new DriveStraightForCounts(-1000));
        //addSequential(new TurnToHeading(-90));
        //addSequential(new DriveStraightForCounts(1000));
        //addSequential(new IntakeCube());
        //addSequential(new DriveStraightForCounts(-1000));
        //addParallel(new LiftSecondStage());
        //addSequential(new TurnToHeading(90));
        //addSequential(new DriveStraightForCounts(1000));
        //addSequential(new OuttakeCube());
        //addSequential(new DriveStraightForCounts(-1000));
    }
}
