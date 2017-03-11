package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.Robot;
import org.usfirst.frc.team558.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class DriveAndDropGearRightSide extends CommandGroup {

    public DriveAndDropGearRightSide() {

    	requires(Robot.gearIntake);
    	requires(Robot.driveTrain);
    	requires(Robot.actuateGear);
    	
    	addSequential(new DriveWithEncoder(-75, .5, 5, RobotMap.drive72Gain));
    	addSequential(new TurnWithGyro(-59, .6, RobotMap.turn59Gain));
    	addSequential(new DriveWithPixyAndEncoder(-75, .4, 5));
/*    	addParallel(new DropGear(2)); 
        addSequential(new DropIntake(2)); 
        addSequential(new DriveWithEncoder(15, .6, 2, RobotMap.drive15Gain));
        addSequential(new GearIntakeUp(2));
        addSequential(new TurnWithGyro(59, .6, RobotMap.turn59Gain));
        addSequential(new DriveWithEncoder(-30, .6, 3, RobotMap.drive15Gain));     	
  */  	

        
    }
}
