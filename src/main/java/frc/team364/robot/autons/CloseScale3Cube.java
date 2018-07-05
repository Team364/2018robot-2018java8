package frc.team364.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.auto.claw.*;
import frc.team364.robot.commands.auto.drive.*;
import frc.team364.robot.commands.auto.intake.*;
import frc.team364.robot.commands.auto.lift.*;
import frc.team364.robot.commands.auto.misc.*;

public class CloseScale3Cube extends CommandGroup {

    public CloseScale3Cube() {
        //TODO: Add sensors to IntakeSystem to determine if we are holding a cube
        addSequential(new DriveStraightForCounts(15000, false, true)); // Drive to scale
        addSequential(new TurnToHeading(-27)); // Turn towards scale--was -22
        addParallel(new LiftBothStages(true)); // Lift cube
        addSequential(new DriveStraightForCounts(3500, false, false)); // Drive to scale dropoff point
        addSequential(new WaitCommand(0.3));
        addSequential(new FlipClawDown()); // Drop claw for cube placement
        addSequential(new WaitCommand(0.1));
        addSequential(new OuttakeCube()); // Outtake cube
        addParallel(new FlipClawUp()); // Lift claw back up 
        addParallel(new DropBothStages(true)); // Drop lift
        addSequential(new TurnToHeading(-120)); // Total -155 deg
        addSequential(new FlipClawDown()); // Drop claw for intake
        addSequential(new OpenPincher()); // Open picher for cube intake
        addParallel(new IntakeCube()); // Intake cube while driving forward
        addSequential(new ResetEncoders());
        addSequential(new DriveStraightForCounts(2600, false, false)); // Drive forward
        addSequential(new ClosePincher()); // Pinch cube
        addSequential(new WaitCommand(0.5));
        addParallel(new FlipClawUp()); // Flip cube up
        addSequential(new DriveStraightForCounts(2500, true, false)); // Back up to previous position
        addParallel(new LiftBothStages(true)); // Lift cube
        addSequential(new TurnToHeading(100)); // Now back at -35 ---was 120
        addSequential(new FlipClawDown()); // Flip claw back up
        addSequential(new OuttakeCube()); // Spit out cub
        addParallel(new FlipClawUp());
        addParallel(new DropBothStages(true)); // Drop lift
        addSequential(new TurnToHeading(-95));///Was -95
        addSequential(new FlipClawDown());
        addParallel(new OpenPincher());
        addParallel(new IntakeCube());
        addSequential(new DriveStraightForCounts(4200, false, false));
        addSequential(new ClosePincher());
        addSequential(new WaitCommand(0.5));
        addParallel(new FlipClawUp());
        addSequential(new DriveStraightForCounts(4200, true, false));
        addParallel(new LiftBothStages(true));
        addSequential(new TurnToHeading(80));
        addSequential(new FlipClawDown());
        addSequential(new OuttakeCube());
        addParallel(new FlipClawUp());
        addParallel(new DropBothStages(true));
    }
}