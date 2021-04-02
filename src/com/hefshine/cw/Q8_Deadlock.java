//Write a program to illustrate an example of deadlock
package com.hefshine.cw;

class DeadlockDemo
{
	void m1()
	{
		for(int i=0;i<5;i++)
			System.out.println("thread executes synchronized method m1");
	}
	void m2()
	{
		for(int i=0;i<5;i++)
			System.out.println("thread executes synchronized method m2");
	}
}
class DeadLockDemoThread1 extends Thread
{
	DeadlockDemo d;
	DeadlockDemo d1;
	public DeadLockDemoThread1(DeadlockDemo d, DeadlockDemo d1) 
	{
		//super();
		this.d = d;
		this.d1 = d1;
	}
	public void run() 
	{
		synchronized(d)
		{
			System.out.println("Thread executing synchronized method m1 fst");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(d1)
			{
				System.out.println("Thread executing  synchronized method m2");
			}
		}
	}
	
}

class DeadlockDemoThread2 extends Thread
{
	DeadlockDemo d;
	DeadlockDemo d1;
	DeadlockDemoThread2(DeadlockDemo d,DeadlockDemo d1)
	{
		this.d=d;
		this.d1=d1;
	}
	public void run() 
	{
		synchronized(d1)
		{
			System.out.println("thread executing synchronized method m2");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(d)
			{
				System.out.println("thread executing synchronized method m1");
			}
		}
	}
}
public class Q8_Deadlock {

	public static void main(String[] args) 
	{
		DeadlockDemo d=new DeadlockDemo();
		DeadlockDemo d1=new DeadlockDemo();
		DeadLockDemoThread1 t1=new DeadLockDemoThread1(d, d1);
		DeadlockDemoThread2 t2=new DeadlockDemoThread2(d, d1);
		t1.start();
		t2.start();
	}

}
