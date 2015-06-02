package lejosRover;

import lejos.nxt.MotorPort;
import lejos.nxt.NXT;
import lejos.nxt.NXTMotor;

public class Main 
{
	public static void main(String[] args) throws InterruptedException 
	{		
		Time.start();
		//Find can in circle
		IMotor m1 = (IMotor) new NXTMotor(MotorPort.A);
		IMotor m2 = (IMotor) new NXTMotor(MotorPort.B);
		IMotor motor = new Motor(m1, m2, 70);
		
		IUltrasonic us = new SensorOfUltra();
		ILight light = new SensorOfLight();
		ITouch t = new SensorOfTouch();
		RobotSounds good = new VictorySound();
		RobotSounds bad = new FailureSound();
		
		Can can = new Can(motor, us, light, t, good, bad);
		can.findCanInCircle();

		/*
		 *  Find can in circle
			While cans exist … push can out of circle
			Play appropriate sound 
			Calculate time
			Display appropriate message
			leave circle
		 */
		
		//System.out.println("FASDF");
	}	
}
