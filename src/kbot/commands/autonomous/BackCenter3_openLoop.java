package kbot.commands.autonomous;

import kbot.commands.*;

import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class BackCenter3_openLoop extends CommandGroup {
    
    private static final double POT_VAL = 3.760;
    
    public BackCenter3_openLoop() 
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
