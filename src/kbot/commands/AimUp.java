package kbot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class AimUp extends Command {
    
    public AimUp() 
    {
        requires(CommandBase.aimer);
    }

    public AimUp(double time) 
    {
        requires(CommandBase.aimer);
        setTimeout(time);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() 
    {
        CommandBase.aimer.aim(0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        if(!CommandBase.aimer.atTop())
	{
            CommandBase.aimer.aim(1);
	}
	else
	{
            CommandBase.aimer.aim(0);
	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() 
    {
        CommandBase.aimer.aim(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
        end();
    }
}
