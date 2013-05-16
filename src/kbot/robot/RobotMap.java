package kbot.robot;

import edu.wpi.first.wpilibj.*;

public class RobotMap 
{
    //Motor Defines
    private static final int LEFT_MOTOR = 1;
    private static final int RIGHT_MOTOR = 2;
    private static final int SHOOTER_FRONT = 4;
    private static final int SHOOTER_BACK = 6;

    //Pneumatics
    private static final int COMPRESSOR_RELAY_CHANNEL = 8;
    private static final int COMPRESSOR_SWITCH_CHANNEL = 14;
    private static final int HANGER_PISTON_A = 1;
    private static final int HANGER_PISTON_B = 2;
    private static final int CHICKEN_RELEASE_A = 3;
    private static final int CHICKEN_RELEASE_B = 4;
    private static final int SHOOTER_PISTON_A = 5;
    private static final int SHOOTER_PISTON_B = 6;
    private static final int GEAR_PISTON_A = 7;
    private static final int GEAR_PISTON_B = 8;
    private static final int AIMING_PISTON_A = 1;
    private static final int AIMING_PISTON_B = 2;
    
    //Drive Train
    public static SpeedController leftMotor;
    public static SpeedController rightMotor;
    public static RobotDrive robotDrive;
    public static DoubleSolenoid gearPiston;
    public static DoubleSolenoid chickenLittle;
    
    //Shooter
    public static SpeedController shooterFrontMotor;
    public static SpeedController shooterBackMotor;
    public static DoubleSolenoid shooterPiston;
    public static DoubleSolenoid aimingPiston;
    
    //Other
    public static Compressor compressor;
    public static DoubleSolenoid hanger;
    
    public static void init()
    {
		//Starting compressor
		compressor = new Compressor(COMPRESSOR_SWITCH_CHANNEL, COMPRESSOR_RELAY_CHANNEL);
		compressor.start();

		//Pneumatics
		gearPiston = new DoubleSolenoid(1, GEAR_PISTON_A, GEAR_PISTON_B);
		gearPiston.set(DoubleSolenoid.Value.kReverse); //k.Forward is low gear
		/*hanger deploys the gas spring*/
		hanger = new DoubleSolenoid(1, HANGER_PISTON_A, HANGER_PISTON_B);
		hanger.set(DoubleSolenoid.Value.kForward); //k.forward is holding gas spring
		/*chickenLittle changes the height of the hooks*/
		chickenLittle = new DoubleSolenoid(2, CHICKEN_RELEASE_A, CHICKEN_RELEASE_B);
		chickenLittle.set(DoubleSolenoid.Value.kReverse);//k.forward is up
		/*Shooter piston fires the frisbees*/
		shooterPiston = new DoubleSolenoid(1,SHOOTER_PISTON_A, SHOOTER_PISTON_B);
		shooterPiston.set(DoubleSolenoid.Value.kForward); //k.Forward is loading position
		/*Aiming piston changes the shooter's position*/
		aimingPiston = new DoubleSolenoid(2,AIMING_PISTON_A, AIMING_PISTON_B);
		aimingPiston.set(DoubleSolenoid.Value.kForward); //k.Forward is up

		//Initializing motors
		leftMotor = new Talon(LEFT_MOTOR);
		rightMotor = new Talon(RIGHT_MOTOR);
		shooterFrontMotor = new Talon(SHOOTER_FRONT);
		shooterBackMotor = new Talon(SHOOTER_BACK);
		    
		//RobotDrive
		robotDrive = new RobotDrive(leftMotor, rightMotor);
		robotDrive.setMaxOutput(1.0);
		robotDrive.setExpiration(0.01);
		robotDrive.setSafetyEnabled(false);
    }
    
    //Reinitializes all pistons to their original settings
    public static void reset()
    {
        aimingPiston.set(DoubleSolenoid.Value.kForward);
        shooterPiston.set(DoubleSolenoid.Value.kForward);
        hanger.set(DoubleSolenoid.Value.kForward);
        chickenLittle.set(DoubleSolenoid.Value.kReverse);
        gearPiston.set(DoubleSolenoid.Value.kReverse);
    }
}
