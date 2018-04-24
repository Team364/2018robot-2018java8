package frc.team364.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

    public static Joystick leftStick;
    public static Joystick rightStick;
    public static Joystick operationStation;

    public static double leftPower;
    public static double rightPower;

    public static JoystickButton shiftLow;
    public static JoystickButton shiftHigh;

    public static JoystickButton clawButton;
    public static JoystickButton pinchButton;
    public static JoystickButton intakeButton;
    public static JoystickButton outtakeButton;
    public static JoystickButton liftButton;
    public static JoystickButton dropButton;
    public static JoystickButton buddyBarButton;

    public OI() {

        leftStick = new Joystick(0);
        rightStick = new Joystick(1);
        operationStation = new Joystick(2);

        leftPower = leftStick.getRawAxis(0);
        rightPower = rightStick.getRawAxis(0);

        shiftLow = new JoystickButton(leftStick, 0);
        shiftHigh = new JoystickButton(rightStick, 0);

        clawButton = new JoystickButton(operationStation, 0);
        pinchButton = new JoystickButton(operationStation, 1);
        intakeButton = new JoystickButton(operationStation, 2);
        outtakeButton = new JoystickButton(operationStation, 3);
        liftButton = new JoystickButton(operationStation, 4);
        dropButton = new JoystickButton(operationStation, 5);
        buddyBarButton = new JoystickButton(operationStation, 6);

    }
}
