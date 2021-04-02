/*Write a program to show the concept of synchronization by this simple example: Thread1
consumes biscuits from a box, Thread2 produces fixed number of biscuits at a time say 20. Write a
program in which Thread1 checks for sufficient biscuits in box, it waits for Thread2 to produce if
sufficient biscuits are not available in the box and then consumes given number of biscuits. Thread2
will notify Thread1 after it finishes producing biscuits.*/
package com.hefshine.cw;
import java.util.*;
class ProduceThread extends Thread
{
	Q9_Biscuits b;
	public ProduceThread(Q9_Biscuits b) 
	{
		this.b=b;
	}
	@Override
	public void run() 
	{
		b.produce();
	}
}
class ConsumeThread extends Thread
{
	Q9_Biscuits b;
	public ConsumeThread(Q9_Biscuits b)
	{
		this.b=b;
	}
	@Override
	public void run() 
	{
		b.cunsume();
	}
}
public class Q9_Biscuits 
{
	static int n=0,c=0;
	Scanner sc=new Scanner(System.in);
	synchronized public void produce() 
	{
		if(c==0)
		{
			System.out.println("Wait producing biscuits");
			System.out.print("Enter Number of biscuits to produce:");
			n=sc.nextInt();
			for(int i=0;i<=n;i++)
			{
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(i+" Biscuits is added to basket");
				c++;
			}
			System.out.println(c+" sufficient biscuit in basket");
		}
		notifyAll();
	}
	
	synchronized public void cunsume() 
	{
		if(c==0)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("wait removing Biscuits from basket");
			for(int i=0;i<n;i++)
			{
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				c--;
				System.out.println("Removing "+c+" Biscuit");
			}
			
		}
	}
	public static void main(String[] args) 
	{
		 Q9_Biscuits b=new Q9_Biscuits();
		 ProduceThread pt=new ProduceThread(b);
		 ConsumeThread ct=new ConsumeThread(b);
		 pt.start();
		 ct.start();
	}
}
