/*Write a program to display that main thread calls join() and wait for the child
thread to get executed first and then gets completed by writing two threads main
and child thread*/
package com.hefshine.cw;
class child extends Thread
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
public class Q07_JoinThread 
{

	public static void main(String[] args) throws InterruptedException 
	{
		child c=new child();
		c.start();
		c.join();
		for(int i=0;i<15;i++)
		{
			System.out.println(Thread.currentThread().getName()+" : "+i);
		}
		

	}

}
