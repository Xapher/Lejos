package lejosRover;

import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class SensorOfTouch implements ITouch
{
	TouchSensor t = new TouchSensor(SensorPort.S1);

	@Override
	public boolean isPressed() 
	{
		return t.isPressed();
	}
}
