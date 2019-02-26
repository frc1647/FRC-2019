/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ArmManual extends Command {
  public ArmManual() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.arms);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  //   if (Robot.oi.getTabletJoystick().getRawAxis(4) > 0){
  //         Robot.arms.setMotor(0.75);
  //      }
  //      if (Robot.oi.getTabletJoystick().getRawAxis(4) < 0){
  //        Robot.arms.setMotor(-0.75);
  //     }
  //     if (Robot.oi.getTabletJoystick().getRawAxis(4) == 0){
  //      Robot.arms.setMotor(0);
  //     }
  // }
  if (Robot.oi.getLeftJoystick().getRawButton(4)){
    Robot.arms.setMotor(0.75);
  }
  else if (Robot.oi.getLeftJoystick().getRawButton(5)){
   Robot.arms.setMotor(-0.75);
  }
  else{// if (Robot.oi.getTabletJoystick().getRawAxis(3) == 0){
  Robot.lift.stopLift();}
  }
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (Robot.oi.getTabletJoystick().getRawAxis(4) > 0){
          Robot.arms.setMotor(0.75);
       }
       if (Robot.oi.getTabletJoystick().getRawAxis(4) < 0){
         Robot.arms.setMotor(-0.75);
      }
      if (Robot.oi.getTabletJoystick().getRawAxis(4) == 0){
       Robot.arms.setMotor(0);
      }
 
  }
  

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
