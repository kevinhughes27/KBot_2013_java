package kbot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import kbot.commands.*;
import kbot.robot.RobotMap;

public class Aimer extends Subsystem 
{
    SpeedController motor = RobotMap.aimerMotor;
    AnalogChannel pot = RobotMap.aimerPot;
    DigitalInput topLimit = RobotMap.topLimit;
    DigitalInput bottomLimit = RobotMap.bottomLimit;

    //Constants
    private static final boolean LIMIT_SWITCH_ON = true;
    private static final double AIM_SPEED = 0.20;
    private static final double OPERATOR_DEADBAND = 0.10;
    
    public void initDefaultCommand() 
    {
        setDefaultCommand(new AimJoystick());
    }
    
    public void aim(double joystickInput) 
    {
        joystickInput *= -1;
        
        SmartDashboard.putNumber("Pot:", pot.getVoltage());
        
        if((Math.abs(joystickInput) > OPERATOR_DEADBAND) && !(atBottom() || atTop()))
	{
            // if going up
            if(joystickInput < 0)
            {
                motor.set(joystickInput * (AIM_SPEED+0.1));
            }
            else // going down
            {
                motor.set(joystickInput * AIM_SPEED);
            }
	}
	else if(atBottom())
	{
            //printf("Bottom switch pressed\n");
            if(joystickInput > 0.0)
            {
                joystickInput = 0.0;
            }
            motor.set(joystickInput * AIM_SPEED);
	}
	else if(atTop())
	{
            //printf("Top switch pressed\n");
            if(joystickInput < 0.0)
            {
                joystickInput = 0.0;
            }
            motor.set(joystickInput * AIM_SPEED);
	}
	else
	{
            motor.set(0.0);
	}
        
    }
    
    public void aimUp()
    {
        motor.set(-AIM_SPEED-0.1);
    }

    public void aimDown()
    {
        motor.set(AIM_SPEED-0.1);
    }

    public double getPot() 
    {
        return pot.getVoltage();
    }

    public boolean atBottom()
    {
        return (bottomLimit.get() == LIMIT_SWITCH_ON);
    }

    public boolean atTop()
    {
        return (topLimit.get() == LIMIT_SWITCH_ON);
    }
    
}
