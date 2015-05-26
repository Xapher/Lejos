import lejos.nxt.NXTMotor;


public class Motor 
{
	NXTMotor left;
	NXTMotor right;
	BackUpSound beep = new BackUpSound();
	
	public Motor(NXTMotor m1, NXTMotor m2, int power)
	{
		left = m1;
		right = m2;
		left.setPower(power);
		right.setPower(power);
	}
	
	public void forward() throws InterruptedException
	{
		left.forward();
		right.forward();
		//Thread.sleep(2000);
	}
	

	public void backwards()
	{
		beep.play();
		left.backward();
		right.backward();
		beep.play();
	}
	
	public void stop()
	{
		left.stop();
		right.stop();
	}
	
	public void spinLeft()
	{
		left.backward();
		right.forward();
	}
	
	public void spinRight()
	{
		left.forward();
		right.backward();
	}
	
}
