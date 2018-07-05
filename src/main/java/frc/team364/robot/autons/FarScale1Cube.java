package frc.team364.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.auto.claw.*;
import frc.team364.robot.commands.auto.drive.*;
import frc.team364.robot.commands.auto.intake.*;
import frc.team364.robot.commands.auto.lift.*;
import frc.team364.robot.commands.auto.misc.*;

public class FarScale1Cube extends CommandGroup {

    public FarScale1Cube() {
        //TODO: Add sensors to IntakeSystem to determine if we are holding a cube
        addSequential(new DriveStraightForCounts(16000, false, true));
        addSequential(new ResetEncoders());
        addSequential(new TurnToHeading(-75));
        addSequential(new WaitCommand(0.3));
        addSequential(new DriveStraightForCounts(14500, false, false));
        addSequential(new TurnToHeading(70));
        addSequential(new ResetEncoders());
        addSequential(new DriveStraightForCounts(2000, false, false));
        addSequential(new LiftBothStages(true));
        addSequential(new FlipClawDown());
        addSequential(new OuttakeCube());
        addParallel(new FlipClawUp());
        addSequential(new DropBothStages(true));
        addSequential(new TurnToHeading(-170));
        addParallel(new FlipClawDown());
        addSequential(new ResetEncoders());
        addSequential(new DriveStraightForCountsIntake(3500, false, false));
        addSequential(new FlipClawUp());
        addSequential(new TurnToHeading(170));
        addSequential(new ResetEncoders());
        addParallel(new LiftBothStages(true));
        addSequential(new DriveStraightForCounts(3000, false, false));
        addSequential(new FlipClawDown());
        addSequential(new OuttakeCube());
        addParallel(new FlipClawUp());
        addSequential(new DropBothStages(true));
        
    }
}