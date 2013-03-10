package kbot.subsystems;

import kbot.robot.RobotMap;
import kbot.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VisionSystem extends Subsystem {
    
    Solenoid ringLED = RobotMap.ringLED;
    boolean run = false;
    
    public void initDefaultCommand() 
    {}
    
    public void toggle()
    {
        run = SmartDashboard.getBoolean("runVision");
        SmartDashboard.putBoolean("runVision", !run);
        ringLED.set(run);
    }
}
