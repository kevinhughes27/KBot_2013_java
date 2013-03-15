package kbot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import kbot.commands.*;

public class BackCenter3_openLoop extends CommandGroup 
{
    private static final double AIM_TIME = 0.5;
    
    public BackCenter3_openLoop() 
    {
        addSequential( new AimDown(AIM_TIME) );
	addParallel( new SpinUpShooter() );	
	addSequential( new WaitCommand(3.5) );
	addSequential( new PushFrisbee(0.5) );
	addSequential( new WaitCommand(1.5) );
	addSequential( new PushFrisbee(0.5) );
	addSequential( new WaitCommand(1.5) );
	addSequential( new PushFrisbee(0.5) );
	addSequential( new WaitCommand(1.5) );
    }
}
