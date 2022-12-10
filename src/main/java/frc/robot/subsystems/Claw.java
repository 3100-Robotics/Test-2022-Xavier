package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Claw extends SubsystemBase{

    public static final Solenoid clawSolenoid =
    new Solenoid(PneumaticsModuleType.CTREPCM, 3);

    public static void useClaw(){
        clawSolenoid.toggle();
    }
}