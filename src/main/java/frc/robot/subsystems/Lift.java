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
  public WPI_TalonSRX motorOne;
  private boolean toggle;
  
public Lift(){
  motorOne = RobotMap.liftMotor;
  toggle = false;
  motorOne.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
}



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new LiftManual());
  }
  public void setLift(double speed){
    motorOne.set(speed);
    //Robot.oi.getTabletJoystick().getRawButton(0);
   }

 public void stopLift(){
 // motorOne.stopMotor();
 motorOne.set(ControlMode.PercentOutput, 0);
// motorOne.pidWrite(0);
 }

 public double getSpeed(){
  return motorOne.get();
 }

 public void setToggle(){
  toggle = Robot.oi.getTabletJoystick().getRawButton(8);
}
  public boolean getToggle(){
return toggle;
  }
public double getOffset(){
if (toggle == true){
return -7790;
}
  else {
    return -4830;
  }
}
public void log(){
  SmartDashboard.putBoolean("Toggle Boolean: ", getToggle());
  //SmartDashboard.putBoolean("Toggle Boolean: ", Robot.oi.getTabletJoystick().getRawButton(8));
  SmartDashboard.putNumber("Offset", getOffset());
  SmartDashboard.putNumber("Talon Encoder Count: ", motorOne.getSelectedSensorPosition());
  SmartDashboard.putNumber("Lift Speed", getSpeed());
  SmartDashboard.putNumber("Lift Joystick Value: ", Robot.oi.getTabletJoystick().getRawAxis(3));
}
}

