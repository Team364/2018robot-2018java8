package frc.team364.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team364.robot.Robot;

public class DriveStraightForCounts extends Command {

    private int driveCounts;

    public DriveStraightForCounts(int counts) {
        requires(Robot.driveSystem);
        driveCounts = counts;
    }

    @Override
    protected void initialize() {
        Robot.driveSystem.resetEncoders();
        Robot.driveSystem.stop();
    }

    @Override
    protected void execute() {
        System.out.println(Robot.driveSystem.getLeftEncoderPosition());
        System.out.println(Robot.driveSystem.getRightEncoderPosition());
        Robot.driveSystem.driveStraightToEncoderCounts(driveCounts);
    }

    @Override
    protected boolean isFinished() {
        if(Robot.driveSystem.withinEncoderCountRange(driveCounts) == true) {
            return true;   
        } else {
            return false;
        }
    }

    @Override
    protected void end() {
        Robot.driveSystem.stop();
    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}
