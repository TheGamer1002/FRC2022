// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PnumaticsSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  // Below is the solenoid call.
  private static DoubleSolenoid test = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,4,5);
  public PnumaticsSubsystem() {}
  public static void extend()
  {
    test.set(DoubleSolenoid.Value.kForward);
  }
  public static void retract()
  {
    test.set(DoubleSolenoid.Value.kReverse);
  }
  public static void disable() {
    test.set(DoubleSolenoid.Value.kOff);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
    SmartDashboard.putNumber("FWD:",test.getFwdChannel());
    SmartDashboard.putNumber("REV:",test.getRevChannel());
    SmartDashboard.putBoolean("FWD Disabled:",test.isFwdSolenoidDisabled());
    SmartDashboard.putBoolean("REV Disabled:",test.isRevSolenoidDisabled());


  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  
}
