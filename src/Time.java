import lejos.util.Stopwatch;


public class Time 
{
	public static int timeToClear;
	static Stopwatch sw = new Stopwatch();
	public static void start()
	{
		sw.reset();
	}
	
	public static int calculate()
	{
		//get milliseconds and convert it to seconds
		int seconds = sw.elapsed()/1000;
		return seconds;
	}
	
}
