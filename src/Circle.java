import lejos.nxt.LightSensor;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTMotor;
import lejos.nxt.SensorPort;


public class Circle 
{
	
	public static void leaveCircle() throws InterruptedException
	{
		NXTMotor m1 = new NXTMotor(MotorPort.A);
		NXTMotor m2 = new NXTMotor(MotorPort.B);
		LightSensor light = new LightSensor(SensorPort.S2);
		Motor motor = new Motor(m1,m2,10);
		
		//make robot leave the circle
		while(light.readValue() < 45)
		{
			motor.forward(100);
			if(light.readValue() < 45)
			{
				Thread.sleep(2000);
				motor.stop();
				break;
			}
		}
		
		
	}
}
