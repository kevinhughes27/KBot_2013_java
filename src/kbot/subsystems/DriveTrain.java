package kbot.subsystems;

import kbot.robot.RobotMap;
import kbot.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
    
    SpeedController leftMotor = RobotMap.leftMotor;
    SpeedController rightMotor = RobotMap.rightMotor;
    RobotDrive robotDrive = RobotMap.robotDrive;
    boolean speedset = false;
    
    private static final double DRIVER_DEADBAND = 0.10;
    
    public void initDefaultCommand() 
    {
        setDefaultCommand(new Drive());
    }
    
    public void stop()
    {
        leftMotor.set(0.0);
        rightMotor.set(0.0);
    }
    
    public void drive(double leftStick, double rightStick)
    {
        if(Math.abs(leftStick) < DRIVER_DEADBAND)
	{
            leftStick = 0.0;
	}
	if(Math.abs(rightStick) < DRIVER_DEADBAND)
	{
            rightStick = 0.0;
	}
        
        robotDrive.tankDrive(leftStick, rightStick);
    }
    
}
