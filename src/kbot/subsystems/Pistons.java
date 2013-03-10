package kbot.subsystems;

import kbot.robot.RobotMap;
import kbot.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pistons extends Subsystem {
    
    Solenoid gearPiston = RobotMap.gearPiston;
    Solenoid chickenLittle = RobotMap.chickenLittle;
    private boolean previousChicken = false;

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
}
