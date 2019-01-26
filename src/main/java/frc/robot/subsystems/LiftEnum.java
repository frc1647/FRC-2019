package frc.robot.subsystems;

public enum LiftEnum{
HIGH(3000.0), MID(2000.0), LOW(1000.0);

private final double myLevel;

private LiftEnum(double myL){
myLevel = myL;
}
public double getLift(){
    return myLevel;
}
}