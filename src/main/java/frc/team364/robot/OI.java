package frc.team364.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

    public Joystick leftStick;
    public Joystick rightStick;
    
    public JoystickButton shiftLow;
    public JoystickButton shiftHigh;

    public OI() {

        leftStick = new Joystick(0);
        rightStick = new Joystick(1);

        shiftLow = new JoystickButton(leftStick, 1);
        shiftHigh = new JoystickButton(rightStick, 1);
       
       
    }
}
