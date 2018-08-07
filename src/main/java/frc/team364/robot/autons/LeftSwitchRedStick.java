package frc.team364.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team364.robot.commands.auto.claw.*;
import frc.team364.robot.commands.auto.drive.*;
import frc.team364.robot.commands.auto.intake.*;
import frc.team364.robot.commands.auto.lift.*;
import frc.team364.robot.commands.auto.misc.*;

public class LeftSwitchRedStick extends CommandGroup {
    /**
     * <p>1 move away from wall 
     * <p>2 Turn Left
     * <p>3 Drive Foward
     * <p>4 Turn towards left switch
     * <p>5 Lift Second Stage as Robot Drives
     * <p>6 Drive towards left switch
     * <p>7 Flip Claw Down
     * <p>8 Shoot Cube
     * <p>9 Drop Lift as te robt backs up
     * <p>10 Back up away from switch
     * <p>11 Turn towards second cube/cube stack
     * <p>12 Drive into cube and intake
     * <P>13 Back away from cube stack intaking
     * <p>14 Turn towards Switch
     * <P>15 Lift Second stage on lift
     * <p>16 Drive towards switch
     * <p>17 Outtake Cube into switch
     * <p>18 drop second stage as robot backs up
     * <p>19 back away from switch
     */

    public LeftSwitchRedStick() {
       addSequential(new DriveStraightForCounts(1500, false, false));//1
       addSequential(new TurnToHeading(-23));//2
       addSequential(new DriveStraightForCounts(5500, false, false));//3
       addSequential(new TurnToHeading(26));//4
       addParallel(new LiftSecondStage());//5
       addSequential(new DriveStraightForCounts(3800, false, false));//6
       addSequential(new FlipClawDown());//7
       addSequential(new OuttakeCube());//8
       addParallel(new DropSecondStage());//9
       addSequential(new DriveStraightForCounts(1500, true, false));//10
       //SecondCube
       addSequential(new TurnToHeading(34));//11
       addSequential(new DriveStraightForCountsIntake(3000, false, false));//12
       addSequential(new WaitCommand(0.2));//12
       addSequential(new DriveStraightForCountsIntake(2400, true, false));//13
       addSequential(new TurnToHeading(-33));//14
       addSequential(new ResetEncoders());//14
       addSequential(new LiftSecondStageHalfway());//15
       addSequential(new ResetEncoders());//15
       addSequential(new DriveStraightForCounts(2000, false, false));//16
       addSequential(new OuttakeCube());//17
       addParallel(new DropSecondStage());//18
       addSequential(new DriveStraightForCounts(1500, true, false));//19

    }
}
