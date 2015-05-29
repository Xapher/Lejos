package lejosRover;

public class Robot 
{
	Can can = new Can();
	
	public void missionIsOver(RobotSounds sound, IMessage message) throws InterruptedException
	{	
		sound.play();
		message.display();
		
		//leave circle
		can.leaveCircle();
		
	}
}
