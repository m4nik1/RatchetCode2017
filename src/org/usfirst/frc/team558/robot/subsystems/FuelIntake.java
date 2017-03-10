package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

import org.usfirst.frc.team558.robot.RobotMap;

import com.ctre.*;
import com.ctre.CANTalon.TalonControlMode;
/**
 *
 */
public class FuelIntake extends Subsystem {

	CANTalon fuelIntakeMaster = new CANTalon(RobotMap.fuelIntakeMaster);
	CANTalon fuelIntakeSlave = new CANTalon(RobotMap.fuelIntakeSlave);
	DoubleSolenoid fuelSol = new DoubleSolenoid(RobotMap.fuelIntakeSolenoidChannel1, RobotMap.fuelIntakeSolenoidChannel2);
	
	public FuelIntake(){
		
		fuelIntakeMaster.changeControlMode(TalonControlMode.PercentVbus);
		fuelIntakeSlave.changeControlMode(TalonControlMode.PercentVbus);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void FuelSolUp(){
    	
    	fuelSol.set(DoubleSolenoid.Value.kReverse);
    	
    }
    
    public void FuelSolDown(){
    	
    	fuelSol.set(DoubleSolenoid.Value.kForward);
    	
    }
    
    public void PullBallsIn(double speed){
    	
    	fuelIntakeMaster.set(speed);
    	fuelIntakeSlave.set(-speed);
    	
    }
    
    public void FuelIntakeStop(){
    	
    	fuelIntakeMaster.set(0);
    	fuelIntakeSlave.set(0);

    	
    }
}

