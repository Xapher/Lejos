package lejosRover;
import java.util.Calendar;
import java.util.Date;


public class Mrs implements Runnable {

	@Override
	public void run() {
		int i = 0;
		Calendar start = Calendar.getInstance();
		while(!Thread.interrupted())
		{
			System.out.println("he" + i);
			i++;
		}
		System.out.println(Calendar.getInstance().compareTo(start));
	}

}
