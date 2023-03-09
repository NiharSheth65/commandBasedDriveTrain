// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class defaultDrive extends CommandBase {
  /** Creates a new defaultDrive. */
  
  private DriveSubsystem DRIVE_SUBSYSTEM; 
  private Joystick joy; 

  private SlewRateLimiter yLimiter = new SlewRateLimiter(1); 
  private SlewRateLimiter xLimiter = new SlewRateLimiter(1); 

  double speed; 
  double turn; 

  public defaultDrive(DriveSubsystem drive, Joystick joystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.DRIVE_SUBSYSTEM = drive; 
    this.joy = joystick; 
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    speed = 0; 
    turn = 0; 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    speed = yLimiter.calculate(joy.getRawAxis(1)); 
    turn = xLimiter.calculate(joy.getRawAxis(2)); 
    
    DRIVE_SUBSYSTEM.set(speed, turn);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DRIVE_SUBSYSTEM.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
