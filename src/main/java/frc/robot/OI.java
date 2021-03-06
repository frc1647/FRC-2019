/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ClimbWheel;
import frc.robot.commands.DriveStraight;
import frc.robot.commands.LiftHigh;
import frc.robot.commands.LiftLow;
import frc.robot.commands.LiftMid;
import frc.robot.commands.LowerArm;
import frc.robot.commands.LowerBack;
import frc.robot.commands.LowerFront;
import frc.robot.commands.RaiseArm;
import frc.robot.commands.RaiseBack;
import frc.robot.commands.RaiseFront;
import frc.robot.commands.test;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
//Creates joystick instances that will be the joysticks declared inthe RobotMap
Joystick tab;
Joystick lDrive;
Joystick rDrive;

public OI(){
  //Setting the joysticks to what was delcared in the RobotMap
  tab = RobotMap.tablet;
  lDrive = RobotMap.joystick1; //Make sure this is 1 on frc driver station
  rDrive = RobotMap.joystick2; //Make sure this is 2 on frc driver station

  //Buttons on the joystick
      JoystickButton
        liftLow = new JoystickButton(tab, 3),
        liftMid = new JoystickButton(tab, 2),
        liftHigh = new JoystickButton(tab, 1),
        raiseArm = new JoystickButton(tab, 5),
        lowerArm = new JoystickButton(tab, 6),
        lowerFront = new JoystickButton(tab, 7),
        raiseFront = new JoystickButton(tab, 8),
        raiseBack = new JoystickButton(tab, 9),
        lowerBack = new JoystickButton(tab, 10),

        climbWheel = new JoystickButton(lDrive, 1),
        test = new JoystickButton(rDrive, 1),

        driveStraight = new JoystickButton(lDrive, 2);

  //What happens when certain buttons are pressed
  //Each button relates to a single command
  liftLow.whenPressed(new LiftLow());
  liftMid.whenPressed(new LiftMid());
  liftHigh.whenPressed(new LiftHigh());
  raiseArm.whileHeld(new RaiseArm());
  lowerArm.whileHeld(new LowerArm());
  lowerFront.whileHeld(new LowerFront());
  raiseFront.whileHeld(new RaiseFront());
  raiseBack.whileHeld(new RaiseBack());
  lowerBack.whileHeld(new LowerBack());
  driveStraight.whileHeld(new DriveStraight());

  test.whileHeld(new test());
  climbWheel.whileHeld(new ClimbWheel());

  //closes the buttons (personally idk why this has to be done but it doesn't break anything)
  liftLow.close();
  climbWheel.close();
  liftMid.close();
  liftHigh.close();
  raiseArm.close();
  lowerArm.close();
  lowerFront.close();
  raiseFront.close();
  raiseBack.close();
  lowerBack.close();
  driveStraight.close();
}

//Gets joysticks so they can be used for controlling speeds in various commands
public Joystick getTabletJoystick(){
  return tab;
}
public Joystick getLeftJoystick(){
  return lDrive;
}
public Joystick getRightJoystick(){
  return rDrive;
}
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
