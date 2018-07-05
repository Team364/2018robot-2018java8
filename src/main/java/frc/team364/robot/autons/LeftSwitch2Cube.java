package frc.team364.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.auto.claw.*;
import frc.team364.robot.commands.auto.drive.*;
import frc.team364.robot.commands.auto.intake.*;
import frc.team364.robot.commands.auto.lift.*;
import frc.team364.robot.commands.auto.misc.*;

public class LeftSwitch2Cube extends CommandGroup {

    public LeftSwitch2Cube() {
        addSequential(new ShiftUp());
        addSequential(new DriveStraightForCounts(1500, false, false));//addSequential(new DriveStraightForCounts(1500, false, false));
        addSequential(new TurnToHeading(-50));
        addSequential(new DriveStraightForCounts(7200, false, false));
        addParallel(new TurnToHeading(50));
        addSequential(new LiftBothStages(false));
		addSequential(new DriveStraightForCounts(3000, false, false));
        addSequential(new WaitCommand(0.1));
		addSequential(new FlipClawDown());
		addSequential(new OuttakeCube());
        addParallel(new FlipClawUp());
        addSequential(new DropBothStages(false));
		addParallel(new DriveStraightForCounts(1000, true, false));
        addSequential(new TurnToHeading(65));
        addSequential(new FlipClawDown());
        addSequential(new OpenPincher());
        addSequential(new WaitCommand(0.6));
        addSequential(new DriveStraightForCounts(4000, false, false));
        addParallel(new IntakeCube());
        addSequential(new ClosePincher()); // Pinch cube
        addSequential(new WaitCommand(0.4));
        addSequential(new DriveStraightForCounts(3000, true, false));
        addSequential(new LiftBothStages(false));
        addSequential(new LiftBothStages(false));
        addSequential(new TurnToHeading(-80));
        addSequential(new WaitCommand(0.2));
        addSequential(new FlipClawUp());
        addSequential(new DriveStraightForCounts(1500, true, false));
	 	addSequential(new FlipClawDown());
		addSequential(new OuttakeCube());
        addSequential(new WaitCommand(0.2));
        addParallel(new FlipClawUp());
        addSequential(new DropBothStages(false));
        addSequential(new DropBothStages(false));
        addSequential(new FlipClawDown());
        addSequential(new DriveStraightForCounts(2000, true, false));
        addSequential(new TurnToHeading(45));
        addParallel(new OpenPincher());
        addSequential(new DriveStraightForCounts(5000, false, false));
        addParallel(new IntakeCube());
        addSequential(new ClosePincher());
        addSequential(new DriveStraightForCounts(2000, true, false));
        addParallel(new IntakeCube());  
		
    }
}
