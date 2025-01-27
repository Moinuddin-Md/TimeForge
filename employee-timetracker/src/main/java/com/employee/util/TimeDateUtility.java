package com.employee.util;

import java.time.LocalTime;

public class TimeDateUtility 
{
	public static String getCurrentTime()
	{
		LocalTime lt=LocalTime.now();
		String time=lt.getHour()+":"+lt.getMinute()+":"+lt.getSecond();
		return time;
	}
	public static String getTotalTime(String intime,String outtime)
	{
		int intimes=getTimeInSeconds(intime);
		int outtimes=getTimeInSeconds(outtime);
		int totals=intimes-outtimes;
		int h=totals/3600;
		int s=totals%3600;
		int m=s/60;
		s=s%60;
		String total=h+"hr,"+m+"min,"+s+"sec";
		return total;
	}
	private static int getTimeInSeconds(String time)
	{
		String[] x=time.split(":");
		int total=Integer.parseInt(x[0])*3600+Integer.parseInt(x[1])*60+Integer.parseInt(x[2]);
		return total;
	}
	public static String changeDateFormat(String date)
	{
		String[] x=date.split("-");
		return x[2]+"-"+x[1]+"-"+x[0];
	}
	public static String getEid(String name)
	{
		String eid=name.substring(name.indexOf('(')+1,name.indexOf(')'));
		return eid;
	}
}
