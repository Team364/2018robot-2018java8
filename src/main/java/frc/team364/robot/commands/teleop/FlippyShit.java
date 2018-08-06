package frc.team364.robot.commands.teleop;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.auto.claw.*;
import frc.team364.robot.commands.auto.drive.*;
import frc.team364.robot.commands.auto.intake.*;
import frc.team364.robot.commands.auto.lift.*;
import frc.team364.robot.commands.auto.misc.*;

public class FlippyShit extends CommandGroup {

    public FlippyShit() {
     /*  FlipShoot -- addSequential(new FlipClawUp()); // Flip claw back up
        addSequential(new WaitCommand(0.25));
        addSequential(new OuttakeCube()); // Spit out cub
        addSequential(new FlipClawDown());*/
        
        addSequential(new FlipClawDown());
        addSequential(new OuttakeCube());
        addSequential(new FlipClawUp());
        System.out.println("flip Sequence has been activated");
    }
}