/*4) Write a program to display a synchronized method and 2 threads in which the threads are trying
to update same thread. See how the synchronization works*/
package com.hefshine.hw;

import java.util.Scanner;

class ProducerThread extends Thread 
{
	Q4_SynchronizationDemo c;

	public ProducerThread(Q4_SynchronizationDemo c)
	{
		this.c = c;
	}

	public void run() 
	{
		c.producer();
	}
}

class ConsumesThread extends Thread 
{
	Q4_SynchronizationDemo c;

	public ConsumesThread(Q4_SynchronizationDemo c) 
	{
		this.c = c;
	}
	public void run() 
	{
		c.consumes();
	}

}

class Q4_SynchronizationDemo 
{
	Scanner sc = new Scanner(System.in);
	public static int c = 0, n = 0;
	synchronized public void producer() 
	{
		if (c == 0) 
		{
			System.out.println("Waiting to Adding chocolates in basket ");
			System.out.println("Enter The Number Of Chocolates ");
			n = sc.nextInt();
			for (int i = 1; i <= n; i++) 
			{
				c++;
				System.out.println("chocolates in basket " + c);
			}
			System.out.println("sufficient chocolates in basket " + c);
		}
		notifyAll();
	}

	synchronized public void consumes() 
	{
		if (c == 0) 
		{
			try {
				wait();
			} catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("Waiting to Remove chocolates in basket ");
			for (int i = 1; i <= n; i++) {
				c--;
				System.out.println("chocolates in basket " + c);
			}

		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Q4_SynchronizationDemo c = new Q4_SynchronizationDemo();
		ProducerThread pt = new ProducerThread(c);
		ConsumesThread ct = new ConsumesThread(c);
		pt.start();
		ct.start();
	}

}
