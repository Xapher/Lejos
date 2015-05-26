
public class Robot 
{
	public void missionIsOver() throws InterruptedException
	{
		VictorySound vs = new VictorySound();
		FailureSound fs = new FailureSound();
		
		//play sound
		if(Can.missionSuccess) vs.play(); else fs.play();
		
		//display message
		if(Can.missionSuccess) Message.displayGood(); else Message.displayBad();
		
		//leave circle
		Circle.leaveCircle();
		
	}
}
