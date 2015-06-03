package lejosRover;

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

public class SensorOfLight implements ILight
{
	LightSensor light = new LightSensor(SensorPort.S2);
	
	@Override
	public int readValue() 
	{
		return light.readValue();
	}
	
}
