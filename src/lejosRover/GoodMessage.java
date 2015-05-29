package lejosRover;

public class GoodMessage implements IMessage
{
	@Override
	public void display() 
	{
		System.out.println("Mission complete in "+ Time.calculate() + " seconds");
	}
}
