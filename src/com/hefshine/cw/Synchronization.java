package com.hefshine.cw;

class Biscuit
{   boolean flag=false;
    int n;
	synchronized void put(int n)
	{
		if(flag)
		{
			try 
			{wait();}
			catch (InterruptedException e) 
			{e.printStackTrace();}
		}
		this.n=n;
		System.out.print("\nput: ");
		for(int i=1;i<=20;i++)
		{
			System.out.print(i+" ");
		}
		notify();
		flag=true;
	}
	synchronized void get()
	{
		if(!flag)
		{
			try {wait();}
			catch (InterruptedException e) 
			{e.printStackTrace();}	
		}
		System.out.print("\nget:");
		for(int i=1;i<=20;i++)
		{
			System.out.print(i+" ");
		}
		
		notify();
		flag=false;
	}
}
class Producer extends Thread
{
	Biscuit b;
	Producer(Biscuit b)
	{
		this.b=b;
	}
	public void run()
	{
		int i=0;
		while(i<5)
		{
			b.put(1);
			i++;
		}
	}
}
class Consumer extends Thread
{
	Biscuit b;
	Consumer(Biscuit b)
	{
		this.b=b;
	}
	public void run()
	{
		
		while(true)
		{
			b.get();
		}
	}
}

public class Synchronization{

	public static void main(String[] args) 
	{
      Biscuit b=new Biscuit();
      
      Producer t1=new Producer(b);
      Consumer t2=new Consumer(b);
      
      t1.start();
      t2.start();
	}

}