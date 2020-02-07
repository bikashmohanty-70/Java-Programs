package com.bridgelabz.logical_programs;

import com.bridgelabz.utility.Utility;

/**
 * 
 * @author Bikash MOhanty
 * @version 1.0
 * @Created_on: 13th NOv, 2019
 * 
 * purpose: for Measuring time Elapsed between the Start and End of the StopWatch
 *
 */

class Watch extends Thread
{
	private long startTime;
	private boolean started;
	
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
	
	public int[] getTime()
    {
        long milliTime = System.currentTimeMillis() - this.startTime;
        int[] out = new int[]{0, 0, 0, 0};
        out[0] = (int)(milliTime / 3600000);
        out[1] = (int)(milliTime / 60000) % 60;
        out[2] = (int)(milliTime / 1000) % 60;
        out[3] = (int)(milliTime) % 1000;

        return out;
    }

    public void stopThread()
    {
        this.started = false;
    }
}

public class StopWatch
{

	public static void main(String[] args) throws Exception
	{
		
		/*
		 * for(int hr = 0; hr < 24; hr++) for(int min = 0; min < 60; min++ ) for(int ms
		 * = 0; ms < 1000; ms++) System.out.println(hr+ ":"+min+":"+ms);
		 */
		Watch s = new Watch();
		
		System.out.println("Enter 1 to Start and 2 to Stop:");
		int n = Utility.inputInteger();
		if(n == 1)
		{
			s.startThread();
		}

        while (true)
        {
            int[] curTime = s.getTime();
            System.out.println(curTime[0] + " : " + curTime[1] + " : " + curTime[2] + " : " + curTime[3]);
        }
		

	}

}
