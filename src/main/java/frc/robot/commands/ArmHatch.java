/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ArmHatch extends Command {
  public ArmHatch() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.arms.setMotor(0.75);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
   // while (RobotMap.tlen2.get() == true){
      Robot.arms.setMotor(0.75);
  //  }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return RobotMap.tlen2.get();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.arms.stopMotor();
  }


  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.arms.stopMotor();
  }
}
