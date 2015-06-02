package lejosRover;

import dummyData.FakeBadSound;
import dummyData.FakeGoodSound;
import dummyData.FakeLight;
import dummyData.FakeMotor;
import dummyData.FakeTouch;
import dummyData.FakeUltrasonic;

public class Can 
{
//	public IMotor m1;
//	public IMotor m2;
	public IMotor motor;
	public IUltrasonic us;
	public ILight light;
	public ITouch t;
	public RobotSounds good;
	public RobotSounds bad;
	public Can(IMotor motor, IUltrasonic us, ILight light, ITouch t, RobotSounds good, RobotSounds bad)
	{
//		this.m1 = m1;
//		this.m2 = m2;
		this.motor = motor;
		this.us = us;
		this.light = light;
		this.t = t;
		this.good = good;
		this.bad = bad;
	}
	
	//private IMotor motor = new FakeMotor();
	
	public int cansRemoved = 0;
	public static boolean missionSuccess = true;
	//public IUltrasonic us = new FakeUltrasonic("safdsd");
	//public IUltrasonic us = new FakeUltrasonic();
	//public ITouch t = new FakeTouch();
	
	//ILight light = new SensorOfLight();
	//public ILight light = new FakeLight();
	
	Robot robot = new Robot(); 
	
	//Find can in circle
	public void findCanInCircle() throws InterruptedException
	{
		//IUltrasonic us = new SensorOfUltra();
		
		//while cans exist
		while(existInCircle() && Time.calculate() < 60) 
		{
			//spin/turn robot around inside circle slowly
			motor.spinLeft();
			
			//when it finds a can
			if(us.scan() != null)
			{
				light.readValue();
				System.out.println("Range: " + us.getRange());
				motor.stop();
				//remove can from circle
				removeCanFromCircle();
			}			 
		}
		 
		Time.timeToClear = Time.calculate();
		missionSuccess = (cansRemoved == 3);
		motor.stop();
		robot.missionIsOver(((missionSuccess) ? good : bad), ((missionSuccess) ? new GoodMessage() : new BadMessage()));
		leaveCircle();
		//robot.missionIsOver(((missionSuccess) ? new FakeGoodSound() : new FakeBadSound()), ((missionSuccess) ? new GoodMessage() : new BadMessage()));
	}
	
	public void removeCanFromCircle() throws InterruptedException
	{
		//ITouch t = new SensorOfTouch();
		boolean touched = false;
		//move forward toward can
		//robot gets to the can
		light.readValue();
		
		while(light.readValue() > 40)
		{
			motor.forward(70);
			if(t.isPressed())
			{
//				System.out.println("HAI");
				touched = true;
			}
			if(Time.calculate() > 60)
			{
				break;
			}
		}
		motor.stop();
		motor.backwards(70);
		Thread.sleep(2000);
		motor.stop();
		if(touched) cansRemoved++;
		findCanInCircle();
	}
	
	public boolean existInCircle()
	{
		//if the number of times the touch sensor has been pushed is less than 3, cans still exist
		return cansRemoved < 3 ? true : false; 
	}
	
	
	//when everything is over, leave the circle
	public void leaveCircle() throws InterruptedException
	{
		motor.forward(70);
		if(light.readValue() > 45)
		{
			Thread.sleep(4000);
			motor.stop();
			Thread.sleep(3000);
			System.exit(1);
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
