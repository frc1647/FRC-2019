/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import io.github.pseudoresonance.pixy2api.Pixy2;

/**
 * Add your docs here.
 */
public class Vision extends Subsystem {
  private Pixy2 pixycam;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Vision(){
    pixycam = RobotMap.pixycam;
    pixycam.init();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    
    //CameraServer.getInstance().addCamera(pixycam);
  }
  public void getVideo(){
    pixycam.getVideo(); 
  }
}
