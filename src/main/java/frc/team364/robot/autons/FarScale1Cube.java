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
        addSequential(new TurnToHeading(-75));
        addSequential(new WaitCommand(1));
        addSequential(new DriveStraightForCounts(15000, false, true));
        addSequential(new TurnToHeading(90));
        addSequential(new DriveStraightForCounts(2000, false, false));
        addSequential(new LiftBothStages());
        addSequential(new FlipClawDown());
        addSequential(new OuttakeCube());
        addParallel(new FlipClawUp());
        addSequential(new DropBothStages());
        addParallel(new DriveStraightForCounts(2500, true, false));
    }
}