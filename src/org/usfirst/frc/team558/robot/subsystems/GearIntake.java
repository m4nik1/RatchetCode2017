package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team558.robot.commands.*;

import org.usfirst.frc.team558.robot.RobotMap;

import com.ctre.*;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.*;

public class GearIntake extends Subsystem {

	CANTalon gearIntake1 = new CANTalon(RobotMap.gearIntakeChannel1);
	CANTalon gearIntake2 = new CANTalon(RobotMap.gearIntakeChannel2);
	
	public GearIntake(){
		
		gearIntake1.changeControlMode(TalonControlMode.PercentVbus);
		gearIntake2.changeControlMode(TalonControlMode.PercentVbus);
		
		
	}
   
    public void initDefaultCommand() {
        
    	
    }
    
    public void PutGearIn(double speed){
    	
    	gearIntake1.set(-speed); // invert this intake for yellow ball intake
    	gearIntake2.set(speed); // invert this intake for joey's intake
    	
    }
    
    public void PushGearOut(){
    	
    	gearIntake1.set(-1); // invert this speed for the yellow ball intake
    	gearIntake2.set(1); // Invert this speed for joey's intake
    	
    }
    
    public void GearIntakeStop(){
    	
    	gearIntake1.set(0);
    	gearIntake2.set(0);
    	
    }
    
}

