package lejosRover;
import lejos.nxt.LightSensor;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.objectdetection.Feature;
import lejos.robotics.objectdetection.FeatureDetector;
import lejos.robotics.objectdetection.RangeFeatureDetector;


public class Can 
{
	private NXTMotor m1 = new NXTMotor(MotorPort.A);
	private NXTMotor m2 = new NXTMotor(MotorPort.B);
	private Motor motor = new Motor(m1, m2, 70);
	private int cansRemoved = 0;
	public static boolean missionFinished = false;
	public static boolean missionSuccess = true;
	LightSensor light = new LightSensor(SensorPort.S2);
	Robot robot = new Robot();
	
	//Find can in circle
	public void findCanInCircle() throws InterruptedException
	{
		int MAX_DISTANCE = 40;
		int PERIOD = 200;
		
		UltrasonicSensor us = new UltrasonicSensor(SensorPort.S4);
		FeatureDetector fd = new RangeFeatureDetector(us, MAX_DISTANCE, PERIOD);
		
		//while cans exist
		while(existInCircle() && Time.calculate() < 60)
		{
			//spin/turn robot around inside circle slowly
			motor.spinLeft();
			Feature result = fd.scan();
			
			//when it finds a can
			if(result != null)
			{
				light.readValue();
				//Thread.sleep(20);
				System.out.println("Range: " + result.getRangeReading().getRange());
				motor.stop();
				//remove can from circle
				removeCanFromCircle();
			}			
		}
		
		Time.timeToClear = Time.calculate();
		missionFinished = true;
		missionSuccess = (cansRemoved == 3) ? true : false;
		
		robot.missionIsOver(((missionSuccess) ? new VictorySound() : new FailureSound()), ((missionSuccess) ? new GoodMessage() : new BadMessage()));
	}
	
	public void removeCanFromCircle() throws InterruptedException
	{
		TouchSensor t = new TouchSensor(SensorPort.S1);
		
		//move forward toward can
		//robot gets to the can
		light.readValue();
		
		motor.forward();
		while(!t.isPressed())
		{
			light.readValue();
			if(t.isPressed())
			{
				System.out.println("Touched");
				while(light.readValue() > 40)
				{
					System.out.println(light.readValue());
				}
				motor.forward();
				Thread.sleep(200);
				motor.stop();
				motor.backwards();
				Thread.sleep(2000);
				motor.stop();
				cansRemoved++;
				findCanInCircle();
			}
			if(light.readValue() < 40)
			{
				System.out.println(light.readValue());
				motor.stop();
				motor.backwards();
				Thread.sleep(2000);
				motor.stop();
				findCanInCircle();
			}
		}
		
		
		
		
		
//		if(t.isPressed())
//		{
//			//is the can out of the circle? if it gets to the can it's out?
//			Thread.sleep(1000);
//			cansRemoved++;
//		}
//		
//		//sense the black line
//		if(light.readValue() < 45)
//		{
//			//back up and start again.
//			motor.backwards();
//			Thread.sleep(2000);
//			motor.stop();
//			findCanInCircle();
//		}
	}
	
	public boolean existInCircle()
	{
		//if the number of times the touch sensor has been pushed is less than 3, cans still exist
		return cansRemoved < 3 ? true : false; 
	}
	
}


/*
Find in circle:
	spin/turn robot around inside circle slowly
	while cans exists…
	if sensor detects can in circle,
	remove can from circle
Remove can from circle:
	move forward toward can
	when the robot gets to the can stop moving
	push can out of circle
	move backwards back into the circle
	find can in circle 
Exist in circle:
	if the number of cans pushed out of circle is less than 3,
	keep finding cans
	else mission is finished
 */
