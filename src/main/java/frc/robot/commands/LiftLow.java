/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class LiftLow extends Command {
  private double desiredHeight;
  private double currentHeight;
  private double tolerance;
  private double offset;
  private WPI_TalonSRX liftMotor;
  
  public LiftLow() {
    liftMotor = RobotMap.liftMotor;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    currentHeight = liftMotor.getSelectedSensorPosition(0);
    tolerance = -26578.0;
offset = Robot.lift.getOffset();
//     if (Robot.oi.getTabletJoystick().getRawButton(8)){
// offset = 372048;
//     }
//     else{
// offset = 252543.0;
    //}
    desiredHeight = offset;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
   // while (desiredHeight - currentHeight <= tolerance || desiredHeight - currentHeight >= tolerance){
        if (desiredHeight - currentHeight < 0){
      Robot.lift.setLift(-0.5);
    }
    else{
      Robot.lift.setLift(0.5);
    }
   // }
  

  }
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Math.abs(currentHeight - desiredHeight) < tolerance;
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
