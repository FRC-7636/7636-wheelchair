// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.subsystems.chassis;
import frc.robot.subsystems.gas;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private final XboxController joystick = new XboxController(0);
  private final chassis mChassis = new chassis();
  // private final gas mgas = new gas();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    mChassis.setDefaultCommand(
      new RunCommand(() -> mChassis.drive(joystick.getLeftX()*0.6,joystick.getRightY()*0.6), mChassis)
    );

  }

  private void configureBindings() {
    new JoystickButton(joystick,2).whileTrue(Commands.run(mChassis::turn, mChassis));
    // new JoystickButton(joystick, 5).onTrue(Commands.runOnce(mgas::pistonLong, mgas));
    // new JoystickButton(joystick, 6).onTrue(Commands.runOnce(mgas::pistonShort, mgas));
  }


}
