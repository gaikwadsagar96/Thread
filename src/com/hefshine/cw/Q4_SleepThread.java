// Write a program to explain the concept of sleep method by an appropriate example.
package com.hefshine.cw;

public class Q4_SleepThread extends Thread
{
	@Override
	public void run() {
		for(int i=0;i<5;i++)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" : "+i);
		}
	}
	public static void main(String[] args) 
	{
		Q4_SleepThread st=new Q4_SleepThread();
		st.start();
	}

}
