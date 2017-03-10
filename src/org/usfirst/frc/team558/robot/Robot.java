
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
		
		
		chooser.addDefault("Do Nothing", new DoNothing());
		chooser.addObject("CrossBaselineCenter", new CrossBaseline()); // Uncomment these if GearIntake doesn't at all
		chooser.addObject("CrossBaselineStraight", new CrossBaselineStraight()); // ****WARNING THIS IS LAST RESORT
		chooser.addObject("Drive Straight Drop Gear" , new DriveDropGear());
		chooser.addObject("Drive Right Drop Gear" , new DriveAndDropGearRightSide());
		chooser.addObject("Drive Left Drop Gear" , new DriveAndDropGearLeftSide());
		chooser.addObject("PIXY Drive Straight Drop Gear" , new DriveDropGearPixy());
		chooser.addObject("PIXY Drive Right Drop Gear" , new DriveAndDropGearRightSidePixy());
		chooser.addObject("PIXY Drive Left Drop Gear" , new DriveAndDropGearLeftSidePixy());

		
		SmartDashboard.putData("Auto mode", chooser);
		
		
		
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
	autonomousCommand = (Command) chooser.getSelected();
	
	Robot.driveTrain.resetEncoders();
	
			if (autonomousCommand != null)
			autonomousCommand.start();
	}

	
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		Robot.pixycam.read();
		SmartDashboard.putNumber("Gyro Angle", Robot.gyro.GetAngle());
		SmartDashboard.putNumber("Left Encoder", Robot.driveTrain.GetLeftEncoder());
		SmartDashboard.putNumber("Right Encoder", Robot.driveTrain.GetRightEncoder());
		SmartDashboard.putNumber("Average Encoder", Robot.driveTrain.GetAverageEncoderDistance());
		SmartDashboard.putNumber("Pixy Offset" , Robot.pixycam.getLastOffset());
		
	
	}

	
	
	@Override
	public void teleopInit() {
	
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		
		RobotMap.targetSpeed = 8350;

		Robot.driveTrain.resetEncoders();
		Robot.driveTrain.SetRampRate();
		
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
		
		SmartDashboard.putNumber("Gyro Angle", Robot.gyro.GetAngle());
		SmartDashboard.putNumber("Left Encoder", Robot.driveTrain.GetLeftEncoder());
		SmartDashboard.putNumber("Right Encoder", Robot.driveTrain.GetRightEncoder());
		SmartDashboard.putNumber("Average Encoder", Robot.driveTrain.GetAverageEncoderDistance());
		SmartDashboard.putNumber("Pixy Offset" , Robot.pixycam.getLastOffset());
		SmartDashboard.putNumber("Shooter Speed", Robot.shooter.ShooterSpeed());
		
	}

	
	
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
