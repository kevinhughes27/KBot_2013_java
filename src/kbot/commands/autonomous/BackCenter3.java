package kbot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import kbot.commands.*;

public class BackCenter3 extends CommandGroup 
{
    private static final double POT_VAL = 3.760;
    
    public BackCenter3() 
    {
        addSequential( new AimPot(POT_VAL) );
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
