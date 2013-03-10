package kbot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import kbot.subsystems.Aimer;
import kbot.subsystems.DriveTrain;
import kbot.subsystems.Pistons;
import kbot.subsystems.Shooter;
import kbot.subsystems.VisionSystem;

import kbot.robot.OI;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    
    // Create a single static instance of all of your subsystems
    public static Aimer aimer = new Aimer();
    public static DriveTrain driveTrain = new DriveTrain();
    public static Pistons pistons = new Pistons();
    public static Shooter shooter = new Shooter();
    public static VisionSystem visionSystem = new VisionSystem();
    
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        //SmartDashboard.putData(exampleSubsystem);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
