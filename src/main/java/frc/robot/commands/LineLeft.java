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

public class LineLeft extends Command {
  private DigitalInput lSensor;
  private DigitalInput mSensor;
  private DigitalInput rSensor;

  public LineLeft() {
    // lSensor = RobotMap.tlen1;//linesensorLeft;
    // mSensor = RobotMap.tlen2;//lineSensorMid;
    // rSensor = RobotMap.tlen3;//lineSensorRight;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //If the center an right sensors are false then move to the left to center the robot
    if ((lSensor.get() == true) && (mSensor.get() == false) && (rSensor.get() == false)){
      Robot.tankDrive.arcade(0.75, -0.25);
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
