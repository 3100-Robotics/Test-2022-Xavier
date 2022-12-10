package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase{
    public Spark frontLeft = new Spark(4);
    public Spark frontRight = new Spark(1);
    public Spark rearLeft = new Spark(0);
    public Spark rearRight = new Spark(2);

    public MotorControllerGroup left = new MotorControllerGroup(frontLeft, rearLeft);
    public MotorControllerGroup right = new MotorControllerGroup(frontRight, rearRight);

    public DifferentialDrive diffDrive = new DifferentialDrive(left, right);

    public void arcadeDrive(double speed, double rotation) {
        // drive!
        diffDrive.arcadeDrive(rotation, speed);
    }

    public void stop() {
        // STOP
        diffDrive.stopMotor();
      }
}
