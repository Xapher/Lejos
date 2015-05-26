import lejos.nxt.Sound;


public class VictorySound implements RobotSounds
{
	@Override
	public void play() throws InterruptedException 
	{
		short[] note = {2349,115, 0,5, 1760,165, 0,35};
		//Sound.playSample("Music/fnaf.wav");
		for(int i=0;i <note.length; i+=2) {
			short w = note[i+1];
			int n = note[i];
			if (n != 0) {
				Sound.playTone(n, w*10);
			}
			Thread.sleep(w*10);
		}
	}

}
