package kbot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import kbot.robot.RobotMap;

public class Pistons extends Subsystem 
{    
    Solenoid gearPiston = RobotMap.gearPiston;
    Solenoid chickenLittle = RobotMap.chickenLittle;
    Solenoid shooterPiston = RobotMap.shooterPiston;
    
    private boolean previousChicken = RobotMap.chickenLittle.get(); //false
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
        chickenLittle.set(previousChicken);
    }
    
    public void toggleShooter()
    {
        previousShooter = !previousShooter;
        shooterPiston.set(previousShooter);
    }
}
