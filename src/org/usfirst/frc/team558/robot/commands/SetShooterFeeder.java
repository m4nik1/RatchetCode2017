package org.usfirst.frc.team558.robot.commands;

import org.usfirst.frc.team558.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetShooterFeeder extends Command {

	
	
    public SetShooterFeeder() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	requires(Robot.shooterFeeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double feederAxis = Robot.oi.GetFeeder();
    	if (feederAxis < -.1 ){
    		Robot.shooterFeeder.TurnOnShooterFeeder(.8);
    	}
    	else if (feederAxis > .1){
    		Robot.shooterFeeder.TurnOnShooterFeeder(-1.0);
    	}
    	else{
    		Robot.shooterFeeder.TurnOffShooterFeeder();
    	}
    	
    	
    	
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
    	
    	Robot.shooterFeeder.TurnOffShooterFeeder();
    	
    }
}
