package kbot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import kbot.robot.RobotMap;

public class Pistons extends Subsystem 
{    
    DoubleSolenoid gearPiston = RobotMap.gearPiston;
    DoubleSolenoid chickenLittle = RobotMap.chickenLittle;
    DoubleSolenoid aimingPiston = RobotMap.aimingPiston;
    DoubleSolenoid hanger = RobotMap.hanger;
    Compressor compressor = RobotMap.compressor;
    
    private DoubleSolenoid.Value previousChicken = RobotMap.chickenLittle.get(); //false
    private DoubleSolenoid.Value previousShooter = RobotMap.aimingPiston.get(); //false

    public void initDefaultCommand() 
    {}
    
    public void gearChange(DoubleSolenoid.Value change)
    {
        gearPiston.set(change);
    }
    
    //Toggles height of hooks
    public void toggleChicken()
    {
        if(previousChicken == DoubleSolenoid.Value.kForward)
        {
            chickenLittle.set(DoubleSolenoid.Value.kReverse);
            previousChicken = DoubleSolenoid.Value.kReverse;
        }
        else if(previousChicken == DoubleSolenoid.Value.kReverse)
        {
            chickenLittle.set(DoubleSolenoid.Value.kForward);
            previousChicken = DoubleSolenoid.Value.kForward;
        }
    }
    
    //Toggles position of shooter
    public void toggleShooter()
    {
        if(previousShooter == DoubleSolenoid.Value.kForward)
        {
            aimingPiston.set(DoubleSolenoid.Value.kReverse);
            previousShooter = DoubleSolenoid.Value.kReverse;
        }
        else if(previousShooter == DoubleSolenoid.Value.kReverse)
        {
            aimingPiston.set(DoubleSolenoid.Value.kForward);
            previousShooter = DoubleSolenoid.Value.kForward;
        }
    }
    
    public void setShooter(DoubleSolenoid.Value val)
    {
        aimingPiston.set(val);
    }
    
    public void chickenDown()
    {
        chickenLittle.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void gasShocksDown()
    {
        hanger.set(DoubleSolenoid.Value.kReverse);
    }
    
    //Toggles onboard compressor to save battery power
    public void compressorOnOff()
    {
        if(compressor.enabled() == true)
        {
            compressor.stop();
        }
        else if(compressor.enabled() == false)
        {
            compressor.start();
        }
    }
}
