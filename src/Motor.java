import lejos.nxt.NXTMotor;


public class Motor 
{
	NXTMotor left;
	NXTMotor right;
	BackUpSound beep = new BackUpSound();
	int power;
	
	public Motor(NXTMotor m1, NXTMotor m2, int power)
	{
		power = power;
		left = m1;
		right = m2;
		left.setPower(power);
		right.setPower(power);
	}
	
	public void forward(int power) throws InterruptedException
	{
		if(power != this.power)
		{
			left.setPower(power);
			right.setPower(power);
		}
		else
		{
			left.setPower(20);
			right.setPower(20);
		}
		left.forward();
		right.forward();
		
		//Thread.sleep(2000);
	}
	

	public void backwards(int power)
	{
		if(power != this.power)
		{
			left.setPower(power);
			right.setPower(power);
		}
		else
		{
			left.setPower(20);
			right.setPower(20);
		}
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
		left.setPower(50);
		right.setPower(50);
		left.backward();
		right.forward();
	}
	
	public void spinRight()
	{
		left.setPower(50);
		right.setPower(50);
		left.forward();
		right.backward();
	}
	
}
