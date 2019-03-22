/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ArmManual extends Command {
  public ArmManual() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.arms);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Original code to use right tablet slider to control arm motion
    if (Robot.oi.getTabletJoystick().getRawAxis(4) > 0){
          Robot.arms.setMotor(0.5);
       }
      else if (Robot.oi.getTabletJoystick().getRawAxis(4) < 0){
         Robot.arms.setMotor(-0.5);
      }
  //     if (Robot.oi.getTabletJoystick().getRawAxis(4) == 0){
  //      Robot.arms.setMotor(0);
  //     }
  // }
   //Checks if raise and lower buttons are pressed and raises and lowers if one of the buttons is being pressed
if (Robot.oi.getLeftJoystick().getRawButton(4)){
  Robot.arms.setMotor(0.5);
}
else if (Robot.oi.getRightJoystick().getRawButton(5)){
 Robot.arms.setMotor(-0.5);
}
else{
  Robot.arms.stopMotor();
}
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      //Original code to use right tablet slider to control arm motio
    if (Robot.oi.getTabletJoystick().getRawAxis(4) < 0){
          Robot.arms.setMotor(0.5);
       }
    else if (Robot.oi.getTabletJoystick().getRawAxis(4) > 0){
         Robot.arms.setMotor(-0.5);
      }
    // else if (Robot.oi.getTabletJoystick().getRawAxis(4) == 0){
    //    Robot.arms.setMotor(0);
    //   }
 //Checks if raise and lower buttons are pressed and raises and lowers if one of the buttons is being pressed
    if (Robot.oi.getLeftJoystick().getRawButton(4)){
        Robot.arms.setMotor(0.5);
      }
    else if (Robot.oi.getLeftJoystick().getRawButton(3)){
       Robot.arms.setMotor(-0.5);
      }
    else{
        Robot.arms.stopMotor();
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
