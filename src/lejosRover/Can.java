package lejosRover;

import dummyData.FakeBadSound;
import dummyData.FakeGoodSound;
import dummyData.FakeLight;
import dummyData.FakeMotor;
import dummyData.FakeTouch;
import dummyData.FakeUltrasonic;

public class Can 
{
	//private IMotor motor = new Motor(70);
	private IMotor motor = new FakeMotor();
	
	private int cansRemoved = 0;
	public static boolean missionSuccess = true;
	
	//ILight light = new SensorOfLight();
	ILight light = new FakeLight();
	
	Robot robot = new Robot();
	
	//Find can in circle
	public void findCanInCircle() throws InterruptedException
	{
		//IUltrasonic us = new SensorOfUltra();
		IUltrasonic us = new FakeUltrasonic();
		
		//while cans exist
		while(existInCircle() && Time.calculate() < 60)
		{
			//spin/turn robot around inside circle slowly
			motor.spinLeft();
			Object result = us.scan();
			
			//when it finds a can
			if(result != null)
			{
				light.readValue();
				//Thread.sleep(20);
				System.out.println("Range: " + us.getRange());
				motor.stop();
				//remove can from circle
				removeCanFromCircle();
			}			
		}
		
		Time.timeToClear = Time.calculate();
		missionSuccess = (cansRemoved == 3) ? true : false;
		
		//robot.missionIsOver(((missionSuccess) ? new VictorySound() : new FailureSound()), ((missionSuccess) ? new GoodMessage() : new BadMessage()));
		robot.missionIsOver(((missionSuccess) ? new FakeGoodSound() : new FakeBadSound()), ((missionSuccess) ? new GoodMessage() : new BadMessage()));
	}
	
	public void removeCanFromCircle() throws InterruptedException
	{
		//ITouch t = new SensorOfTouch();
		ITouch t = new FakeTouch();
		
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
	
	
	//when everything is over, leave the circle
	public void leaveCircle() throws InterruptedException
	{
		while(light.readValue() < 45)
		{
			motor.forward();
			if(light.readValue() < 45)
			{
				Thread.sleep(2000);
				motor.stop();
				break;
			}
		}
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
