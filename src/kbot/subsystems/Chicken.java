package kbot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import kbot.commands.*;
import kbot.robot.RobotMap;

public class Chicken extends Subsystem {
    Solenoid chickenLittle = RobotMap.chickenLittle;
    
    public void initDefaultCommand() 
    {
        setDefaultCommand(new TimedChickenDeploy());
    }
    /*NOTE: true and false may need to be flipped depending on the orientation of the pistons*/
    public void initialPosition()
    {
        chickenLittle.set(true);
    }
    
    public void finalPosition()
    {
        chickenLittle.set(false);
    }
}
