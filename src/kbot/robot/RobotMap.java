package kbot.robot;

import edu.wpi.first.wpilibj.*;

public class RobotMap 
{
    //Motor Defines
    private static final int LEFT_MOTOR = 1;
    private static final int RIGHT_MOTOR = 2;
    private static final int AIMER_MOTOR = 3;
    private static final int SHOOTER_FRONT = 4;
    private static final int SHOOTER_BACK = 6;

    //Pneumatics
    private static final int COMPRESSOR_RELAY_CHANNEL = 8;
    private static final int COMPRESSOR_SWITCH_CHANNEL = 14;
    private static final int CHICKEN_RELEASE = 1;
    private static final int GEAR_PISTON = 2;
    private static final int SHOOTER_PISTON = 3;
    private static final int VISION_LIGHTS = 4;

    //Digital Sidecar
    private static final int TOP_LIMIT = 10;
    private static final int BOTTOM_LIMIT = 12;

    //Analog Breakout
    private static final int POTENTIOMETER = 1;
    
    //Drive Train
    public static SpeedController leftMotor;
    public static SpeedController rightMotor;
    public static RobotDrive robotDrive;
    public static Solenoid gearPiston;
    public static Solenoid chickenLittle;
    
    //Aiming
    public static SpeedController aimerMotor;
    public static AnalogChannel aimerPot;
    public static DigitalInput topLimit;
    public static DigitalInput bottomLimit;
    
    //Shooter
    public static SpeedController shooterFrontMotor;
    public static SpeedController shooterBackMotor;
    public static Solenoid shooterPiston;
    
    //Other
    public static Compressor compressor;
    public static Solenoid ringLED;
    
    public static void init()
    {
        //Starting compressor
        compressor = new Compressor(COMPRESSOR_SWITCH_CHANNEL, COMPRESSOR_RELAY_CHANNEL);
        compressor.start();
        
        //Pneumatics
        gearPiston = new Solenoid(GEAR_PISTON);
        gearPiston.set(true);
        chickenLittle = new Solenoid(CHICKEN_RELEASE);
	chickenLittle.set(false);
	shooterPiston = new Solenoid(SHOOTER_PISTON);
	shooterPiston.set(false);
        
        //Starting Vision Lights
	ringLED = new Solenoid(VISION_LIGHTS);
	ringLED.set(false);
        
        leftMotor = new Talon(1);
        rightMotor = new Talon(2);
        robotDrive = new RobotDrive(leftMotor, rightMotor);

        //Initializing motors
	leftMotor = new Talon(LEFT_MOTOR);
	rightMotor = new Talon(RIGHT_MOTOR);
        aimerMotor = new Talon(AIMER_MOTOR);
	shooterFrontMotor = new Talon(SHOOTER_FRONT);
	shooterBackMotor = new Talon(SHOOTER_BACK);
        
        //RobotDrive
        robotDrive = new RobotDrive(leftMotor, rightMotor);
	robotDrive.setMaxOutput(1.0);
	robotDrive.setExpiration(0.01);
	robotDrive.setSafetyEnabled(false);
        
        //Initializing Analog Inputs
	aimerPot = new AnalogChannel(POTENTIOMETER);
	
	//Initializing Digital Inputs
	topLimit = new DigitalInput(TOP_LIMIT);
	bottomLimit = new DigitalInput(BOTTOM_LIMIT);
    }
}
