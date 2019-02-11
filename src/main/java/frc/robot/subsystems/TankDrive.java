package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.Drive;

/**
 * Add your docs here.
 */
public class TankDrive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
private WPI_VictorSPX leftTalon1;// = RobotMap.talon1;
private WPI_VictorSPX leftTalon2;// = RobotMap.talon2;
private WPI_VictorSPX rightTalon1;// = RobotMap.talon3;
private WPI_VictorSPX rightTalon2;// = RobotMap.talon4;

private SpeedControllerGroup leftSide;// = new SpeedControllerGroup(leftTalon1, leftTalon2);
private SpeedControllerGroup rightSide;// = new SpeedControllerGroup(rightTalon1, rightTalon2);

private DifferentialDrive driveTrain;// = new DifferentialDrive(leftSide, rightSide);
  
public TankDrive(){
  leftTalon1 = RobotMap.leftMotor1;
  leftTalon2 = RobotMap.leftMotor2;
  rightTalon1 = RobotMap.rightMotor1;
  rightTalon2 = RobotMap.rightMotor2;

  leftSide = new SpeedControllerGroup(leftTalon1, leftTalon2);  
  rightSide = new SpeedControllerGroup(rightTalon1, rightTalon2);

  driveTrain = new DifferentialDrive(leftSide, rightSide);
}
@Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new Drive());
  }

  public void setSpeed(double leftSpeed, double rightSpeed){
    driveTrain.tankDrive(leftSpeed, rightSpeed);
  }
public void arcade(double forwardSpeed, double turnSpeed){
driveTrain.arcadeDrive(forwardSpeed, turnSpeed);
}
}
