package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase{
    public Spark e_motor = new Spark(3);

    public void MoveElevator(double speed){
        e_motor.set(speed);
    }
}
