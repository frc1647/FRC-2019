package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.Drive;

/**
 * Add your docs here.
 */
public class TankDrive extends Subsystem implements PIDOutput{
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Declaring variables that will be used throughout the subsystem
private WPI_VictorSPX leftDrive1;
private WPI_TalonSRX leftDrive2;
private WPI_VictorSPX rightDrive1;
private WPI_TalonSRX rightDrive2;

//Groups motor controllers together
private SpeedControllerGroup leftSide;
private SpeedControllerGroup rightSide;

//groups speedcontrollergroups together to easily set speed of the system
private DifferentialDrive driveTrain;
  
private AHRS gyro;
	
	//Gyro props
	private PIDController turnController;
	private double rotateToAngleRate;
	private final double kP = 0.00;
	private final double kI = 0.00;
	private final double kD = 0.00;
  private double kToleranceDegrees = 2.0f;
  
public TankDrive(){
  //Uses variables declared & created in the RobotMap
  leftDrive1 = RobotMap.leftMotor1;
  leftDrive2 = RobotMap.leftMotor2;
  rightDrive1 = RobotMap.rightMotor1;
  rightDrive2 = RobotMap.rightMotor2;


  //sets the speed groups based on left or right side of the robot
  leftSide = new SpeedControllerGroup(leftDrive1, leftDrive2);  
  rightSide = new SpeedControllerGroup(rightDrive1, rightDrive2);

  //puts the two speed control groups together
  driveTrain = new DifferentialDrive(leftSide, rightSide);

  turnController = new PIDController(kP,kI, kD, gyro, this);
		turnController.setInputRange(-180.0f, 180.0f);
		turnController.setOutputRange(-1.0, 1.0);
		turnController.setAbsoluteTolerance(kToleranceDegrees);
		turnController.setContinuous(true);
		turnController.disable();
}
@Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //Allows the robot to be driven without the OI as the command is always called
     setDefaultCommand(new Drive());
  }
//Sets the drive speed based on the drive command
  public void setSpeed(double leftSpeed, double rightSpeed){
    driveTrain.tankDrive(leftSpeed, rightSpeed);
  }
  public void driveStraight(double leftVal, double rightVal) {
    if(!turnController.isEnabled()) {
      // Acquire current yaw angle, using this as the target angle.
      turnController.setSetpoint(gyro.getYaw());
      rotateToAngleRate = 0; // This value will be updated in the pidWrite() method.
      turnController.enable();
    }
    double magnitude = (leftVal + rightVal) / 2;
    double leftStickValue = magnitude + rotateToAngleRate;
    double rightStickValue = magnitude - rotateToAngleRate;
    setSpeed(leftStickValue,  rightStickValue);
  }
  public void disableTurnController(){
    turnController.disable();
  }
  @Override
  public void pidWrite(double output){
    rotateToAngleRate = output;
  }
//sets drive motors to 0
public void stopDrive(){
  driveTrain.stopMotor();
}
}
