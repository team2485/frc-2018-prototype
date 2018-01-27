
package org.usfirst.frc.team2485.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.sensors.PigeonIMU_StatusFrame;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	//private static Joystick driver = new Joystick(0);
	private static Joystick operator = new Joystick(0);

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		RobotMap.init();
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
//		if (myPigeon == null) {
//			myPigeon = new PigeonIMU(0);
//			myPigeon.setStatusFramePeriod(PigeonIMU_StatusFrame.CondStatus_1_General, 20, 100);
//		}
		
		
	}
	PigeonIMU myPigeon;
	public double reducer = 0.8; 
	
	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		
		Scheduler.getInstance().run();
//		RobotMap.intakeTalon.set(joystick.getRawAxis(5));
//		RobotMap.intakeVictor.set(joystick.getRawAxis(1));
//		
		
//		RobotMap.intakeTalon.set(pwm);
//		RobotMap.intakeVictor.set(pwm);
		
		////////
//		double throttle = -ThresholdHandler.deadbandAndScale(driver.getRawAxis(1), .2, 0, .75);
//		double steering = ThresholdHandler.deadbandAndScale(driver.getRawAxis(4), .2, 0, .5);
//		double left, right;
//
//
//		left = throttle + steering;
//		right = throttle - steering;
//
//		if (Math.abs(left) > 1) {
//			right /= Math.abs(left);
//			left /= Math.abs(left);
//		} 
//		if (Math.abs(right) > 1) {
//			left /= Math.abs(right);
//			right /= Math.abs(right);
//		}
		////////
//		
//		if(driver.getRawButton(1)) {
//			RobotMap.intakeTalon.set(-.25);
//		}
//		else if (driver.getRawButton(2)) {
//			RobotMap.intakeTalon.set(-.5);
//		}
//		else if (driver.getRawButton(3)) {
//			RobotMap.intakeTalon.set(-.75);
//		}
//		else if (driver.getRawButton(4)) {
//			RobotMap.intakeTalon.set(-1);
//		}
		
		//////
//		if(operator.getRawButton(5)) {
//			RobotMap.intakeTalon.set(-1);
//			RobotMap.intakeVictor.set(-1);
//		}
//		else {
//			double y = ThresholdHandler.deadbandAndScale(operator.getRawAxis(1), .2, 0, 1);
//			double r = ThresholdHandler.deadbandAndScale(operator.getRawAxis(4), .2, 0, 1);
//			
//			RobotMap.intakeTalon.set(y + r);
//			RobotMap.intakeVictor.set(y - r);
//			
////			System.out.println(driver.getRawAxis(3));
////			System.out.println(driver.getRawAxis(2));
//
//		}
		//////
		double y = ThresholdHandler.deadbandAndScale(operator.getRawAxis(1), .2, 0, 1);
		double r = ThresholdHandler.deadbandAndScale(operator.getRawAxis(4), .2, 0, 1);
		
		RobotMap.intakeTalon.set(y + r);
		RobotMap.intakeVictor.set(y - r);
		
//		double[] xyz = new double[3];
//		myPigeon.getYawPitchRoll(xyz);
//		
//		double left = throttle + steering;
//		double right = throttle - steering;
//		if (left > 1 || left < -1) {
//			right /= left;
//			left /= left;
//		}
//		if (right > 1 || right < -1) {
//			left /= right;
//			right /= right;
//		}
		
		//////
//		RobotMap.driveLeft.set(reducer * left);
//		RobotMap.driveRight.set(reducer * right);
//		
		/////
		
//		PigeonIMU.GeneralStatus genStatus = new PigeonIMU.GeneralStatus();
//		myPigeon.getGeneralStatus(genStatus);
//		System.out.println(genStatus.toString());
//		SmartDashboard.putNumber("Gyro Yaw", xyz[0]);
//		System.out.println(xyz[0]);
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	
}
