//Write a program to give the implementation of a thread and pausing of a thread
//till completion of main thread using yield ().
package com.hefshine.cw;

import java.util.TreeMap;

class demo extends Thread
{
	@Override
	public void run() 
	{
		for(int i=0;i<15;i++)
		{
			System.out.println(Thread.currentThread().getName()+" : "+i);
		}
	}
}
class demo2 extends Thread
{
	@Override
	public void run() 
	{
		for(int i=0;i<15;i++)
		{
			System.out.println(Thread.currentThread().getName()+" : "+i);
		}
	}
}

public class Q6_YeildThread extends Thread
{
	@Override
	public void run() 
	{
		for(int i=0;i<10;i++)
		{
			Thread.currentThread().yield();
			System.out.println(Thread.currentThread().getName()+" : "+i);
		}
	}
	public static void main(String[] args) 
	{
		
		Q6_YeildThread yt=new Q6_YeildThread();
		demo d=new demo();
		demo2 d2=new demo2();
		yt.setName("main");
		d.setName("demo");
		d2.setName("demo2");
		yt.setPriority(MAX_PRIORITY);
		yt.start();
		d.start();
		d2.start();
		
		

	}

}
