import lejos.nxt.Sound;


public class FailureSound implements RobotSounds
{
	@Override
	public void play() throws InterruptedException 
	{
		Sound.playTone(392,200); //g
	    Thread.sleep(500);
	    
	    Sound.playTone(392,1000); // g empty
	    Thread.sleep(1000);
	    
	    Sound.playTone(373,400); // e
	    Thread.sleep(1000);
	    
	    Sound.playTone(440,500); //a
	    Thread.sleep(500);
	    
	    Sound.playTone(392,500); //g empty
	    Thread.sleep(1000);
	    
	    Sound.playTone(373,400); // e
	    Thread.sleep(1000);
	}
	
	/*
	 * g		392
	 * g empty
	 * e		320
	 * a		440
	 * g empty
	 * e
	 * e
	 * g empty
	 * e
	 * a
	 * g empty
	 * e empty
	 */

}

