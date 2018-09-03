package frc.team364.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

    public Joystick operationStation;
    public Joystick controller;
    public Joystick driverController;

    public JoystickButton shiftLow;
    public JoystickButton shiftHigh;

    public JoystickButton clawButton;
    public JoystickButton pinchButton;
    public JoystickButton intakeButton;
    public JoystickButton outtakeButton;
    public JoystickButton firstStageLiftButton;
    public JoystickButton resetLiftEncoderButton;
    

    public JoystickButton autoSelectorButton;
    public JoystickButton flippyShitButton;

    public OI() {

        controller = new Joystick(0);
        driverController = new Joystick(1);
        operationStation = new Joystick(2); ///Changing Main Buttons to Gamepad--all thats left is the auto switch and it's literally in a cardboard box
        

        shiftLow = new JoystickButton(driverController, 5);
        shiftHigh = new JoystickButton(driverController, 6);
       // secondClawButton = new JoystickButton(leftStick, 11);

        clawButton = new JoystickButton(controller, 5);
        pinchButton = new JoystickButton(controller, 6);
        firstStageLiftButton = new JoystickButton(controller, 4);//was 4
        resetLiftEncoderButton = new JoystickButton(controller, 1);
        //dropButton = new JoystickButton(controller, 6); --Doesn't seem to be used in the code
        //liftButton = new JoystickButton(controller, 5); --Doesn't seem to be used in the code
        flippyShitButton = new JoystickButton(controller, 2);

        //intakeButton = new JoystickButton(controller, 2);---Will be using axis for this
        //outtakeButton = new JoystickButton(controller, 2); ---Will be using axis for this
      

        autoSelectorButton = new JoystickButton(operationStation, 10);
       
    }
}
