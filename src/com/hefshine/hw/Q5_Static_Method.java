/*Write a program to check and display if threads Thread1 and Thread2 are accessing static
synchronized method concurrently.*/
package com.hefshine.hw;
class Table1
{
	synchronized static void printTable(int v)
	{
		for(int i=1;i<=10;i++)
			System.out.println(Thread.currentThread().getName()+" : "+v*i);
	}
}
class Thread1 extends Thread
{
	@Override
	public void run() 
	{
		Table1.printTable(5);
	}
}
class Thread2 extends Thread
{
	public void run() 
	{
		Table1.printTable(10);

	}
}
public class Q5_Static_Method 
{

	public static void main(String[] args) 
	{
		Thread1 t1=new Thread1();
		Thread2 t2=new Thread2();
		t1.start();
		t2.start();
	}

}
