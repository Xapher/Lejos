package dummyData;

import lejosRover.ILight;

public class FakeLight implements ILight
{

	public static int value = 50;
	@Override
	public int readValue() 
	{
		return value;
	}
	
}
