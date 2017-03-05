package org.usfirst.frc.team558.robot;
import org.usfirst.frc.team558.robot.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;

public class OI {
	
	Joystick driveStick = new Joystick(RobotMap.driveJoystickPort);
	Joystick operatorStick = new Joystick(RobotMap.operatorJoystickPort);
	JoystickButton shooterFeederButton = new JoystickButton(operatorStick,2); 
	
	JoystickButton shootOnButton = new JoystickButton(operatorStick, 7);
	JoystickButton shootOffButton = new JoystickButton(operatorStick, 8);
	
	
	//JoystickButton gearIntakeInBtn = new JoystickButton(operatorStick, 1);
	//JoystickButton gearIntakeOutBtn = new JoystickButton(operatorStick, 10);
	
	
	
	JoystickButton brakeOnButton = new JoystickButton(driveStick, 3);
	JoystickButton brakeOffButton = new JoystickButton(driveStick, 4);
	
	//JoystickButton speedUpButton = new JoystickButton(operatorStick, 5);
	//JoystickButton speedDownButton = new JoystickButton(operatorStick, 6);
	
	JoystickButton pixyAlignbtn = new JoystickButton(driveStick, 1);
	
	JoystickButton pickGearUp = new JoystickButton(operatorStick, 5);
	JoystickButton dropGear = new JoystickButton(operatorStick, 6);
	
	JoystickButton fuelIntakeDown = new JoystickButton(operatorStick, 4);	
	
	
	
	
	public OI(){
	
		shooterFeederButton.toggleWhenPressed(new SetShooterFeeder());
		
		shootOnButton.whenPressed(new SetShooterOn());
		shootOffButton.whenPressed(new SetShooterOff());
		
		//gearIntakeInBtn.toggleWhenPressed(new PullGearIn());
		//gearIntakeOutBtn.toggleWhenPressed(new PushGearOut());
		
		brakeOnButton.whenPressed(new SetBrakeOn());
		brakeOffButton.whenPressed(new SetBrakeOff());
		
		//speedUpButton.whenPressed(new ShooterSpeedUp());
		//speedDownButton.whenPressed(new ShooterSpeedDown());
		
		pickGearUp.whileHeld(new PickUpGear());
		dropGear.whileHeld(new DropGear());
		
		fuelIntakeDown.toggleWhenPressed(new FuelIntakeUpdown());
		
		pixyAlignbtn.whenPressed(new AlignWithPixy()); 
		
	}

	
	
	
	//Elm City Drive Methods
	public boolean GetQuickTurn(){
		return driveStick.getRawButton(RobotMap.quickTurnButton);
		
	}
	
	public double GetThrottle(){
		double reverse = driveStick.getRawAxis(RobotMap.throttleForwardAxis);
    	double forward = driveStick.getRawAxis(RobotMap.throttleReverseAxis);

    	if ((reverse > .1) && (forward >.1)){
    		return 0;
    	}
    	else if (forward > .1){
    		return forward;
    	}
    	else if (reverse > .1){
    		return -reverse;
    	}
    	else
    		return 0;
	}

	
	public double GetTurn(){
		return -driveStick.getRawAxis(RobotMap.turnAxis);
	}
	
	
	public double GetFeeder(){
		return operatorStick.getRawAxis(3);
	}
	
	public double GetGearSpeed(){
		
		return operatorStick.getRawAxis(1);
		
	}
	
}
