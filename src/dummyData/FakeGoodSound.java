package dummyData;

import lejosRover.RobotSounds;

public class FakeGoodSound implements RobotSounds
{
	boolean didPlay;
	@Override
	public void play() throws InterruptedException 
	{
		didPlay = true;
	}

}
