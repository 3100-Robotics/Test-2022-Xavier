package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveCommand extends CommandBase{
    private DriveTrain m_drive;
    private XboxController m_controller;

    public DriveCommand(DriveTrain subsystem, XboxController controller){
        m_drive = subsystem;
        m_controller = controller;
        addRequirements(m_drive);
        System.out.println("fortnite3");
    }

    public void execute(){
        double xSpeed = m_controller.getLeftY();
        double zRotation = m_controller.getRightX();

        m_drive.arcadeDrive(xSpeed, zRotation);
    }
}
