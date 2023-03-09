// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  private VictorSP rightMotor = new VictorSP(0);
  private VictorSP leftMotor = new VictorSP(1);

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() { 
    rightMotor.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void set(double drive, double turn){
    rightMotor.set(drive + turn); 
    leftMotor.set(drive - turn); 
  }
  
  public void stop(){
    rightMotor.set(0); 
    leftMotor.set(0); 
  }
}
