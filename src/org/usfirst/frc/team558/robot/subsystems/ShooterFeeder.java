package org.usfirst.frc.team558.robot.subsystems;

import org.usfirst.frc.team558.robot.RobotMap;
import org.usfirst.frc.team558.robot.commands.*;

import com.ctre.*;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;


public class ShooterFeeder extends Subsystem {

	CANTalon shooterFeeder = new CANTalon(RobotMap.feederChannel);

	public ShooterFeeder() {
		
		shooterFeeder.changeControlMode(TalonControlMode.PercentVbus);
		
		
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new SetShooterFeeder());
    }
    
   public void TurnOnShooterFeeder(double speed){
	   
	   shooterFeeder.set(speed);
	   
   }
   
   public void TurnOffShooterFeeder(){
	   
	   shooterFeeder.set(0);
	   
   }
   
}

