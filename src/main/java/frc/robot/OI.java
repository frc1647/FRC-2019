/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ExampleClose;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.LiftManual;
import frc.robot.commands.LiftMove;
import frc.robot.commands.ToggleLift;
import frc.robot.subsystems.LiftEnum;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
Joystick tab;
Joystick lDrive;
Joystick rDrive;

public OI(){
  tab = RobotMap.tablet;
  lDrive = RobotMap.driveLeft;
  rDrive = RobotMap.driveRight;

  //Buttons on the joystick
 Button motorTest = new JoystickButton(tab, 1),
        motorStop = new JoystickButton(tab, 2),
        manualLift = new JoystickButton(tab, 3),
        liftLow = new JoystickButton(tab, 4),
        liftMid = new JoystickButton(tab, 5),
        liftHigh = new JoystickButton(tab, 6),
        toggleLift = new JoystickButton(tab, 7);



  //What happens when certain buttons are pressed
  //Each button relates to a single command
  toggleLift.toggleWhenPressed(new ToggleLift());       
  manualLift.whenPressed(new LiftManual());
  motorTest.whenPressed(new ExampleCommand());
  motorStop.whenPressed(new ExampleClose());
  liftLow.whenPressed(new LiftMove(LiftEnum.LOW));
  liftMid.whenPressed(new LiftMove(LiftEnum.MID));
  liftHigh.whenPressed(new LiftMove(LiftEnum.HIGH));

  toggleLift.close();
  motorTest.close();
  motorStop.close();
  manualLift.close();
  liftLow.close();
  liftMid.close();
  liftHigh.close();
}

//Gets joysticks so they can be used for controlling speeds in various commands
public Joystick getTabletJoystick(){
  return tab;
}
public Joystick getLeftJoystick(){
  return tab;
}
public Joystick getRightJoystick(){
  return tab;
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
