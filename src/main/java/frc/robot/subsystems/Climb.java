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

  private WPI_TalonSRX frontMotor;
  private WPI_VictorSPX climbWheel;
  private Solenoid backSol1;
  private Solenoid backSol2;

  public Climb(){
    frontMotor = RobotMap.climbPivot;
    climbWheel = RobotMap.climbWheel;
    backSol1 = RobotMap.backSol1;
    backSol2 = RobotMap.backSol2;
    
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void setFront(double speed){
frontMotor.set(speed);
//climbWheel.set(speed);
  }
  public void setBack(boolean position){
backSol1.set(position);
backSol2.set(position);
  }
  public void setWheel(double speed){
climbWheel.set(speed);
  }
  public void stop(){
    frontMotor.stopMotor();
    climbWheel.stopMotor();
  }

}
