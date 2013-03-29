package kbot.robot;

import edu.wpi.first.wpilibj.*;

public class RobotMap 
{
    //Motor Defines
    private static final int LEFT_MOTOR = 1;
    private static final int RIGHT_MOTOR = 2;
    private static final int FLIPPY_MOTOR = 3;
    private static final int SHOOTER_FRONT = 4;
    private static final int SHOOTER_BACK = 6;

    //Pneumatics
    private static final int COMPRESSOR_RELAY_CHANNEL = 8;
    private static final int COMPRESSOR_SWITCH_CHANNEL = 14;
    private static final int CHICKEN_RELEASE = 1;
    private static final int GEAR_PISTON = 2;
    private static final int SHOOTER_PISTON = 3;
    private static final int VISION_LIGHTS = 4;
    private static final int AIMING_PISTON = 5;

    //Digital Sidecar
    private static final int TOP_LIMIT = 10;
    private static final int BOTTOM_LIMIT = 12;
    private static final int SHOOTER_ENCODER_A = 14;
    private static final int SHOOTER_ENCODER_B = 15;

    //Analog data
    private static final int POTENTIOMETER = 1;
    
    //Drive Train
    public static SpeedController leftMotor;
    public static SpeedController rightMotor;
    public static RobotDrive robotDrive;
    public static Solenoid gearPiston;
    public static Solenoid chickenLittle;
    
    //Aiming
    public static SpeedController flippyMotor;
    public static AnalogChannel aimerPot;
    public static DigitalInput topLimit;
    public static DigitalInput bottomLimit;
    
    //Shooter
    public static SpeedController shooterFrontMotor;
    public static SpeedController shooterBackMotor;
    public static Solenoid shooterPiston;
    public static Solenoid aimingPiston;
    public static Encoder shooterEncoder;
    
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
        aimingPiston = new Solenoid(AIMING_PISTON);
        aimingPiston.set(false);
        
        //Starting Vision Lights
	ringLED = new Solenoid(VISION_LIGHTS);
	ringLED.set(false);

        //Initializing motors
	leftMotor = new Talon(LEFT_MOTOR);
	rightMotor = new Talon(RIGHT_MOTOR);
        flippyMotor = new Talon(FLIPPY_MOTOR);
	shooterFrontMotor = new Talon(SHOOTER_FRONT);
	shooterBackMotor = new Talon(SHOOTER_BACK);
        
        //RobotDrive
        robotDrive = new RobotDrive(leftMotor, rightMotor);
	robotDrive.setMaxOutput(1.0);
	robotDrive.setExpiration(0.01);
	robotDrive.setSafetyEnabled(false);
        
        //Initializing Analog Inputs
	aimerPot = new AnalogChannel(POTENTIOMETER);
        shooterEncoder = new Encoder(SHOOTER_ENCODER_A, SHOOTER_ENCODER_B, false);
        shooterEncoder.setDistancePerPulse(1.0);
        shooterEncoder.start();
	
	//Initializing Digital Inputs
	topLimit = new DigitalInput(TOP_LIMIT);
	bottomLimit = new DigitalInput(BOTTOM_LIMIT);
    }
}
