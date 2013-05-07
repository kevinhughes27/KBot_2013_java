package kbot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class PushFrisbee extends Command 
{
    
    public PushFrisbee() 
    {}
    
    public PushFrisbee(double time) 
    {
        requires(CommandBase.shooter);
        setTimeout(time);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() 
    {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        CommandBase.shooter.pushFrisbee(DoubleSolenoid.Value.kReverse);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false || isTimedOut(); //return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
        CommandBase.shooter.pushFrisbee(DoubleSolenoid.Value.kForward);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
        end();
    }
}
