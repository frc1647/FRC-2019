/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
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
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;


//Victors for the lift
// public static WPI_VictorSPX liftMotor1 = new WPI_VictorSPX(0);
// public static WPI_VictorSPX liftMotor2 = new WPI_VictorSPX(1);
//backup talons for lift
public static WPI_VictorSPX liftMotor1 = new WPI_VictorSPX(3);
public static WPI_VictorSPX liftMotor2 = new WPI_VictorSPX(0);

//Victors for drive
// public static WPI_VictorSPX leftDrive1 = new WPI_VictorSPX(2);
// public static WPI_VictorSPX leftDrive2 = new WPI_VictorSPX(3);
// public static WPI_VictorSPX rightDrive1 = new WPI_VictorSPX(4);
// public static WPI_VictorSPX RightDrive2 = new WPI_VictorSPX(5);
//Backup talons for drive
public static WPI_VictorSPX leftMotor1 = new WPI_VictorSPX(4);
public static WPI_TalonSRX leftMotor2 = new WPI_TalonSRX(8);
public static WPI_VictorSPX rightMotor1 = new WPI_VictorSPX(5);
public static WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(9);


//Controller for robot operations
public static Joystick tablet = new Joystick(0);

//Joyticks for drive
public static Joystick driveLeft = new Joystick(1);
public static Joystick driveRight = new Joystick(2);

//The encoder for the lift that has a count of 1024 per revolution
public static Encoder redLineEnc = new Encoder(8, 9, false, Encoder.EncodingType.k4X);

//Declaring sensors for arms and limit switches for lift
//The limit switch makes sure the lift doesn't go too high and break the robot
//The touchless encoder sensor would stop the arms at certain points by identifying a changes on metal surfaces

//public static DigitalInput linesensorLeft = new DigitalInput(3);
//public static DigitalInput lineSensorMid = new DigitalInput(5);
//public static DigitalInput lineSensorRight = new DigitalInput(6);

public static DigitalInput tlen1 = new DigitalInput(0);
public static DigitalInput tlen2 = new DigitalInput(1);
public static DigitalInput tlen3 = new DigitalInput(2);
public static DigitalInput tlen4 = new DigitalInput(3);
public static DigitalInput tlen5 = new DigitalInput(4);

//Motor controller for the arm motor
//public static WPI_VictorSPX armMotor = new WPI_VictorSPX(6);
//backup talon for arms
public static WPI_VictorSPX windowMotor = new WPI_VictorSPX(2);

// public static DigitalInput rightAngleSen1 = new DigitalInput(4);
//   public static DigitalInput rightAngleSen2 = new DigitalInput(5);
//   public static DigitalInput rightAngleSen3 = new DigitalInput(6);
  // If you are using multipe modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
