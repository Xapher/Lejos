package lejosRover;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTMotor;


public class Motor implements IMotor
{
	NXTMotor left = new NXTMotor(MotorPort.A);
	NXTMotor right = new NXTMotor(MotorPort.B);
	BackUpSound beep = new BackUpSound();
	int power;
	
	public Motor(int power)
	{
		this.power = power;
		left.setPower(power);
		right.setPower(power);
	}
	
	public void forward(int power)
	{
		left.setPower(power);
		right.setPower(power);
		left.forward();
		right.forward();
		
		//Thread.sleep(2000);
	}
	

	public void backwards(int power)
	{
		left.setPower(power);
		right.setPower(power);
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
		left.setPower(30);
		right.setPower(30);
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
