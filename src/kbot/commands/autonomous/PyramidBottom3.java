package kbot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import kbot.commands.*;

public class PyramidBottom3 extends CommandGroup 
{
    
    public PyramidBottom3() 
    {
        addSequential( new SetAimDown() );
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