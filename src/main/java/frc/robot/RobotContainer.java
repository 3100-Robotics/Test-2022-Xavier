// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Auto.Autonomous;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ElevatorCommand;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
      public DriveTrain drive = new DriveTrain();
      public Elevator elevator = new Elevator();
      public Claw claw = new Claw();

      public XboxController driveController = new XboxController(0);
      public XboxController coDriveController = new XboxController(1);

      final JoystickButton clawButton = new JoystickButton(coDriveController, 1);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    drive.setDefaultCommand(new DriveCommand(drive, driveController));
    elevator.setDefaultCommand(new ElevatorCommand(elevator, coDriveController));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    clawButton.whenPressed(toggleClaw);
  }

  InstantCommand toggleClaw = new InstantCommand(
     () -> Claw.useClaw(), claw);

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new Autonomous(drive);
  }
}
