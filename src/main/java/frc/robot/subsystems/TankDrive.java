/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class TankDrive extends Subsystem {
  //Motor declarations from RobotMap
  private WPI_VictorSPX lDrive1;// = RobotMap.leftDrive1;
  private WPI_VictorSPX lDrive2;// = RobotMap.leftDrive2;
  private WPI_VictorSPX rDrive1;// = RobotMap.rightDrive1;
  private WPI_VictorSPX rDrive2;// = RobotMap.RightDrive2;

  //Motor control groups
  private SpeedControllerGroup leftDrive;// = new SpeedControllerGroup(lDrive1, lDrive2);
  private SpeedControllerGroup rightDrive;// = new SpeedControllerGroup(rDrive1, rDrive2);

  //
  private DifferentialDrive driveTrain;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
public TankDrive(){
  lDrive1 = RobotMap.leftDrive1;
  lDrive2 = RobotMap.leftDrive2;
  rDrive1 = RobotMap.rightDrive1;
  rDrive2 = RobotMap.RightDrive2;

  leftDrive = new SpeedControllerGroup(lDrive1, lDrive2);
  rightDrive = new SpeedControllerGroup(rDrive1, rDrive2);

  driveTrain = new DifferentialDrive(leftDrive, rightDrive);
}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void tankDrive(double leftSpeed, double rightSpeed){
    driveTrain.tankDrive(leftSpeed, rightSpeed);
  }
}
