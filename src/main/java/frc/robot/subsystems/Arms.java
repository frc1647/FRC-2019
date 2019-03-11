/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.ArmManual;

/**
 * Add your docs here.
 */
public class Arms extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  //Motor controller for the arms
  private static WPI_VictorSPX motor = RobotMap.windowMotor;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //Allows the arms to be controlled by the right slider on the tablet
    setDefaultCommand(new ArmManual());
  }

//Sets motor speed as determined by commands  
public void setMotor(double speed){
  motor.set(speed);
}

//Stops the motor
public void stopMotor(){
  motor.stopMotor();
}

//Sends data to the SmartDashboard about the arm subsystem
public void log(){
  SmartDashboard.putNumber("Arm Speed", RobotMap.windowMotor.get());
}

}
