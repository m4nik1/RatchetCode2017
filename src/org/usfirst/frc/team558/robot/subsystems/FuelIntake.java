package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;
import com.ctre.*;
import com.ctre.CANTalon.TalonControlMode;
/**
 *
 */
public class FuelIntake extends Subsystem {

	CANTalon fuelIntake = new CANTalon(11);
	DoubleSolenoid fuelSol = new DoubleSolenoid(4,5);
	
	public FuelIntake(){
		
		fuelIntake.changeControlMode(TalonControlMode.PercentVbus);
		
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void FuelSolUp(){
    	
    	fuelSol.set(DoubleSolenoid.Value.kForward);
    	
    }
    
    public void FuelSolDown(){
    	
    	fuelSol.set(DoubleSolenoid.Value.kReverse);
    	
    }
    
    public void PullBallsIn(double speed){
    	
    	fuelIntake.set(speed);
    	
    }
    
    public void FuelIntakeStop(){
    	
    	fuelIntake.set(0);
    	
    }
}

