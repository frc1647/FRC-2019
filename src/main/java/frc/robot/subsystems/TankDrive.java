package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
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
private WPI_VictorSPX leftDrive1;// = RobotMap.talon1;
private WPI_TalonSRX leftDrive2;// = RobotMap.talon2;
private WPI_VictorSPX rightDrive1;// = RobotMap.talon3;
private WPI_TalonSRX rightDrive2;// = RobotMap.talon4;

private SpeedControllerGroup leftSide;// = new SpeedControllerGroup(leftTalon1, leftTalon2);
private SpeedControllerGroup rightSide;// = new SpeedControllerGroup(rightTalon1, rightTalon2);

private DifferentialDrive driveTrain;// = new DifferentialDrive(leftSide, rightSide);
  
public TankDrive(){
  leftDrive1 = RobotMap.leftMotor1;
  leftDrive2 = RobotMap.leftMotor2;
  rightDrive1 = RobotMap.rightMotor1;
  rightDrive2 = RobotMap.rightMotor2;

  leftSide = new SpeedControllerGroup(leftDrive1, leftDrive2);  
  rightSide = new SpeedControllerGroup(rightDrive1, rightDrive2);

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
