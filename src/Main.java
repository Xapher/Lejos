
public class Main 
{
	public static void main(String[] args) throws InterruptedException 
	{
//		BackUpSound vs = new BackUpSound();
//		vs.play();
		
		Time.start();
		while(Time.calculate() < 60)
		{
			System.out.println(Time.calculate());
			if(Time.calculate() == 10)
			{
				Time.timeToClear = Time.calculate();
			}
			Thread.sleep(1000);
		}
		System.out.println("Time: " + Time.timeToClear);
		Thread.sleep(3000);
			
		//Find can in circle
		
		
		
		
		
//		Can can = new Can();
//		can.findCanInCircle();
//		while(can.existInCircle())
//		{
//			can.removeCanFromCircle();
//		}
		
		
		
		
		
		
		/*
		 *  Find can in circle
			While cans exist … push can out of circle
			Play appropriate sound 
			Calculate time
			Display appropriate message
			leave circle
		 */
		
		System.out.println("FASDF");
	}
	
	
}
