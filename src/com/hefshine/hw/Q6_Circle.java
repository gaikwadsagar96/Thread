/*Create Circle class having set Radius(),area(). One thread is calling set
Radius(),another thread is calling area(). Using wait () and notify () implements this
program.*/

package com.hefshine.hw;
class ThreadR extends Thread
{
	Circle c;
	public ThreadR(Circle c) 
	{
		this.c=c;
	}
	@Override
	synchronized public void run() 
	{
		if(c.r<=0)
		{
			c.radius();
			
		}
		else {
			try {
				wait();
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}
class ThreadA extends Thread
{
	Circle c;
	public ThreadA(Circle c) 
	{
		this.c=c;
	}
	@Override
	synchronized public void run() 
	{
		if(c.r<=0)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			c.area();
			notify();
		}
	}
	
}
class Circle
{
	int r=0;
	void radius() 
	{
		r=20;
		System.out.println("radius: "+r);
		
	}
	void area() 
	{	
		System.out.println("Area: "+3.21*r*r);
	}
}
public class Q6_Circle extends Thread 
{
	//int r=0;

	public static void main(String[] args) 
	{
		Circle c=new Circle();
		ThreadR tr=new ThreadR(c);
		ThreadA ta=new ThreadA(c);
		tr.start();
		ta.start();

	}

}
