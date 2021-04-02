//Write a program to extend class Thread and create thread also implement runnable
//interface and create thread execute threads simultaneously.
package com.hefshine.hw;
class ThreadDemo extends Thread
{
	@Override
	public void run() 
	{
		Thread.currentThread().setName("ThreadClassThread");
		for(int i=0;i<5;i++)
		{
			System.out.println(Thread.currentThread().getName()+" : "+i);
		}
	}
}

public class Q1_CreateThread implements Runnable
{
	public void run() 
	{
		Thread.currentThread().setName("RunnableClassThread");
		for(int i=0;i<5;i++)
		{
			System.out.println(Thread.currentThread().getName()+" : "+i);
		}
		
	}
	public static void main(String[] args) 
	{
		Q1_CreateThread ct=new Q1_CreateThread();
		ThreadDemo td=new ThreadDemo();
		Thread t=new Thread(ct);
		td.start();
		t.start();
		
		
	}

	

}
