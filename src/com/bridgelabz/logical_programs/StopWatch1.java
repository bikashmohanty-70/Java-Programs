package com.bridgelabz.logical_programs;

/**
 * 
 * @author Bikash MOhanty
 * @version 1.0
 * @Created_on: 13th NOv, 2019
 * 
 * purpose: for Measuring time Elapsed between the Start and End of the StopWatch
 *
 */

class Watch1 extends Thread
{
	private long startTime;
	private boolean started;
	private long getTime;
	
	public void startThread()
	{
		this.startTime = System.currentTimeMillis();
		this.started = true;
		this.start();	
	}
	
	public void run()
	{
		while(started)
		{
			
		}
	}
	public void stopThread() throws InterruptedException
    {
		Thread.sleep(8000);
        this.started = false;
        this.getTime = (long) ((System.currentTimeMillis() - this.startTime)/1000.0);
        System.out.println(this.getTime);
    }
}
public class StopWatch1 
{

	public static void main(String[] args) throws InterruptedException 
	{
		Watch1 s = new Watch1();
		s.startThread();
		for(int i = 1; i <= 10; i++)
		{
			s.stopThread();
		}
			

	}

}
