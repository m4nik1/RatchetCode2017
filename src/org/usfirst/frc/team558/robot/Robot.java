
package org.usfirst.frc.team558.robot;

import org.usfirst.frc.team558.robot.autocommands.*;
import org.usfirst.frc.team558.robot.subsystems.*;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class Robot extends IterativeRobot {

	public static DriveTrain driveTrain = new DriveTrain();
	public static GearIntake gearIntake = new GearIntake();
	public static Shooter shooter = new Shooter();
	public static ShooterFeeder shooterFeeder = new ShooterFeeder();
	public static PixyCam pixycam = new PixyCam();
	public static FuelIntake fuelIntake = new FuelIntake();
	public static Brake brake = new Brake();
	public static ActuateGear actuateGear = new ActuateGear();
	public static Gyro gyro = new Gyro();
	
	public static Compressor pcm = new Compressor();
	public static Relay compressor = new Relay(0);
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<Command>();


	
	
	@Override
	public void robotInit() {
		oi = new OI();
		
		CameraServer.getInstance().startAutomaticCapture();
		
		
		
		
		//SmartDashboard.putData("Auto mode", chooser);
		
		
		
	}

	
	
	@Override
	public void disabledInit() {

	}

	
	
	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	
	
	@Override
	public void autonomousInit() {
	autonomousCommand = new DriveAndDropGearRightSide();

	Robot.driveTrain.resetEncoders();
	
			if (autonomousCommand != null)
			autonomousCommand.start();
	}

	
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
		SmartDashboard.putNumber("Gyro Angle", Robot.gyro.GetAngle());
		SmartDashboard.putNumber("Left Encoder", Robot.driveTrain.GetLeftEncoder());
		SmartDashboard.putNumber("Right Encoder", Robot.driveTrain.GetRightEncoder());
		SmartDashboard.putNumber("Average Encoder", Robot.driveTrain.GetAverageEncoderDistance());
	}

	
	
	@Override
	public void teleopInit() {
	
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		
		RobotMap.targetSpeed = 8350;

		Robot.driveTrain.resetEncoders();
		
	}

	
	
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		if (!pcm.getPressureSwitchValue()){
			compressor.set(Value.kForward);
		}
		else {
			compressor.set(Value.kOff);
		}
		Robot.pixycam.read();
		SmartDashboard.putNumber("Left Encoder", Robot.driveTrain.GetLeftEncoder());
		SmartDashboard.putNumber("Right Encoder", Robot.driveTrain.GetRightEncoder());
		SmartDashboard.putNumber("Average Encoder", Robot.driveTrain.GetAverageEncoderDistance());
		SmartDashboard.putNumber("Pixy Offset" , Robot.pixycam.getLastOffset());
		SmartDashboard.putNumber("Left Motor" , Robot.driveTrain.GetLeftDrive());
		SmartDashboard.putNumber("Right Motor" , Robot.driveTrain.GetRightDrive());
		
		
	}

	
	
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
