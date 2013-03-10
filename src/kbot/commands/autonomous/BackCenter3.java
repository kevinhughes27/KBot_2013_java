package kbot.commands.autonomous;

import kbot.commands.*;

import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class BackCenter3 extends CommandGroup {
    
    private static final double AIM_TIME = 0.5;
    
    public BackCenter3() 
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
