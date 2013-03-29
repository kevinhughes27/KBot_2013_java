package kbot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import kbot.robot.RobotMap;

public class Shooter extends Subsystem 
{
    SpeedController shooterFront = RobotMap.shooterFrontMotor;
    SpeedController shooterBack = RobotMap.shooterBackMotor;
    Solenoid piston = RobotMap.shooterPiston;
    Encoder shooterEnc = RobotMap.shooterEncoder;
    
    private final static double pK = 0.5;
    private final static double iK = 0.0;
    private final static double dK = 0.0;
    private double lastSpeedErr = 0.0;
    private double integralCounter = 0.0;
    private double setSpeed = 0.0;

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
    
    public void spinUpShooterPID(double speedTarget)
    {
        double speedErr = speedTarget - shooterEnc.getRaw();
        double pKErr = speedErr * pK;
        double iKErr = integralCounter * iK;
        double dKErr = (lastSpeedErr - speedErr) * dK;
        
        lastSpeedErr = speedErr;
        integralCounter += speedErr;
        
        double speedDifference = pKErr + iKErr + dKErr;
        
        setSpeed += speedDifference;
        
        spinUpShooter(setSpeed);
    }
}
