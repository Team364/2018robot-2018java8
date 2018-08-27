package frc.team364.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.auto.drive.*;

public class FollowPathAuto extends CommandGroup {

    public FollowPathAuto() {
        // We use the _detailed files from the generator. These work with Jaci's Pathfinder.
        addSequential(new FollowPath("/home/lvuser/mp_left_detailed.csv", "home/lvuser/mp_right_detailed.csv"));
        //addSequential(new OuttakeCube());
    }

}