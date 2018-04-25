/*
 * George and Keandre:
 * This is the PID calculation class. It calculates a PIDF output for
 * a motor using a setpoint and actual values.
 * Create an object for each subsystem that needs to use PID and run resetPID() and then
 * calculateOutput().
 */

package frc.team364.robot;

public class PIDCalc {

    private double kP = 0;
    private double kI = 0;
    private double kD = 0;
    private double kF = 0;
    private double derivative = 0;
    private double integral = 0;
    private double prev_error = 0;
    private double error = 0;

    public PIDCalc(double pTerm, double iTerm, double dTerm, double fTerm) {
        kP = pTerm;
        kI = iTerm;
        kD = dTerm;
        kF = fTerm;
    }

    public double calculateOutput(double setpoint, double actual) {
        error = setpoint - actual;
        integral += (error * 0.02);
        derivative = (error - prev_error) / 0.02;
        return kF + (kP * error) + (kI * integral) + (kD * derivative);
    }

    public void resetPID() {
        derivative = 0;
        integral = 0;
        prev_error = 0;
        error = 0;
    }

}
