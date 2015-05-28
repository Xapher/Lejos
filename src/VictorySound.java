import lejos.nxt.Sound;


public class VictorySound implements RobotSounds
{
	@Override
	public void play() throws InterruptedException 
	{
		Sound.playTone(494,500); // frequency 300, duration 1/2 second
	    Thread.sleep(500);        // wait half of a second while the sound plays
	    Sound.playTone(440,500);  // frequency 400, duration 1/2 second
	    Thread.sleep(500);        // let the tone play half a second and wait half of a second
	    Sound.playTone(392,500);  // frequency 500, duration 1 second
	    Thread.sleep(1000);        // wait a second
	    
	    Sound.playTone(494,500);
	    Thread.sleep(500);
	    Sound.playTone(440,500);  
	    Thread.sleep(500);
	    Sound.playTone(392,500); 
	    Thread.sleep(1000);
	    
	    Sound.playTone(392,200); 
	    Thread.sleep(300);
	    Sound.playTone(392,200); 
	    Thread.sleep(300);
	    Sound.playTone(392,200); 
	    Thread.sleep(300);
	    
	    Sound.playTone(440,200);  
	    Thread.sleep(300);  
	    Sound.playTone(440,200);  
	    Thread.sleep(300);  
	    Sound.playTone(440,200);  
	    Thread.sleep(300);  
	    
	    Sound.playTone(494,500);
	    Thread.sleep(500);
	    Sound.playTone(440,500);  
	    Thread.sleep(500);
	    Sound.playTone(392,500); 
	    Thread.sleep(1000);
	    
	}

}
