/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.awt.Robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
/**
 * Add your docs here.
 */
//Declaring the motors and mechanisms that will be used in the Lift subsystem
public class Lift extends Subsystem {
private WPI_VictorSPX v1 = RobotMap.v1;
private WPI_VictorSPX v2 = RobotMap.v0;
private Encoder enc = RobotMap.enc;
private DigitalInput limitSwitch = RobotMap.limitSwitch;
//Declaring other variable that will be used
private int count = enc.get();
private double kCircumference = 2*.5* Math.PI;;
  //public Lift(){
//v2.follow(v1);
  //}
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    //v2.follow(v1);
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  //Since the lift motor geabox has two motors both need to have the same speed in order spin the gears and not break
  //If nothing happens when the motors whould be spinning then diable the robot immediately
  public void manualControl(double speed){
    v1.set(speed);
    v2.set(speed);
  }
  public void stop(){
    v1.stopMotor();
    v2.stopMotor();
  }
  public int getCount(){
    return count;
  }
  /*the Rocket methods below set the lift to set positions (those being the hatch heights on the rocket)
  All the math is in inches and 255 counts makes one full revolution
  The shaft diameter is about .5 inches making the circumference PI
  If you find the ratio of count/max_count then multiply that by wheel_circumference you can find distance travelled
  You can compare the distance travelled to the how high you want to go 
  While the distance travelled is less than what is needed then turn on motors else turn off*/
  public void rocketLowHatch(){
    while ((count/255 * kCircumference) < 19 || (count/255 * kCircumference) > -19){
      manualControl(0.25);
    }
    stop();
  }
  public void rocketMidHatch(){
    while ((count/255 * kCircumference) < 47 || (count/255 * kCircumference) > -47){
      manualControl(.25);
    }
    stop();
  }
  public void rocketHighHatch(){
    while ((count/255 * kCircumference) < 75 || (count/255 * kCircumference) > -75){
      manualControl(0.25);
      if (limitSwitch.get() == true){ stop(); }
    }
    stop();
  }
}
