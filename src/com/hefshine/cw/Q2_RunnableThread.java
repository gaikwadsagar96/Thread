//Write a program to create three threads using the Runnable interface and then running them concurrently
package com.hefshine.cw;

public class Q2_RunnableThread implements Runnable
{
	public void run() 
	{
		for(int i=0;i<=5;i++)
			System.out.println(i);
		
	}
	public static void main(String[] args) 
	{
		Q2_RunnableThread rt=new Q2_RunnableThread();
		Q2_RunnableThread rt1=new Q2_RunnableThread();
		Q2_RunnableThread rt2=new Q2_RunnableThread();
		Thread t1=new Thread(rt);
		Thread t2=new Thread(rt1);
		Thread t3=new Thread(rt2);
		t1.start();
		t2.start();
		t3.start();

	}

	

}
