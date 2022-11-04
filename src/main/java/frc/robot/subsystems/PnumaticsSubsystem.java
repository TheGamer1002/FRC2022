// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class PnumaticsSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private DoubleSolenoid test = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,4,5);
  public PnumaticsSubsystem() {}
  public void extend()
  {
    test.set(DoubleSolenoid.Value.kForward);
  }
  public void retract()
  {
    test.set(DoubleSolenoid.Value.kReverse);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    System.out.println("fwd:"+test.getFwdChannel()+"   rev:"+test.getRevChannel()+"   isFwdDisabled:"+test.isFwdSolenoidDisabled()+"   isRevDisabled:"+test.isRevSolenoidDisabled());



  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
