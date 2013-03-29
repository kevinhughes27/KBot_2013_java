package kbot.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import kbot.commands.*;
import kbot.wrappers.XboxController;

public class OI 
{
    //Connection ports
    public static final int DRIVER_PORT = 1;
    public static final int OPERATOR_PORT = 2;
    
    //Joysticks
    public XboxController driverLogitech, opXbox;
    
    //Operator buttons
    JoystickButton push;
    JoystickButton shoot;
    JoystickButton visionToggle;
    JoystickButton shooterToggle;
    
    //Driver buttons
    JoystickButton chickenRelease;
    JoystickButton gearUp;
    JoystickButton gearDown;
    
    public OI()
    {
        //Joysticks
        driverLogitech = new XboxController(DRIVER_PORT);
        opXbox = new XboxController(OPERATOR_PORT);

        //Operator buttons
        push = new JoystickButton(opXbox.m_joy, opXbox.XBOX_A);
        shooterToggle = new JoystickButton(opXbox.m_joy, opXbox.XBOX_LB);
        shoot = new JoystickButton(opXbox.m_joy, opXbox.XBOX_RB);
        visionToggle = new JoystickButton(opXbox.m_joy, opXbox.XBOX_B);

        //Driver buttons
        chickenRelease = new JoystickButton(driverLogitech.m_joy, driverLogitech.XBOX_A);
        gearUp = new JoystickButton(driverLogitech.m_joy, driverLogitech.XBOX_RB);
        gearDown = new JoystickButton(driverLogitech.m_joy, driverLogitech.XBOX_LB);
        
        //Operator button initialize
        push.whenPressed(new PushFrisbee());
        shooterToggle.whenPressed(new ToggleAim());
        shoot.whileHeld(new SpinUpShooter());
        visionToggle.whenPressed(new ToggleVision());
        
        //Driver buttons initialize
        chickenRelease.whenPressed(new ChickenRelease());
        gearUp.whenPressed(new GearUp());
        gearDown.whenPressed(new GearDown());
    }
 
}

