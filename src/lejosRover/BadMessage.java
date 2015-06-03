package lejosRover;

public class BadMessage implements IMessage
{
	@Override
	public void display() 
	{
		System.out.println("Mission failed. So Sorry");
	}
	
}
