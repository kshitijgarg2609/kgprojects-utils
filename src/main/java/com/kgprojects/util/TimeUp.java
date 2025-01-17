package com.kgprojects.util;
/**
 * @author Kshitij Garg
 */
public class TimeUp
{
	private long snap_time,timeout;
    public TimeUp(long t)
    {
      timeout=t;
      resetTime();
    }
    public void setTimeOut(long t)
    {
      timeout=t;
    }
    public long getTimeOut()
    {
      return timeout;
    }
    public void resetTime()
    {
    	resetTime(System.currentTimeMillis());
    }
    public void resetTime(long snap_time)
    {
    	this.snap_time=snap_time;
    }
    public boolean timeUp()
    {
      return (System.currentTimeMillis()-snap_time)>=timeout;
    }
}