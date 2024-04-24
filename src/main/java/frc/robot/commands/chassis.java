package frc.robot.subsystems;

import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.fasterxml.jackson.databind.deser.ValueInstantiator.Gettable;

public class chassis extends SubsystemBase {
    private final WPI_VictorSPX FrontLeft = new WPI_VictorSPX(Constants.FL);
    private final WPI_VictorSPX FrontRight = new WPI_VictorSPX(Constants.FR);
    private final WPI_VictorSPX RearLeft = new WPI_VictorSPX(Constants.RL);
    private final WPI_VictorSPX RearRight = new WPI_VictorSPX(Constants.RR);

    private final MotorControllerGroup LeftMotors = new MotorControllerGroup(FrontLeft, RearLeft);
    private final MotorControllerGroup RightMotors = new MotorControllerGroup(FrontRight, RearRight);
    private DifferentialDrive tank = new DifferentialDrive(LeftMotors, RightMotors);

public chassis() {
    FrontLeft.configFactoryDefault();
    FrontRight.configFactoryDefault();
    RearLeft.configFactoryDefault();
    RearRight.configFactoryDefault();

    FrontRight.setInverted(true);
    RearRight.setInverted(true);

    }
    public void drive (double X, double Y ) {
        tank.arcadeDrive(-Y, -X);
    }

    public void turn(){
//         double AX = NetworkTableInstance.getDefault().getTable("limelight").getEntry("camerapose_targetspace").getDoubleArray(new double[6])[4];
//             if(AX>5){
//                 tank.arcadeDrive(0.35, 0);        
    
// }
//             else if (AX<-5){
//                 tank.arcadeDrive(0.35, 0);
    // }   
}
}
