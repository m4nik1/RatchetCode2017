package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveWithPixyAndEncoder extends Command {
	private double mTime;
	private double mSpeed;
	private double mDistance;
	
	private double error;
	private double kp = .02;
	private double tolerance = .5;
	private double pidSpeed;
	
	
	 /**
     * Drive robot based off set encoder distance
     * 
     * @param aDistance
     *            Distance for robot to travel in inches
     * @param aSpeed
     *            Max speed for robot to travel -1 to 1
     * @param aTime
     *            Max time till timed out in seconds
     */
    public DriveWithPixyAndEncoder(double aDistance, double aSpeed, double aTime) {
        requires(Robot.driveTrain);
        requires(Robot.pixycam);
        
        this.mDistance = aDistance;
        this.mSpeed = aSpeed;
        this.mTime = aTime;
        
        setTimeout(mTime);
        
    }
    

    protected void initialize() {
    	Robot.driveTrain.resetEncoders();
    }

    protected void execute() {
    	Robot.pixycam.read();
    	double offset = Robot.pixycam.getLastOffset();
    	double camError = offset - 160;
    	double kPc = .01;
    	double scaleRight = 1 - (camError * kPc);
    	double scaleLeft = 1 + (camError * kPc);
    	//SmartDashboard.putNumber("Camera Error", camError);
    	//SmartDashboard.putNumber("Right Scalar", scaleRight);
    	//SmartDashboard.putNumber("Left Scalar", scaleLeft);
    	
    	
    	
    	error = Math.abs(mDistance - Robot.driveTrain.GetAverageEncoderDistance());
    	
    	if (kp * error >= mSpeed){
    		pidSpeed = mSpeed;
    	}
    	else {
    		pidSpeed = kp * error;
    	}

  
    	if (Robot.driveTrain.GetAverageEncoderDistance() < mDistance)
        {
    		Robot.driveTrain.drive(pidSpeed * scaleLeft, pidSpeed * scaleRight);
        }
        else
        {
        	Robot.driveTrain.drive(-pidSpeed * scaleLeft, -pidSpeed * scaleRight);
        }
    	
    }

    
    
    protected boolean isFinished() {
    	return ((Math.abs(error) <= tolerance) || isTimedOut());
    }

    
    
    protected void end() {
    }

  
    
    protected void interrupted() {
    }
}
