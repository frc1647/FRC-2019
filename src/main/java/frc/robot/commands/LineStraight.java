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

public class LineStraight extends Command {
  private DigitalInput lSensor;// = RobotMap.rightAngleSen1;
  private DigitalInput mSensor;// = RobotMap.rightAngleSen2;
  private DigitalInput rSensor;// = RobotMap.rightAngleSen3;

  public LineStraight() {
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
    //if the Left and right motors don't see anything, but the center does keep going straight
    if ((lSensor.get() == false) && (mSensor.get() == true) && (rSensor.get() == false)){
      Robot.tankDrive.arcade(0.75, 0.0);
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
