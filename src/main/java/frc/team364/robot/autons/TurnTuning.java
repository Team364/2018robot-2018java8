package frc.team364.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.auto.drive.*;

public class TurnTuning extends CommandGroup {

    public TurnTuning() {
       addSequential(new TurnToHeading(90));//2
    }
}
