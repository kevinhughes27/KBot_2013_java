package kbot.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import kbot.commands.*;
import kbot.wrappers.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    JoystickButton shooterToggle;
    JoystickButton increaseShooterSpeed;
    JoystickButton decreaseShooterSpeed;
    JoystickButton resetSpeed;
    
    //Driver buttons
    JoystickButton chickenToggle;
    JoystickButton gearUp;
    JoystickButton gearDown;
    JoystickButton hangerDeploy;
    JoystickButton toggleCompressor;
    
    public OI()
    {
        //Sets the speed of the shooter wheels
        SmartDashboard.putNumber("Wheel Speed: ", -0.8);
        
        //Joysticks
        driverLogitech = new XboxController(DRIVER_PORT);
        opXbox = new XboxController(OPERATOR_PORT);

        //Operator buttons
        push = new JoystickButton(opXbox.m_joy, opXbox.XBOX_A);
        shooterToggle = new JoystickButton(opXbox.m_joy, opXbox.XBOX_LB);
        shoot = new JoystickButton(opXbox.m_joy, opXbox.XBOX_RB);
        increaseShooterSpeed = new JoystickButton(opXbox.m_joy, opXbox.XBOX_X);
        decreaseShooterSpeed = new JoystickButton(opXbox.m_joy, opXbox.XBOX_B);
        resetSpeed = new JoystickButton(opXbox.m_joy, opXbox.XBOX_Y);
        toggleCompressor = new JoystickButton(opXbox.m_joy, opXbox.XBOX_START);

        //Driver buttons
        chickenToggle = new JoystickButton(driverLogitech.m_joy, driverLogitech.XBOX_A);
        gearUp = new JoystickButton(driverLogitech.m_joy, driverLogitech.XBOX_RB);
        gearDown = new JoystickButton(driverLogitech.m_joy, driverLogitech.XBOX_LB);
        hangerDeploy = new JoystickButton(driverLogitech.m_joy, driverLogitech.XBOX_Y);
        
        //Operator button - initialize commands
        push.whileHeld(new PushFrisbee());
        shooterToggle.whenPressed(new ToggleAim());
        shoot.whileHeld(new SpinUpShooter());
        increaseShooterSpeed.whenPressed(new IncreaseShooterSpeed());
        decreaseShooterSpeed.whenPressed(new DecreaseShooterSpeed());
        resetSpeed.whenPressed(new ResetShooterSpeed());
        toggleCompressor.whenPressed(new CompressorOnOff());
        
        //Driver buttons - initialize commands
        chickenToggle.whenPressed(new ChickenRelease());
        gearUp.whenPressed(new GearUp());
        gearDown.whenPressed(new GearDown());
        hangerDeploy.whenPressed(new HangerButton());
    }
}

