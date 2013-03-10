package kbot.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import kbot.commands.CommandBase;
import kbot.commands.autonomous.*;

public class KBot extends IterativeRobot {

    Command autonomousCommand;

    public void robotInit() 
    {
        RobotMap.init();
        CommandBase.init();
        
        autonomousCommand = new BackCenter3();
    }

    public void autonomousInit() 
    {
        autonomousCommand.start();
    }

    public void autonomousPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    public void teleopInit() 
    {
        autonomousCommand.cancel();
    }

    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic() 
    {
        LiveWindow.run();
    }
}