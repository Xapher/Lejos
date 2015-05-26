
public class Message 
{
	public static void displayGood()
	{
		System.out.println("Mission complete in "+ Time.calculate() + " seconds");
	}
	
	public static void displayBad()
	{
		System.out.println("Mission failed.");
	}
}
