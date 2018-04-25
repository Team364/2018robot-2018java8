package frc.team364.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.FollowPath;
import frc.team364.robot.commands.LiftSecondStage;

public class FollowPathAuto extends CommandGroup {

    public FollowPathAuto() {
        addSequential(new FollowPath("/home/lvuser/mp_left.csv", "home/lvuser/mp_right.csv"));
        addSequential(new LiftSecondStage());
        //addSequential(new OuttakeCube());
    }

}