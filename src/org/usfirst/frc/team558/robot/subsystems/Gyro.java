package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.kauailabs.navx.frc.*;

/**
 *
 */
public class Gyro extends Subsystem {

	AHRS gyro = new AHRS(SPI.Port.kMXP);

    public void initDefaultCommand() {
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public double GetAngle(){
    	return gyro.getYaw();
    }
    public double GetYaw(){
    	return gyro.getYaw();
    }
    
    public double GetPitch(){
    	return gyro.getPitch();
    }
    
    public double GetRoll(){
    	return gyro.getRoll();
    }
    
    
    
    public void ResetGyro(){
    	gyro.reset();
    }
}

