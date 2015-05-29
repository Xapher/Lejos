package lejosRover;

public class Robot 
{
	
	public void missionIsOver(RobotSounds sound, IMessage message) throws InterruptedException
	{	
		sound.play();
		message.display();
		
		Can can = new Can();
		//leave circle
		can.leaveCircle();
		
	}
}
