package frc.team364.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

    public Joystick leftStick;
    public Joystick rightStick;
    public Joystick operationStation;

    public double leftPower;
    public double rightPower;

    public JoystickButton shiftLow;
    public JoystickButton shiftHigh;

    public JoystickButton clawButton;
    public JoystickButton pinchButton;
    public JoystickButton intakeButton;
    public JoystickButton outtakeButton;
    public JoystickButton firstStageLiftButton;
    public JoystickButton liftButton;
    public JoystickButton dropButton;
    public JoystickButton buddyBarButton;

    public JoystickButton autoSelectorButton;

    public OI() {

        leftStick = new Joystick(0);
        rightStick = new Joystick(1);
        operationStation = new Joystick(2);

        shiftLow = new JoystickButton(leftStick, 1);
        shiftHigh = new JoystickButton(rightStick, 1);

        clawButton = new JoystickButton(operationStation, 6);
        pinchButton = new JoystickButton(operationStation, 3);
        intakeButton = new JoystickButton(operationStation, 1);
        outtakeButton = new JoystickButton(operationStation, 2);
        firstStageLiftButton = new JoystickButton(operationStation, 5);
        liftButton = new JoystickButton(operationStation, 5);
        dropButton = new JoystickButton(operationStation, 6);
        buddyBarButton = new JoystickButton(operationStation, 4);

        autoSelectorButton = new JoystickButton(operationStation, 10);
    }
}
