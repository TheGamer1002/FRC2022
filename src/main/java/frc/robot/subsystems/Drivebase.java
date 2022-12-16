// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


// import frc.robot.commands.*;
// import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.shuffleboard.*;

// import java.util.function.DoubleSupplier; // because it gets mad at me and thinks that the spark maxes are double suppliers
import edu.wpi.first.networktables.*;

// import frc.robot.subsystems.*; // it wants this for some reason

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Drivebase extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private CANSparkMax leftFront;
private CANSparkMax leftRear;
private CANSparkMax rightFront;
private CANSparkMax rightRear;
public MecanumDrive mecanumDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public Drivebase() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
leftFront = new CANSparkMax(1, MotorType.kBrushed);
 
 leftFront.restoreFactoryDefaults();  
leftFront.setInverted(false);
leftFront.setIdleMode(IdleMode.kCoast);
leftFront.burnFlash();
  

leftRear = new CANSparkMax(2, MotorType.kBrushed);
 
 leftRear.restoreFactoryDefaults();  
leftRear.setInverted(false);
leftRear.setIdleMode(IdleMode.kCoast);
leftRear.burnFlash();
  

rightFront = new CANSparkMax(3, MotorType.kBrushed);
 
 rightFront.restoreFactoryDefaults();  
rightFront.setInverted(false);
rightFront.setIdleMode(IdleMode.kCoast);
rightFront.burnFlash();
  

rightRear = new CANSparkMax(4, MotorType.kBrushed);
 
 rightRear.restoreFactoryDefaults();  
rightRear.setInverted(false);
rightRear.setIdleMode(IdleMode.kCoast);
rightRear.burnFlash();
  

mecanumDrive = new MecanumDrive(leftRear, leftFront,
rightFront, rightRear);
 addChild("Mecanum Drive",mecanumDrive);
 mecanumDrive.setSafetyEnabled(true);
mecanumDrive.setExpiration(0.1);
mecanumDrive.setMaxOutput(.5);



    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    // Add a few entries to the dashboard

    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

        // Below, I've added some commands to send data to Shuffleboard.
        leftFrontEntry.setDouble(leftFront.get());
        leftRearEntry.setDouble(leftRear.get());
        rightFrontEntry.setDouble(rightFront.get());
        rightRearEntry.setDouble(rightRear.get());

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    // Hopefully working.

    /**
     * Drive method for the mecanum base.
     * 
     * <p>Uses driveCartesian as the driver.
     * @param y      Forward and back value, perhaps from a joystick.
     * @param x      Right and left value, also perhaps from a joystick.
     * @param z      Rotation value, from-AHA! You thought I was about to type "perhaps from a joystick!" You fool! It might come from a SEPERATE joystick, because a joystick only has 2 axes!
     */
    public void drive(double y, double x, double z) {
        y=y*.6;
        y=y+x*.2857;
        mecanumDrive.driveCartesian(y, x, z);
    }
    

    // Add a Shuffleboard tab.
    private ShuffleboardTab tab = Shuffleboard.getTab("Mecanum Drivebase");
    NetworkTableEntry leftFrontEntry = tab.add("Left Front", 0).getEntry();
    NetworkTableEntry leftRearEntry = tab.add("Left Rear", 0).getEntry();
    NetworkTableEntry rightFrontEntry = tab.add("Right Front", 0).getEntry();
    NetworkTableEntry rightRearEntry = tab.add("Right Rear", 0).getEntry();


    // Set default command for the subsystem to schedule the execution of MecanumDriver.
    
    
}

