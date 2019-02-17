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
import frc.robot.RobotMap;
import frc.robot.commands.LiftManual;

/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public WPI_TalonSRX motor1;
  private boolean toggle;
  
public Lift(){
  motor1 = RobotMap.liftMotor1;
  
  motor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
}



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new LiftManual());
  }
  public void setLift(double speed){
    motor1.pidWrite(speed);
    //Robot.oi.getTabletJoystick().getRawButton(0);
   }

 public void stopLift(){
 // motor1.stopMotor();
 motor1.set(ControlMode.PercentOutput, 0);
// motor1.pidWrite(0);
 }

 public double getSpeed(){
  return motor1.get();
 }

 public void setToggle(){
  toggle = !toggle;
}
public double getOffset(){
if (toggle == true){
return 372048.0;
}
  else {
    return 252543.0;}
}
}

