import lejos.nxt.Sound;


public class BackUpSound implements RobotSounds
{
	@Override
	public void play() 
	{
		Sound.beep();
	}

}
