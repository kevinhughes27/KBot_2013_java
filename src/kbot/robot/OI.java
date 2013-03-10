package kbot.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    
    public static final int XBOX_A = 1;
    public static final int XBOX_B = 2;
    public static final int XBOX_X = 3;
    public static final int XBOX_Y = 4;
    public static final int XBOX_LB = 5;
    public static final int XBOX_RB = 6;
    public static final int XBOX_TRIGGER = 3;
    public static final int XBOX_LEFT_Y = 2;
    public static final int XBOX_LEFT_X = 1;
    public static final int XBOX_RIGHT_Y = 5;
    public static final int XBOX_RIGHT_X = 4;
    public static final int XBOX_START = 8;
    public static final int XBOX_SELECT = 7;
    
    public Joystick driverLogitech;
    public Joystick opXbox;
    
    JoystickButton push;
    JoystickButton shoot;
    JoystickButton visionToggle;
    
    JoystickButton chickenRelease;
    JoystickButton gearUp;
    JoystickButton gearDown;
    
    public OI()
    {
        driverLogitech = new Joystick(1);
        opXbox = new Joystick(2);

        push = new JoystickButton(opXbox,XBOX_LB);
        shoot = new JoystickButton(opXbox,XBOX_RB);
        visionToggle = new JoystickButton(opXbox,XBOX_B);
        
        chickenRelease = new JoystickButton(opXbox,XBOX_A);
        gearUp = new JoystickButton(driverLogitech,XBOX_RB);
        gearDown = new JoystickButton(driverLogitech,XBOX_LB);
    }
 
}

