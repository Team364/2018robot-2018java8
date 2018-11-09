package frc.team364.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.auto.claw.*;
import frc.team364.robot.commands.auto.drive.*;
import frc.team364.robot.commands.auto.intake.*;
import frc.team364.robot.commands.auto.misc.*;

public class RightSwitch3Cube extends CommandGroup {

    public RightSwitch3Cube() {
        addSequential(new ResetEncoders());
        //Drive to Left Switch
        addSequential(new DriveStraightForCounts(1500, false, false));
        addSequential(new TurnToHeading(21));
        addSequential(new WaitCommand(0.2));
       addSequential(new DriveStraightForCounts(5200, false, false));
       //FlipShoot
       addSequential(new WaitCommand(0.2));
       addSequential(new FlipClawDown());
       addSequential(new OuttakeCube());
       addSequential(new FlipClawUp());
      //Get Second Cube
       addSequential(new TurnToHeading(-64));
       addSequential(new FlipClawDown());
       addSequential(new ResetEncoders());
       addSequential(new WaitCommand(0.2));
       addSequential(new DriveStraightForCountsIntake(1400, false, false));
       addSequential(new ResetEncoders());
       addSequential(new WaitCommand(0.2));
       addSequential(new DriveStraightForCountsIntake(1600, true, false));
       addSequential(new FlipClawUp());
       addSequential(new TurnToHeading(50)); 
       addSequential(new ResetEncoders());
       addSequential(new DriveStraightForCounts(1000, false, false));
       //FlipShoot
       addSequential(new WaitCommand(0.2));
       addSequential(new FlipClawDown());
       addSequential(new OuttakeCube());
       addSequential(new FlipClawUp());
       //Get Third Cube
       addSequential(new WaitCommand(0.2));
       addSequential(new DriveStraightForCounts(1500, true, false));
       addSequential(new TurnToHeading(-65)); 
       addParallel(new FlipClawDown());
       addSequential(new ResetEncoders());
       addSequential(new WaitCommand(0.2));
       addSequential(new OpenPincher());
       addSequential(new WaitCommand(0.2));
       addSequential(new DriveStraightForCountsIntake(2400, false, false));
       addSequential(new ClosePincher());
       addSequential(new WaitCommand(0.2));
       addSequential(new ResetEncoders());
       addSequential(new WaitCommand(0.2));
       addSequential(new DriveStraightForCountsIntake(1600, true, false));
       addSequential(new WaitCommand(0.1));
       addSequential(new FlipClawUp());
       addSequential(new TurnToHeading(60)); 
       addSequential(new ResetEncoders());
       addSequential(new DriveStraightForCounts(1500, false, false));
       //FlipShoot
       addSequential(new WaitCommand(0.2));
       addSequential(new FlipClawDown());
       addSequential(new OuttakeCube());
       addSequential(new FlipClawUp());

    }
}
