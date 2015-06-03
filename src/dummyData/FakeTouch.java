package dummyData;

import lejosRover.ITouch;

public class FakeTouch implements ITouch 
{
	public static boolean value = true;
	
	@Override
	public boolean isPressed() 
	{
		return value;
	}

}
