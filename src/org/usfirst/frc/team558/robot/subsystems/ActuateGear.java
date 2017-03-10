package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team558.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
/**
 *
 */
public class ActuateGear extends Subsystem {

	DoubleSolenoid gearSol = new DoubleSolenoid(RobotMap.gearIntakeSolenoidChannel1, RobotMap.gearIntakeSolenoidChannel2);
	
	public void GearSolDown(){
		
		gearSol.set(DoubleSolenoid.Value.kReverse);
		
	}
	
	
	public void GearSolUp(){
		
		gearSol.set(DoubleSolenoid.Value.kForward);
		
		
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

