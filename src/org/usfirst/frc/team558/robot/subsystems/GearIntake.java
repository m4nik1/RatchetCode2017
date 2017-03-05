package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team558.robot.commands.*;

import org.usfirst.frc.team558.robot.RobotMap;


import edu.wpi.first.wpilibj.*;

public class GearIntake extends Subsystem {

	VictorSP gearIntakeVictor1 = new VictorSP(RobotMap.gearIntakeChannel1);
	VictorSP gearIntakeVictor2= new VictorSP(RobotMap.gearIntakeChannel2);
	
	public GearIntake(){
		
		
	}
   
    public void initDefaultCommand() {
        
    	setDefaultCommand(new SetGearIntake());
    	
    }
    
    public void PutGearIn(double speed){
    	
    	gearIntakeVictor1.set(speed);
    	gearIntakeVictor2.set(-speed);
    	
    }
    
    public void PushGearOut(){
    	
    	gearIntakeVictor1.set(1);
    	gearIntakeVictor2.set(-1);
    	
    }
    
    public void GearIntakeStop(){
    	
    	gearIntakeVictor1.set(0);
    	gearIntakeVictor2.set(0);
    	
    }
    
}

