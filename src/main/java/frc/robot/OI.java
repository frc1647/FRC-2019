/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ArmCloseBall;
import frc.robot.commands.ArmHatch;
import frc.robot.commands.ArmInitial;
import frc.robot.commands.ArmOpenBall;
import frc.robot.commands.LiftHigh;
import frc.robot.commands.LiftInit;
import frc.robot.commands.LiftLow;
import frc.robot.commands.LiftManual;
import frc.robot.commands.LiftMid;
import frc.robot.commands.LiftStop;
import frc.robot.commands.LineLeft;
import frc.robot.commands.LineRight;
import frc.robot.commands.LineStraight;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
Joystick tab;
Joystick lDrive;
Joystick rDrive;

public static final double kliftHigh= 86382.0;
public static final double kliftMid = 29307.0;
public static final double kliftLow = 0.0;

public OI(){
  tab = RobotMap.tablet;
  lDrive = RobotMap.driveLeft;
  rDrive = RobotMap.driveRight;

  // kliftHigh  = 744096.0;
  // kliftMid = 3720448.0;
  // kliftLow = 0.0;
 // liftInit = Robot.lift.getOffset();

  //Buttons on the joystick
      JoystickButton //manualLift = new JoystickButton(tab, 1),
        liftLow = new JoystickButton(tab, 3),
        liftMid = new JoystickButton(tab, 2),
        liftHigh = new JoystickButton(tab, 1),
        toggleLift = new JoystickButton(tab, 8),
        liftReset = new JoystickButton(tab, 4),

        closeArms = new JoystickButton(tab, 6),
        openArms = new JoystickButton(tab, 7),
        armHatch = new JoystickButton(tab, 10),

        armInitial = new JoystickButton(tab, 5);

      //  lineTrace = new JoystickButton(rDrive, 2);

  //What happens when certain buttons are pressed
  //Each button relates to a single command
 // toggleLift.toggleWhenPressed(new ToggleLift());

//manualLift.whenActive(new LiftManual());
// manualLift.whenReleased(new LiftStop());

  liftLow.whenPressed(new LiftLow());
  liftMid.whenPressed(new LiftMid());
  liftHigh.whenPressed(new LiftHigh());
  liftReset.whenPressed(new LiftInit());

  closeArms.whenPressed(new ArmCloseBall());
  openArms.whenPressed(new ArmOpenBall());
  armHatch.whenPressed(new ArmHatch());
  armInitial.whenPressed(new ArmInitial());

  // lineTrace.whileHeld(new LineLeft());
  // lineTrace.whileHeld(new LineRight());
  // lineTrace.whileHeld(new LineStraight());
  
  closeArms.close();
  openArms.close();
  armHatch.close();
  armInitial.close();

  //lineTrace.close();

  toggleLift.close();
 //manualLift.close();
  liftLow.close();
  liftMid.close();
  liftHigh.close();
  liftReset.close();
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
