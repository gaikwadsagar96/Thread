// Write a program in which first thread displays days of a week. Second thread display tableof 5.
//Third thread displays Fibonacci series by creating 3 threads.
package com.hefshine.hw;
class Day extends Thread
{
	@Override
	public void run() {
		currentThread().setName("day thread");
		String a[]= {"sunday","monday","Tuesday","Wensday","Thursday","Friday","saturday"};
		for(int i=0;i<a.length;i++)
		{
			System.out.println(currentThread().getName()+" : "+a[i]);
		}
	}
	
}
class Table extends Thread
{
	@Override
	public void run() 
	{
		currentThread().setName("Table thread");
		for(int i=1;i<=10;i++)
		{
			System.out.println(currentThread().getName()+" : "+5*i);
		}
	}
}
class Fibonacci extends Thread
{
	@Override
	public void run() 
	{
		currentThread().setName("fibonacci");
		int n1=0,n2=1,n3,count=10;
		System.out.println(n1+"\t"+n2+"\t");
		for(int i=0;i<=count;i++)
		{
			n3=n1+n2;
			System.out.println(currentThread().getName()+" : "+n3);
			n1=n2;
			n2=n3;
		}
	}
}
public class Q2_3Threads
{
	public static void main(String[] args) 
	{
		Day t1=new Day();
		Table t2=new Table();
		Fibonacci t3=new Fibonacci();
		t1.start();
		t2.start();
		t3.start();
	}
}
