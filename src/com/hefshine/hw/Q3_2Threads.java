/*Write a program to create thread1 which displays numbers 1 to 10. thread2 displays
alphabets A to Z. Display that alphabets are printed first and then numbers are printed.
Hint: Use join().*/

package com.hefshine.hw;

import java.util.Currency;
class Number extends Thread
{
	public void run() 
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println(Thread.currentThread().getName()+" : "+i);
		}
	}
}
class Alphabet extends Thread
{
	public void run() 
	{
		char ch='A';
		for(char i=ch;i<='Z';i++)
		{
			System.out.println(Thread.currentThread().getName()+" : "+i);
		}
	}
}
public class Q3_2Threads extends Thread
{	
	public static void main(String[] args) 
	{
		Number t=new Number();
		Alphabet t2=new Alphabet();
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();

	}

}
