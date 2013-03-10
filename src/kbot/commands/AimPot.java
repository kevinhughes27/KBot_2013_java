package kbot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class AimPot extends Command {
    
    private double setPoint;
    
    public AimPot(double _setPoint) 
    {
        requires(CommandBase.aimer);
        setPoint = _setPoint;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() 
    {
        CommandBase.aimer.aim(0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        CommandBase.aimer.aimDown();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return (CommandBase.aimer.getPot() <= setPoint) 
		 || CommandBase.aimer.atBottom();
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
