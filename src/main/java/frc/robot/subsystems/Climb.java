/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

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
  private WPI_VictorSPX backMotor;
  private Solenoid frontSol1;
  private Solenoid frontSol2;
  private Solenoid backSol1;
  private Solenoid backSol2;

  public Climb(){
    frontMotor = RobotMap.frontLeg;
    backMotor = RobotMap.backLeg;
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
  public void setFront(boolean position){
//frontMotor.set(speed);
frontSol1.set(position);
frontSol2.set(position);
  }
  public void setBack(boolean position){
//backMotor.set(speed);
backSol1.set(false);
backSol2.set(false);
  }
  public void stop(){
    backMotor.stopMotor();
    frontMotor.stopMotor();
  }

}
