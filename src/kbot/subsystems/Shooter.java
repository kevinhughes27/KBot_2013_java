package kbot.subsystems;

import kbot.robot.RobotMap;
import kbot.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
    
    SpeedController shooterFront = RobotMap.shooterFrontMotor;
    SpeedController shooterBack = RobotMap.shooterBackMotor;
    Solenoid piston = RobotMap.shooterPiston;

    public void initDefaultCommand() 
    {}
    
    public void pushFrisbee(boolean pistonSetting)
    {
        piston.set(pistonSetting);
    }
    
    public void spinUpShooter(double speed)
    {
        shooterFront.set(speed);
        shooterBack.set(speed);
    }
    
    public void stopShooter()
    {
        shooterFront.set(0.0);
        shooterBack.set(0.0);
    }
}
