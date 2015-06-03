package dummyData;

import lejosRover.IMotor;

public class FakeMotor implements IMotor
{

	String currentlyDoing;
	@Override
	public void forward(int power) 
	{
		currentlyDoing = "forward";
	}

	@Override
	public void backwards(int power) 
	{
		currentlyDoing = "backward";
	}

	@Override
	public void spinLeft() 
	{
		currentlyDoing = "spin left";
	}

	@Override
	public void spinRight() 
	{
		currentlyDoing = "spin right";
	}

	@Override
	public void stop() 
	{
		currentlyDoing = "stop";
	}
	
}
