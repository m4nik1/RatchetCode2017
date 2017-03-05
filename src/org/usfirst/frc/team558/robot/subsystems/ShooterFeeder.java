package org.usfirst.frc.team558.robot.subsystems;

import org.usfirst.frc.team558.robot.RobotMap;
import org.usfirst.frc.team558.robot.commands.*;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;


public class ShooterFeeder extends Subsystem {

	VictorSP shooterFeederTalon = new VictorSP(RobotMap.feederChannel);

	public ShooterFeeder() {
		
		
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new SetShooterFeeder());
    }
    
   public void TurnOnShooterFeeder(double speed){
	   
	   shooterFeederTalon.set(speed);
	   
   }
   
   public void TurnOffShooterFeeder(){
	   
	   shooterFeederTalon.set(0);
	   
   }
   
}

