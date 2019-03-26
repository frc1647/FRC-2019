/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Climb extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_VictorSPX frontMotor;
  private WPI_TalonSRX wheelMotor;
  private Solenoid backSol1;
  private Solenoid backSol2;

  public Climb(){
    frontMotor = RobotMap.wheelPivot;
    // frontSol1 = RobotMap.frontSol1;
    // frontSol2 = RobotMap.frontSol2;
    // backSol1 = RobotMap.backSol1;
    // backSol2 = RobotMap.backSol2;
    
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void setFront(double speed){
frontMotor.set(speed);
  }
  public void setBack(boolean position){
backSol1.set(false);
backSol2.set(false);
  }
public void setClimbWheels(double speed){
wheelMotor.set(speed);
}
  public void stop(){
    frontMotor.stopMotor();
  }

}
