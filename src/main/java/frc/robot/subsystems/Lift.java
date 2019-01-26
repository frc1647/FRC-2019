/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Lift extends PIDSubsystem {
private WPI_VictorSPX motor1;// = RobotMap.v1;
private WPI_VictorSPX motor2;// = RobotMap.v0;
private Encoder enc;// = RobotMap.enc;
private boolean toggle;
  /**
   * Add your docs here.
   */
  public Lift() {
    // Intert a subsystem name and PID values here
    super("Lift", 1, 0, 0);
    setAbsoluteTolerance(0.2);
    getPIDController().setContinuous();

    motor1 = RobotMap.liftMotor1;
    motor2 = RobotMap.liftMotor2;
    enc = RobotMap.enc;
    toggle = false;

    motor2.follow(motor1);
    enable();
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return enc.get();
  }
@Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
  motor1.set(output);
  }
  public void setToggle(){
    toggle = !toggle;
  }
  public double getOffset(){
if (toggle == false){
  return 500;
}
else if (toggle == true){
  return 1000;
}
    return 0.0;
  }
  public void manual(double speed){
    motor1.set(speed);
  }
  public void stopLift(){
    motor1.set(0.0);
  }
}
