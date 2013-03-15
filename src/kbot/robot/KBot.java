package kbot.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import kbot.commands.CommandBase;
import kbot.commands.autonomous.*;

public class KBot extends IterativeRobot 
{
    Command autonomousCommand;

    public void robotInit() 
    {
        RobotMap.init();
        CommandBase.init();
        
        autonomousCommand = new BackCenter3();
        //autonomousCommand = new BackCenter3_openLoop();
    }

    public void autonomousInit() 
    {
        autonomousCommand.start();
    }

    public void autonomousPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    public void teleopInit() 
    {
        autonomousCommand.cancel();
    }

    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
    }
}

/* Things to do:
 * 1. Check toggleLights() code in VisionSystem.java, remove VisionSystem.java if necessary.
 * 2. Make aimer.aim() more readable, change the if/elseif/else statements to be simpler, yet have the same effect... non-essential.
 * 3. Check for other issues with Robot Code, clean up and make it more readable/logical.
 * 4. May need to change the execute method in AimUp/Down.java, as their aimer.aim(+-1) may need to be flipped between them.
 *      Can also change them to use aimer.aimUp() and aimer.aimDown, instead of aimer.aim()?
 * 5. Rename shooterFrontMotor and shooterBackMotor to shooterFront and shooterBack? Non-essential, just for my preference.
 * 6. Check Pistons! the initial settings in RobotMap.java may be wrong, and they'll need to be changed. They
 *      will also need to be changed in PushFrisbee.java, Pistons.java, GearDown.java, and GearUp.java
 * 
 * Things done:
 * 
 * 1. Added XboxController wrapper, changed Drive.java and AimJoystick.java to use the new values(looks cleaner).
 * 2. Removed final static ints from OI and moved them to XboxController, changed opXbox and driverLogitech to wrapper class.
 * 3. Re-organized imports in files to remove annoying warnings.
 * 4. Fixed BackCenter3.java and BackCenter3_OpenLoop.java, as the AimDown() and AimPot() functions were reversed.
 * 5. Changed pot.getAverageVoltage() to pot.getVoltage() in Aimer.java.
 * 6. Changed AimUp.java and AimDown.java 's IsFinished() method to end the command when isTimedOut() or aimer.atTop()/atBottom().
 * 7. Removed stopShooter() from initialize method in SpinUpShooter.java.
 * 8. Changed the imports in CommandBase.java to import kbot.subsystems.*; , as they were all individually listed.
 * 9. Changed Pistons.java's previousChicken boolean initialize, it was set to "false" and is now RobotMap.chickenLittle.get();
 */