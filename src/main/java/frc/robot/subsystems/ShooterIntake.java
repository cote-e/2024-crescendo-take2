// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterIntake extends SubsystemBase {
  private CANSparkMax m_ShInMasterL =
      new CANSparkMax(Constants.ShInConstants.kLeftShIn1, MotorType.kBrushless);
  private CANSparkMax m_ShInFollowL =
      new CANSparkMax(Constants.ShInConstants.kLeftShIn2, MotorType.kBrushless);
  private CANSparkMax m_ShInMasterR =
      new CANSparkMax(Constants.ShInConstants.kRightShIn1, MotorType.kBrushless);
  private CANSparkMax m_ShInFollowR =
      new CANSparkMax(Constants.ShInConstants.kRightShIn2, MotorType.kBrushless);

  /** Detects notes getting "intaked" */
  private DigitalInput m_IntakeIR = new DigitalInput(Constants.ShInConstants.kIntakeIRsensor);

  /** Detects notes getting shot out */
  private DigitalInput m_ShooterIR = new DigitalInput(Constants.ShInConstants.kShooterIRsensor);

  /** Creates a new ShooterIntake. */
  public ShooterIntake() {
    // Apparently this config is here ?
    // Idk why we reset to factory default btw i just saw it in the example SPARK-MAX code
    m_ShInFollowL.restoreFactoryDefaults();
    m_ShInFollowR.restoreFactoryDefaults();
    m_ShInMasterL.restoreFactoryDefaults();
    m_ShInMasterR.restoreFactoryDefaults();
    // Make the stuff follow stuff (smart)
    m_ShInFollowL.follow(m_ShInMasterL);
    m_ShInFollowR.follow(m_ShInMasterR);
  }

  @Override
  public void periodic() {
    // (for testing purposes)
    System.out.println("Intake IR sensor" + m_IntakeIR);
    System.out.println("Shooter IR sensor" + m_ShooterIR);
  }
}
