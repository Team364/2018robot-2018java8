package frc.team364.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.*;

public class CloseScale3Cube extends CommandGroup {

    public CloseScale3Cube() {
        //TODO: Add sensors to IntakeSystem to determine if we are holding a cube
        addSequential(new DriveStraightForCounts(15000, false)); // Drive to scale
        addSequential(new TurnToHeading(-22)); // Turn towards scale
        addParallel(new LiftBothStages()); // Lift cube
        addSequential(new DriveStraightForCounts(3500, false)); // Drive to scale dropoff point
        addSequential(new WaitCommand(0.5));
        addSequential(new FlipClawDown()); // Drop claw for cube placement
        addSequential(new WaitCommand(0.1));
        addSequential(new OuttakeCube()); // Outtake cube
        addParallel(new FlipClawUp()); // Lift claw back up 
        addParallel(new DropBothStages()); // Drop lift
        addSequential(new TurnToHeading(-120)); // Total -155 deg
        addSequential(new FlipClawDown()); // Drop claw for intake
        addParallel(new OpenPincher()); // Open picher for cube intake
        addParallel(new IntakeCube()); // Intake cube while driving forward
        addSequential(new DriveStraightForCounts(2600, false)); // Drive forward
        addSequential(new ClosePincher()); // Pinch cube
        addSequential(new WaitCommand(0.5));
        addParallel(new FlipClawUp()); // Flip cube up
        addSequential(new DriveStraightForCounts(2500, true)); // Back up to previous position
        addParallel(new LiftBothStages()); // Lift cube
        addSequential(new TurnToHeading(120)); // Now back at -35
        addSequential(new FlipClawDown()); // Flip claw back up
        addSequential(new OuttakeCube()); // Spit out cub
        addParallel(new FlipClawUp());
        addParallel(new DropBothStages()); // Drop lift
        addSequential(new TurnToHeading(-95));
        addSequential(new FlipClawDown());
        addParallel(new OpenPincher());
        addParallel(new IntakeCube());
        addSequential(new DriveStraightForCounts(4200, false));
        addSequential(new ClosePincher());
        addSequential(new WaitCommand(0.5));
        addParallel(new FlipClawUp());
        addSequential(new DriveStraightForCounts(4200, true));
        addParallel(new LiftBothStages());
        addSequential(new TurnToHeading(80));
        addSequential(new FlipClawDown());
        addSequential(new OuttakeCube());
        addParallel(new FlipClawUp());
        addParallel(new DropBothStages());
    }
}