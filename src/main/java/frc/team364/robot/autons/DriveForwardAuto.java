package frc.team364.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.auto.drive.*;

public class DriveForwardAuto extends CommandGroup {

    public DriveForwardAuto() {

        addSequential(new DriveforPower(1, 3));
        
    }

}