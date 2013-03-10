package kbot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {
    
    public Drive() 
    {
        requires(CommandBase.driveTrain);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() 
    {
        CommandBase.driveTrain.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        double leftStick = CommandBase.oi.driverLogitech.getRawAxis(CommandBase.oi.XBOX_LEFT_Y);
        double rightStick = CommandBase.oi.driverLogitech.getRawAxis(CommandBase.oi.XBOX_RIGHT_Y);
        
        CommandBase.driveTrain.drive(leftStick, rightStick);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
        CommandBase.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
        end();
    }
}
