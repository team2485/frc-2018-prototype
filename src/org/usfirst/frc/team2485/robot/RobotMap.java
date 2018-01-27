package org.usfirst.frc.team2485.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.VictorSP;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static VictorSP intakeVictor;
	public static TalonSRX intakeTalonSRX;
	public static TalonSRXWrapper intakeTalon;
	public static TalonSRXWrapper driveLeft1;
	public static TalonSRXWrapper driveLeft2;
	public static TalonSRXWrapper driveLeft3;
	public static TalonSRXWrapper driveRight1, driveRight2, driveRight3;
	public static SpeedControllerWrapper driveLeft, driveRight;
	public static PigeonIMU pigeon;
	
	public static void init() {
		
//		pigeon = new PigeonIMU(1);
		
		intakeVictor = new VictorSP(9);
		intakeTalonSRX = new TalonSRX(4);
		intakeTalon = new TalonSRXWrapper(ControlMode.PercentOutput, intakeTalonSRX);
		driveLeft1 = new TalonSRXWrapper(ControlMode.PercentOutput, new TalonSRX(5));
		driveLeft2 = new TalonSRXWrapper(ControlMode.PercentOutput, new TalonSRX(6));
		driveLeft3 = new TalonSRXWrapper(ControlMode.PercentOutput, new TalonSRX(7));
		driveRight1 = new TalonSRXWrapper(ControlMode.PercentOutput, new TalonSRX(1));
		driveRight2 = new TalonSRXWrapper(ControlMode.PercentOutput, new TalonSRX(2));
		driveRight3 = new TalonSRXWrapper(ControlMode.PercentOutput, new TalonSRX(3));
		
		driveLeft = new SpeedControllerWrapper(new TalonSRXWrapper[]{driveLeft1, driveLeft2, driveLeft3});
		driveRight = new SpeedControllerWrapper(new TalonSRXWrapper[]{driveRight1, driveRight2, driveRight3});
		
//		intakeTalonSRX.enableCurrentLimit(true);
//		intakeTalonSRX.configContinuousCurrentLimit(30, 0);
		intakeTalonSRX.enableCurrentLimit(false);
		intakeTalonSRX.enableVoltageCompensation(false);
		
		driveLeft.setInverted(true);

		
	}
}
