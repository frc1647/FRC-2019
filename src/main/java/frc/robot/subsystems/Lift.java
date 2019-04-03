/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.LiftManual;

/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  //Declares the variables that will be used throughuot the lift subsystem
  private static WPI_TalonSRX motorOne;
  private double tolerance = 200;
  private double goalHeight;

public Lift(){
  goalHeight = 0;
  //Uses variables from RobotMap 
  motorOne = RobotMap.liftMotor;
  motorOne.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //Allows the lift to be controlled by the slider whenever the robot is enabled
    setDefaultCommand(new LiftManual());
  }
  //Sets speed of the lift as determined by the commands
  public void setLift(double speed){
    motorOne.set(speed);
   }
public void setPosition(double desiredHeight){
  goalHeight = desiredHeight;
  if (desiredHeight - getCount() < 0){
    setLift(-0.5);
  }
  else{
    setLift(0.5);
  }
delta();
}
public boolean delta(){
if (getCount() - goalHeight < tolerance){
  return true;
}
else {
   return false;
}
}
//Sets lift speed to 0 essentiall stopping it
 public void stopLift(){
 motorOne.set(ControlMode.PercentOutput, 0);
 }
//Gets the speed of the lift
 public double getSpeed(){
  return motorOne.get();
 }
public double getCount(){
 return motorOne.getSelectedSensorPosition(0);
}
//Sends various data about the lift to the SmartDashboard
public void log(){
  SmartDashboard.putNumber("Talon Encoder Count: ", getCount());
  SmartDashboard.putNumber("Lift Speed", getSpeed());
  SmartDashboard.putNumber("Lift Joystick Value: ", Robot.oi.getTabletJoystick().getRawAxis(3));
}
}

