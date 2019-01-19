/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
private WPI_VictorSPX v1 = RobotMap.v1;
private WPI_VictorSPX v2 = RobotMap.v0;


  //public Lift(){
//v2.follow(v1);
  //}
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    //v2.follow(v1);
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  //Since the lift motor geabox has two motors both need to have the same speed in order spin the gears and not break
  //If nothing happens when the motors whould be spinning then diable the robot immediately
  public void setLiftSpeed(double speed){
    v1.set(speed);
    v2.set(speed);
  }
  public void stop(){
    v1.stopMotor();
    v2.stopMotor();
  }
}
