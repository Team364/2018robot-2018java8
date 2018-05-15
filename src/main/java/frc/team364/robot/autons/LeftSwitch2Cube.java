package frc.team364.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.auto.claw.*;
import frc.team364.robot.commands.auto.drive.*;
import frc.team364.robot.commands.auto.intake.*;
import frc.team364.robot.commands.auto.lift.*;
import frc.team364.robot.commands.auto.misc.*;

public class LeftSwitch2Cube extends CommandGroup {

    public LeftSwitch2Cube() {
        //TODO: Add sensors to IntakeSystem to determine if we are holding a cube
        addSequential(new DriveStraightForCounts(1500, false, false));
        addSequential(new TurnToHeading(-50));
        addSequential(new DriveStraightForCounts(8000, false, false));
        addSequential(new TurnToHeading(50));
        addSequential(new LiftSecondStage());
        addParallel(new FlipClawDown());
        addSequential(new DriveStraightForCounts(1500, false, false));
        addSequential(new OuttakeCube());
        addSequential(new FlipClawUp());
        addSequential(new DriveStraightForCounts(1500, true, false));
        addParallel(new DropSecondStage());
        addSequential(new FlipClawDown());
        addSequential(new OpenPincher());
        addSequential(new TurnToHeading(90));
        addParallel(new IntakeCube());
        addSequential(new DriveStraightForCounts(2500, false, false));
        addSequential(new ClosePincher());
        addSequential(new IntakeCube());
        addSequential(new DriveStraightForCounts(2000, true, false));
        addParallel(new LiftSecondStage());
        addSequential(new TurnToHeading(-80));
        addSequential(new DriveStraightForCounts(1000, false, false));
        addSequential(new FlipClawDown());
        addSequential(new OuttakeCube());
        addSequential(new FlipClawUp());
        addParallel(new DropSecondStage());
        addSequential(new DriveStraightForCounts(1000, true, false));
    }
}
