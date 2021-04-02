package com.hefshine.extra;

//import java.time.chrono.ThaiBuddhistChronology;
/*Thread 1 lock the resource 1 and goes into sleep state at that time thread 2 acquire the lock of resource 2 and go to sleep state
at that time thread 1 has lock on resource 1 and thread 2 has lock on thread 2 now thread 1 comes into ready state and tries to acquire to 
lock on resource 2 but thread 2 has resource 2 and thread 2 not realising lock and thread 2 requires resource 1 but thread 1 has 
resource 1 and thread 1  not realising lock of it so it will goes into deadloack state*/   

public class DeadLock 
{
	public static void main(String[] args) 
	{
		final String r1="resource1";
		final String r2="resource2";
		//thread 1 will try to acquire lock resource 1 and then resource 2
		Thread t1=new Thread() {
			public void run() 
			{
				synchronized(r1) //thread1 lock the resource 1 
				{
					System.out.println("thread 1: locked resorce 1");
					try {
						Thread.sleep(100); //thread 1 go to sleep state and then thread 2 will start
					} catch (InterruptedException e) {}
					synchronized (r2) 
					{
						System.out.println("Thread 1:Locked resource 2");
					}
					}
				}
			};
		Thread t2=new Thread() 
		{
			public void run() 
			{
				synchronized (r2) //thread 2 lock the resource 2
				{
					{
						System.out.println("Thread 2 :locked resource 2");
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {}
					synchronized (r1) 
					{
						System.out.println("Thread 2:locked resource 1");
					}
				}
			}
		};
		t1.start();
		t2.start();
	}

}
