package dummyData;

import lejosRover.RobotSounds;

public class FakeBackUpSound implements RobotSounds
{

	@Override
	public void play() throws InterruptedException 
	{
		System.out.println("BEEP!");
	}

}
