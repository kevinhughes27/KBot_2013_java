package kbot.commands;

public class SetAimDown extends CommandBase 
{
    public SetAimDown() 
    {
        requires(CommandBase.pistons);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
        /*The position of this shooter needs to be set to bottom of pyramid*/
        CommandBase.pistons.setShooter(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {}
}