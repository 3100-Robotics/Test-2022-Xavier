package frc.robot.Auto.AutoCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoDrive extends CommandBase{
    DriveTrain drive;
    double speed;
    double time;
    double rotation;
    double stopTime;

    public AutoDrive(DriveTrain subsystem, double speed, double rotation, double stopTime) {
        drive = subsystem;
        this.speed = speed;
        this.stopTime = stopTime;
        this.rotation = rotation;
        addRequirements(drive);
    }

    public void execute(){
        drive.arcadeDrive(-speed, rotation);
    }

    public void initialize(){
        time = Timer.getFPGATimestamp();
    }

    public boolean isFinished(){
        if (Timer.getFPGATimestamp() - time >= stopTime) {
            return true;
        }
        return false;
    }

}
