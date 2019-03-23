/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
// import io.github.pseudoresonance.pixy2api.Pixy2;
// import io.github.pseudoresonance.pixy2api.Pixy2.LinkType;
// import io.github.pseudoresonance.pixy2api.links.SPILink;
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;


//Lift motor
public static WPI_TalonSRX liftMotor = new WPI_TalonSRX(5);

//Motorcontrolers for drive
public static WPI_VictorSPX leftMotor1 = new WPI_VictorSPX(4);
public static WPI_TalonSRX leftMotor2 = new WPI_TalonSRX(8);
public static WPI_VictorSPX rightMotor1 = new WPI_VictorSPX(5);
public static WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(9);

//Controller for robot operations
public static Joystick tablet = new Joystick(0);

//Joyticks for driving
public static Joystick joystick1 = new Joystick(1);
public static Joystick joystick2 = new Joystick(2);

//Motor controller for the arm/ pivot motor
public static WPI_VictorSPX armPivot = new WPI_VictorSPX(2);

//Limit Switch for the lift
public static DigitalInput highLimit = new DigitalInput(0);

//Motor Controllers for climbing
public static WPI_VictorSPX frontLeg = new WPI_VictorSPX(0);
public static WPI_VictorSPX backLeg = new WPI_VictorSPX(1);

//Declaring Pistons
// public static Solenoid frontSol1 = new Solenoid(0);
// public static Solenoid frontSol2 = new Solenoid(1);
// public static Solenoid backSol1 = new Solenoid(2);
// public static Solenoid backSol2 = new Solenoid(3);
  // If you are using multipe modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
