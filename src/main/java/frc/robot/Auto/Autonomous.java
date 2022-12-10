package frc.robot.Auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Auto.AutoCommands.AutoDrive;
import frc.robot.subsystems.DriveTrain;

public class Autonomous extends SequentialCommandGroup{

    public Autonomous(DriveTrain drive){
        super(
            new AutoDrive(drive, 0.6, 0, 2.8),
            new AutoDrive(drive, 0 ,-0.5, 2.25),
            new AutoDrive(drive, 0.6, 0, 2.8)
        );
        
    }

}
