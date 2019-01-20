/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

//Test talons on the testbench
public static WPI_TalonSRX t8 = new WPI_TalonSRX(8);
public static WPI_TalonSRX t9 = new WPI_TalonSRX(9);

//Victors for the lift
public static WPI_VictorSPX v0 = new WPI_VictorSPX(0);
public static WPI_VictorSPX v1 = new WPI_VictorSPX(1);

public static Joystick leftJoy = new Joystick(1);

//The encoder has a count of 255 per revolution
public static Encoder enc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);

//Declaring limit switch for lift and Hall Effect sensor for arms
//The limit switch makes sure the lift doesn't go too high and break the robot
//The hall Effect sensor would stop the arms at certain points
public static DigitalInput limitSwitch = new DigitalInput(0);
public static DigitalInput hallEffect = new DigitalInput(1);

  // If you are using multipe modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
