/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;

/**
 * Add your docs here.
 */
public class Hatch extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Solenoid finger = new Solenoid(0);
  Solenoid pusher = new Solenoid(1);
  
  public void score(){
    finger.set(false);
    //TODO: we need to pause here for half of a second
    pusher.set(true);
  }

  public void reset(){
    pusher.set(false);
    finger.set(true);
  }

  public void retrieve(){
    finger.set(true);
  }
  
  public void fingerExtend() {
    SmartDashboard.putString("hatch finger", "extend");
    finger.set(false);
  }
  
  public void fingerRetract() {
    SmartDashboard.putString("hatch finger", "retract");
    finger.set(true);
  }

  public void pusherExtend() {
    SmartDashboard.putString("hatch pusher", "extend");
    pusher.set(true);
  }

  public void pusherRetract() {
    SmartDashboard.putString("hatch pusher", "retract");
    pusher.set(false);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // TODO: set default command to be reset
    setDefaultCommand(new HatchReset2());

  }
}
