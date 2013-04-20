package kbot.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import kbot.commands.CommandBase;
import kbot.commands.autonomous.*;

public class KBot extends IterativeRobot 
{
    Command autonomousCommand;

    public void robotInit() 
    {
        RobotMap.init();
        CommandBase.init();
        
        autonomousCommand = new PyramidBottom3();
        //autonomousCommand = new BackCenter3();
        //autonomousCommand = new BackCenter3_openLoop();
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
}