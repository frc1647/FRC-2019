/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LiftMove extends Command {
  private double distance;
  public LiftMove() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
   // requires(Robot.lift);
  }
public LiftMove(double motorCounts){
  distance = motorCounts;
}

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
     Robot.lift.setSetpoint(distance + Robot.lift.getOffset());
  }
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Math.abs(Robot.lift.getSetpoint() - Robot.lift.getPosition()) < .2;
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
