package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team558.robot.RobotMap;

import com.ctre.*;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

public class Shooter extends Subsystem {

	CANTalon shooterMaster = new CANTalon(RobotMap.shooterMaster);
	CANTalon shooterSlave1 = new CANTalon(RobotMap.shooterSlave1);
	   
	public Shooter(){
		shooterMaster.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        shooterMaster.reverseSensor(true);
        shooterMaster.configEncoderCodesPerRev(3);
        shooterMaster.configNominalOutputVoltage(+0.0f, -0.0f);
        shooterMaster.configPeakOutputVoltage(+12.0f, -0.0f);
        shooterMaster.setProfile(0);
        shooterMaster.setF(2.99);
        shooterMaster.setP(6.44); // 1.894*10
        shooterMaster.setI(0);
        shooterMaster.setD(6.44 * 20);	

    	shooterSlave1.changeControlMode(TalonControlMode.Follower);
    	shooterSlave1.set(this.shooterMaster.getDeviceID());

	}

	public void setShooterSpeed(double targetSpeed){
    	shooterMaster.changeControlMode(TalonControlMode.Speed);
    	shooterMaster.set(targetSpeed);
    	
	}
	
	public void stopShooter(){
    	shooterMaster.set(0);
    	
	}
	
	public double ShooterSpeed(){
		return shooterMaster.getSpeed();
	}
	
	
	
    public void initDefaultCommand() {
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
}

