package kbot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import kbot.robot.RobotMap;

public class Pistons extends Subsystem 
{    
    Solenoid gearPiston = RobotMap.gearPiston;
    Solenoid miniChicken = RobotMap.miniChicken;
    Solenoid shooterPiston = RobotMap.shooterPiston;
    
    private boolean previousChicken = RobotMap.miniChicken.get(); //false
    private boolean previousShooter = RobotMap.shooterPiston.get(); //false

    public void initDefaultCommand() 
    {}
    
    public void gearChange(boolean change)
    {
        gearPiston.set(change);
    }
    
    public void toggleChicken()
    {
        previousChicken = !previousChicken;
        miniChicken.set(previousChicken);
    }
    
    public void toggleShooter()
    {
        previousShooter = !previousShooter;
        shooterPiston.set(previousShooter);
    }
    
    public void setShooter(boolean bool)
    {
        shooterPiston.set(bool);
    }
}
