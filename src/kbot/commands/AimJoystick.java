package kbot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class AimJoystick extends Command 
{
    
    public AimJoystick() 
    {
        requires(CommandBase.aimer);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() 
    {
        CommandBase.aimer.aim(0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        // what axis?
        CommandBase.aimer.aim(CommandBase.oi.opXbox.getJoyLeftY());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
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
