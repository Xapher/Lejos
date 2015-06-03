package dummyData;

import lejosRover.IUltrasonic;

public class FakeUltrasonic implements IUltrasonic
{
	public static Object ob;
	public FakeUltrasonic()
	{
		
	}
	
	public FakeUltrasonic(Object ob)
	{
		this.ob = ob;
	}
	@Override
	public Object scan() 
	{
		return ob;
	}

	@Override
	public float getRange() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void setOb(Object obj)
	{
		FakeUltrasonic.ob = obj;
	}
}
