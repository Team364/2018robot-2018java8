package frc.team364.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.networktables.*;
import frc.team364.robot.PIDCalc;
import frc.team364.robot.commands.VisionCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VisionSystem extends Subsystem {

    public NetworkTableEntry centerX;
    public NetworkTableEntry area;
    public PIDCalc pid;
    public double pidOutput;
    public PIDCalc pida;
    public double pidOutputa;
    public double[] x;
    public double[] a;


    public VisionSystem() {
        NetworkTableInstance inst = NetworkTableInstance.getDefault();
        NetworkTable table = inst.getTable("GRIP/contours");
        centerX = table.getEntry("centerX");
        area = table.getEntry("area");
        double[] defaultValue = {160.0};
        double[] defaultValuea = {7000};
        x = centerX.getDoubleArray(defaultValue);
        a = area.getDoubleArray(defaultValuea);
        SmartDashboard.putNumberArray("xarray", x);
    }

    protected void initDefaultCommand() {
       setDefaultCommand(new VisionCommand());
    }


    public double getCenterX(){
        return x[0];
    }

    public double getArea(){
        return a[0];
    }

    public boolean lockedOn(){
        if((x[0] > 130) && (x[0] < 190)){
            return true;
        }else{
            return false;
        }
    }
    public boolean cubeInSight(){
        if(x.length >= 1){
            return true;
        }else{
            return false;
        }
    }
    public boolean cubeInSightArea(double[] aValue){
        if(aValue.length >= 1){
            return true;
        }else{
            return false;
        }
    }
}