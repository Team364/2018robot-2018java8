package frc.team364.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

    public Joystick leftStick;
    public Joystick rightStick;
    public Joystick operationStation;
    public Joystick controller;

    public double leftPower;
    public double rightPower;

    public JoystickButton shiftLow;
    public JoystickButton shiftHigh;
    //public JoystickButton secondClawButton;

    public JoystickButton clawButton;
    public JoystickButton pinchButton;
    public JoystickButton intakeButton;
    public JoystickButton outtakeButton;
    public JoystickButton firstStageLiftButton;
    //public JoystickButton liftButton;
    //public JoystickButton dropButton;
    //public JoystickButton buddyBarButton;
    

    public JoystickButton autoSelectorButton;
    public JoystickButton flippyShitButton;

    public OI() {

        leftStick = new Joystick(0);
        rightStick = new Joystick(1);
        operationStation = new Joystick(2); ///Changing Main Buttons to Gamepad--all thats left is the auto switch and it's literally in a cardboard box
        controller = new Joystick(3);

        shiftLow = new JoystickButton(leftStick, 1);
        shiftHigh = new JoystickButton(rightStick, 1);
       // secondClawButton = new JoystickButton(leftStick, 11);

        clawButton = new JoystickButton(controller, 6);
        pinchButton = new JoystickButton(controller, 5);
        firstStageLiftButton = new JoystickButton(controller, 4);
        //dropButton = new JoystickButton(controller, 6); --Doesn't seem to be used in the code
        //liftButton = new JoystickButton(controller, 5); --Doesn't seem to be used in the code
        //buddyBarButton = new JoystickButton(controller, 4); --we are not using this on the robot anymore
        flippyShitButton = new JoystickButton(controller, 2);

        intakeButton = new JoystickButton(controller, 2);
        outtakeButton = new JoystickButton(controller, 2);
      

        autoSelectorButton = new JoystickButton(operationStation, 10);
       
    }
}
