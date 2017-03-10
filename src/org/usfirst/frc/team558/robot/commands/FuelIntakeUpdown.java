package org.usfirst.frc.team558.robot.commands;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FuelIntakeUpdown extends Command {

    public FuelIntakeUpdown() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.fuelIntake);
        requires(Robot.actuateGear);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.actuateGear.GearSolUp();
    	Robot.fuelIntake.FuelSolDown();
    	Robot.fuelIntake.PullBallsIn(1);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    	Robot.fuelIntake.FuelIntakeStop();
    	
    }
}
