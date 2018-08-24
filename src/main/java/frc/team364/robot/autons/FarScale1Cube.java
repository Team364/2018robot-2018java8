package frc.team364.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.auto.claw.*;
import frc.team364.robot.commands.auto.drive.*;
import frc.team364.robot.commands.auto.intake.*;
import frc.team364.robot.commands.auto.lift.*;
import frc.team364.robot.commands.auto.misc.*;

public class FarScale1Cube extends CommandGroup {

    public FarScale1Cube() {
        
        addSequential(new DriveStraightLimited(15600, false, true));
        addSequential(new ResetEncoders());
        addSequential(new StopMotors());
        addSequential(new TurnToHeading(-55));
        addSequential(new WaitCommand(0.3));
        addSequential(new DriveStraightLimited(15500, false, true));
        addSequential(new TurnToHeading(70));
        addSequential(new ResetEncoders());
        addSequential(new LiftBothStages(true));
        addSequential(new StopMotors());
        addSequential(new DriveforPower(0.3, 0.3));
        addSequential(new FlipClawDown());
        addSequential(new OuttakeCube());
        addParallel(new FlipClawUp());
        addSequential(new DropBothStages(true));
        
        
    }
}