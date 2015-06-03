package lejosRover;

public interface IMotor {

	public void forward(int power);
	
	public void backwards(int power);
	
	public void spinLeft();
	
	public void spinRight();
	
	public void stop();
}
