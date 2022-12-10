package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class ElevatorCommand extends CommandBase{
    private XboxController e_controller;
    private Elevator elevator;

    public ElevatorCommand(Elevator subsystem, XboxController controller){
        e_controller = controller;
        elevator = subsystem;
        addRequirements(elevator);
    }

    public void execute(){
        double speed = e_controller.getLeftY();

        elevator.MoveElevator(speed / 2);
    }
}
