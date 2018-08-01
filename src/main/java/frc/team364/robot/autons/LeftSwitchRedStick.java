package frc.team364.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.auto.claw.*;
import frc.team364.robot.commands.auto.drive.*;
import frc.team364.robot.commands.auto.intake.*;
import frc.team364.robot.commands.auto.lift.*;
import frc.team364.robot.commands.auto.misc.*;

public class LeftSwitchRedStick extends CommandGroup {

    public LeftSwitchRedStick() {
       addSequential(new DriveStraightForCounts(1500, false, false));
       addSequential(new TurnToHeading(-26));
       addSequential(new DriveStraightForCounts(5200, false, false));
       addSequential(new TurnToHeading(20));
       addParallel(new LiftSecondStage());
       addSequential(new DriveStraightForCounts(4200, false, false));
       addSequential(new FlipClawDown());
       addSequential(new OuttakeCube());
       addParallel(new DropSecondStage());
       addSequential(new DriveStraightForCounts(1500, true, false));
       //SecondCube
       addSequential(new TurnToHeading(37));
       addSequential(new DriveStraightForCountsIntake(2400, false, false));
       addSequential(new WaitCommand(0.2));
       addSequential(new DriveStraightForCountsIntake(3000, true, false));
       addSequential(new TurnToHeading(-33));
       addParallel(new LiftSecondStage());
       addSequential(new ResetEncoders());
       addSequential(new DriveStraightForCounts(2000, false, false));
       addSequential(new OuttakeCube());
       addParallel(new DropSecondStage());
       addSequential(new DriveStraightForCounts(1500, true, false));

    }
}
