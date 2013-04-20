package kbot.commands;

public class TimedChickenDeploy extends CommandBase {
    
    public TimedChickenDeploy() {
        requires(CommandBase.chicken);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
        //Set the chicken up
        CommandBase.chicken.initialPosition();
        //timeout is 133 seconds, or 2 minutes and 13 seconds
        setTimeout(133);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() 
    {
        //set the chicken down
        CommandBase.chicken.finalPosition();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {}
}
