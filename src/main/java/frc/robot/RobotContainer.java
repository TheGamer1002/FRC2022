// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //RR 1/11/2022
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Auto m_auto = new Auto();
  private final BallIntake m_BallIntake = new BallIntake();
  private final Climbing m_Climbing = new Climbing();
  private final Elevator m_Elevator = new Elevator();
  private final RobotDrive m_RobotDrive = new RobotDrive();
  private final Shooting m_Shooting = new Shooting();
  private final ShootingRotate m_ShootingRotate = new ShootingRotate();
  

  private final ExampleCommand m_exampleCommand = new ExampleCommand(m_exampleSubsystem);
  private final AutoCommand m_AutoCommand = new AutoCommand(m_auto);
  private final BallIntakeCommand m_BallIntakeCommand = new BallIntakeCommand(m_BallIntake);
  private final BallShootBottomCommand m_BallShootBottomCommand = new BallShootBottomCommand(m_Shooting);
  private final BallShootTopCommand m_BallShootTopCommand = new BallShootTopCommand(m_Shooting);
  private final ClimbingHangCommand m_ClimbingHangCommand = new ClimbingHangCommand(m_Climbing);
  private final ClimbingTraverseCommand m_ClimbingTraverseCommand = new ClimbingTraverseCommand(m_Climbing);
  private final DriveCommand m_DriveCommand = new DriveCommand(m_RobotDrive);
  private final ElevatorMoveBottomCommand m_ElevatorMoveBottomCommand = new ElevatorMoveBottomCommand(m_Elevator);
  private final ShootingRotateCommand m_ShootingRotateCommand = new ShootingRotateCommand(m_ShootingRotate);

  /**
   * TO-DO: Edit dynamic type according to what gyro sensor we have and check constructor params
   */
  private final static Gyro m_GyroSensor = new ADXRS450_Gyro(); //HC - 01/11/22

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  public static double getShootSpeedValue(){//implement vision here later- RR 1/11/2022
    double value = Math.random();
    return value; 
  }

  public static double getShootAngle(){//implement vision here later- RR 1/11/2022
    double value = Math.random();
    return value; 
  }

/**
 * Pseudocode from https://frc-pdr.readthedocs.io/en/latest/control/gyro.html
 * function rotateToAngle(targetAngle):
    error = targetAngle - gyroAngle # check out wpilib documentation for getting the angle from the gyro
    if error > threshold
        this.rotation =  error*kP
        return False
    else:
        this.rotation = 0
        return True
 * 
 */
  public static boolean rotateToAngle(double targetAngle){
    //threshold is subject to change, but represents the accpetable margin of error
    double threshold = 5;
    double error = targetAngle - m_GyroSensor.getAngle();
    if(error > threshold){
       /**
        * Add code to adjust motor so that the error is reduced
        */
       return false;
    } else {
      return true;
    }
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_AutoCommand;
  }

}
