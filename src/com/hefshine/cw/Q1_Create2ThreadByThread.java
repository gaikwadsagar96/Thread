//Write a program to create 2 threads by extending the thread class and then run them concurrently
package com.hefshine.cw;

public class Q1_Create2ThreadByThread extends Thread
{
	@Override
	public void run() 
	{
		for(int i=0;i<5;i++)
			System.out.println(getName()+" : "+i);
			
	}

	public static void main(String[] args)
	{
		Q1_Create2ThreadByThread ct=new Q1_Create2ThreadByThread();
		Q1_Create2ThreadByThread ct1=new Q1_Create2ThreadByThread();
		ct.start();
		System.out.println(ct.getName());
		ct1.start();
		 
	}

}
