//Write a program to explain and display the concept of daemon thread.

package com.hefshine.cw;
class Deamon extends Thread
{
	@Override
	public void run() {
		for(int i=0;i<15;i++)
		{
			System.out.println(Thread.currentThread().getName()+" :"+i);
		}
	}
}
class User extends Thread
{
	@Override
	public void run() {
		for(int i=0;i<15;i++)
		{
			System.out.println(Thread.currentThread().getName()+" :"+i);
		}
	}
}
public class Q5_DeamonThread 
{

	public static void main(String[] args) 
	{
		Deamon t1=new Deamon();
		User t2=new User();
		t1.setName("demon");
		t2.setName("user");
		t1.setDaemon(true);
		t1.start();
		t2.start();
	}

}
