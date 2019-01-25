/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class EncoderTest extends Command {
  private Encoder enc = RobotMap.enc;

  private double kCircumference = 2*.5* Math.PI;

  public EncoderTest() {
   
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
      
     //Since the count can be translated into revolutions this stops the motors after one revolution
    int count = enc.get();
    double distance = count/255 * kCircumference;
    //System.out.println(count);
    //255 counts equals one full revolution
    //If you find the ratio of count/max_count then multiply that by wheel_circumference you can find distance travelled
    if (count/255 * kCircumference <= 19 || count/255 * kCircumference <= -19 ){
      System.out.println(count);
      // Robot.m_exs.reset();
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
