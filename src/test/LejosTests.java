package test;

import static org.junit.Assert.*;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTMotor;
import lejosRover.BadMessage;
import lejosRover.Can;
import lejosRover.GoodMessage;
import lejosRover.ILight;
import lejosRover.IMotor;
import lejosRover.ITouch;
import lejosRover.IUltrasonic;
import lejosRover.Motor;
import lejosRover.SensorOfLight;
import lejosRover.SensorOfTouch;
import lejosRover.SensorOfUltra;
import lejosRover.Time;

import org.junit.Test;

import dummyData.FakeBackUpSound;
import dummyData.FakeBadSound;
import dummyData.FakeGoodSound;
import dummyData.FakeLight;
import dummyData.FakeMotor;
import dummyData.FakeTouch;
import dummyData.FakeUltrasonic;

public class LejosTests {

//	IMotor m1 = (IMotor) new NXTMotor(MotorPort.A);
//	IMotor m2 = (IMotor) new NXTMotor(MotorPort.B);
//	IMotor motor = new Motor(m1, m2, 70);
//	
//	IUltrasonic us = new SensorOfUltra();
//	ILight light = new SensorOfLight();
//	ITouch t = new SensorOfTouch();
//	
//	Can can = new Can(motor, us, light, t);
	
	IUltrasonic us = new FakeUltrasonic("not null stuff");
	ITouch t = new FakeTouch();
	ILight light = new FakeLight();
	FakeMotor fm = new FakeMotor();
	FakeGoodSound fgs = new FakeGoodSound();
	FakeBadSound fbs = new FakeBadSound();
	
	@Test
	public void testOfCanExist() 
	{
		Can can = new Can(fm, us, light, t, fgs, fbs);
		assertEquals(true, can.existInCircle());
		can.cansRemoved = 3;
		assertEquals(false, can.existInCircle());
	}
	
	@Test
	public void testOfCanFind() throws InterruptedException 
	{
		Can can = new Can(fm, us, light, t, fgs, fbs);
		FakeTouch.value = false;
		assertEquals(false, can.t.isPressed());
		FakeTouch.value = true;
		assertEquals(true, can.t.isPressed());
		FakeLight.value = 10;
		can.findCanInCircle();
//		
		can.cansRemoved = 0;
		FakeTouch.value = false;
		assertEquals(false, can.t.isPressed());
		can.findCanInCircle();
	}
	
//	@Test
//	public void testOfCanRemvoing() throws InterruptedException 
//	{
//		Can can = new Can(fm, us, light, t, fgs, fbs);
//		FakeLight.value = 10;
//		can.removeCanFromCircle();
//		
//		FakeLight.value = 50;
//		can.removeCanFromCircle();
//		
//		FakeTouch.value = false;
//		assertEquals(false, can.t.isPressed());
//		can.removeCanFromCircle();
//	}
	
//	@Test
//	public void testOfCan2() throws InterruptedException 
//	{
//		Can can = new Can(fm, us, light, t, fgs, fbs);
//		can.cansRemoved = 3;
//		can.findCanInCircle();
//	}
	
//	@Test
//	public void testOfCan3() throws InterruptedException 
//	{
//		Can can = new Can();
//		FakeUltrasonic fus = new FakeUltrasonic();
//		can.us = fus;
//		can.findCanInCircle();
//	}
	
	@Test
	public void testofMotor() 
	{
		FakeMotor fm = new FakeMotor();
		fm.forward(70);
		fm.backwards(70);
		fm.spinLeft();
		fm.spinRight();
		fm.stop();
	}
	
	@Test
	public void testOfLight() 
	{
		FakeLight fl = new FakeLight();
		fl.readValue();
	}
	
	@Test
	public void testOfTouch() 
	{
		FakeTouch ft = new FakeTouch();
		ft.isPressed();
	}
	
	@Test
	public void testOfUltra() 
	{
		FakeUltrasonic fu = new FakeUltrasonic();
		fu.scan();
		fu.getRange();
	}
	
	@Test
	public void testOfSound() throws InterruptedException 
	{
		FakeBadSound fbs = new FakeBadSound();
		fbs.play();
		FakeGoodSound fgs = new FakeGoodSound();
		fgs.play();
		FakeBackUpSound fbus = new FakeBackUpSound();
		fbus.play();
	}
	
	@Test
	public void testOfMessage() 
	{
		GoodMessage gm = new GoodMessage();
		gm.display();
		BadMessage bm = new BadMessage();
		bm.display();
	}
	
	@Test
	public void testOfTime() 
	{
		Time t = new Time();
		t.start();
	}
	
//	@Test
//	public void testCan3() throws InterruptedException 
//	{
//		Can can = new Can(fm, us, light, t, fgs, fbs); 
//		assertEquals(true, can.t.isPressed());
//		FakeLight.value = 50;
//		can.findCanInCircle();
//	}
}



















