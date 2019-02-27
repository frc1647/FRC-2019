/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class LiftManual extends Command {
  private DigitalInput lowLim;
  private DigitalInput highLim;
  private WPI_TalonSRX liftMotor;

  public LiftManual() {
    liftMotor = RobotMap.liftMotor;
    highLim = RobotMap.highLimit;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
   requires(Robot.lift);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    if (Robot.oi.getTabletJoystick().getRawAxis(3) > 0){
      Robot.lift.setLift(0.75);
   }
  else if (Robot.oi.getTabletJoystick().getRawAxis(3) < 0){
     Robot.lift.setLift(-0.75);
  }
  else if (Robot.oi.getTabletJoystick().getRawAxis(3) == 0){
   Robot.lift.stopLift();
  }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.lift.setToggle();
   if (Robot.oi.getTabletJoystick().getRawAxis(3) > 0){
    Robot.lift.setLift(1.0);
 }
else if (Robot.oi.getTabletJoystick().getRawAxis(3)< 0){
   Robot.lift.setLift(-1.0);
}
else if (Robot.oi.getTabletJoystick().getRawAxis(3) == 0){
 Robot.lift.stopLift();
}

}
//Robot.lift.setSetpoint(RobotMap.liftMotor1.getSelectedSensorPosition(0));

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;//highLim.get();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
   // if (highLim.get()){
    Robot.lift.stopLift();
  //}
 
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
