package kbot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import kbot.robot.RobotMap;

public class Shooter extends Subsystem 
{
    private static double speed = -0.8;
    private static final double increase = 0.05;
    SpeedController frontMotor = RobotMap.shooterFrontMotor;
    SpeedController backMotor = RobotMap.shooterBackMotor;
    
    DoubleSolenoid piston = RobotMap.shooterPiston;

    public void initDefaultCommand() 
    {}
    
    public void pushFrisbee(DoubleSolenoid.Value pistonSetting)
    {
        piston.set(pistonSetting);
    }
    
    public void spinUpShooter()
    {
        frontMotor.set(speed);
        backMotor.set(speed);
        SmartDashboard.putNumber("Wheel Speed: ", speed);
    }
    
    public void stopShooter()
    {
        frontMotor.set(0.0);
        backMotor.set(0.0);
    }
    
    public void increaseSpeed()
    {
        speed -= increase;
    }
    
    public void decreaseSpeed()
    {
        speed += increase;
    }
    
    public void resetSpeed()
    {
        speed = -0.8;
    }
}
