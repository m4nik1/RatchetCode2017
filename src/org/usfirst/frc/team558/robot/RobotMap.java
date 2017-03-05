package org.usfirst.frc.team558.robot;


public class RobotMap {

	//Joystick USB Ports
	public static int driveJoystickPort = 0;
	//public static int driveJoystick2Port = 1;
	public static int operatorJoystickPort = 1;
	
	//Drive Joystick Axes and Buttons
	public static int quickTurnButton = 2;
	public static int turnAxis = 0;
	public static int throttleForwardAxis = 3;
	public static int throttleReverseAxis = 2;
	
	
	//Drive TalonSRXs
	public static int leftDriveMaster = 1;
	public static int leftDriveSlave1 = 2;
	public static int leftDriveSlave2 = 3;
	
	public static int rightDriveMaster = 4;
	public static int rightDriveSlave1 = 5;
	public static int rightDriveSlave2 = 6;
	
	
	//Shooter TalonSRXs
	public static int shooterMaster = 8;
	public static int shooterSlave1 = 9;
	//public static int shooterSlave2 = 9;
	
	//Feeder and Gear Intake Victors
	public static int feederChannel = 9;
	public static int gearIntakeChannel1 = 8;
	public static int gearIntakeChannel2= 5;
	
	//Shooter Target Speed
	public static int targetSpeed;
		
	
	//Solenoids
	public static int breakSolenoidChannel1 = 0;
	public static int breakSolenoidChannel2 = 1;
	
	
	//Proportional Gains
	public static double turn90Gain = .0114;
	public static double turn59Gain = .013;
	
	public static double drive72Gain = .018; //good for 60" and 48"
	public static double drive15Gain = .023;
	
	
	
	

}
