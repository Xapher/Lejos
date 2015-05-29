package lejosRover;

public class Robot 
{
	public void missionIsOver(RobotSounds sound, IMessage message) throws InterruptedException
	{	
		sound.play();
		message.display();
		
		//leave circle
		Circle.leaveCircle();
		
	}
}
