/*Create a class Item which has sell and buy method when one thread is updating the item the
other thread should not execute on same item.(April Monthly).*/
package com.hefshine.cw;

import javax.swing.CellEditor;

class BuyItemThread extends Thread
{
	Q10_Item i;
	BuyItemThread(Q10_Item i)
	{
		this.i=i;
	}
	@Override
	public void run() 
	{
		i.Buy();
	}
}
class SellItemThread extends Thread
{
	Q10_Item i;
	SellItemThread(Q10_Item i)
	{
		this.i=i;
	}
	@Override
	public void run() 
	{
		i.Sell();
	}
}
public class Q10_Item 
{
	static int noOfItems=0,n=10;
	synchronized public void Buy() 
	{
		if(noOfItems==0)
		{
			System.out.println("wait buying item");
			for(int i=0;i<=n;i++)
			{
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				noOfItems++;
				System.out.println(noOfItems+" item is buy");
			}
			
		}
		notifyAll();
			
	}


	synchronized public void Sell()
	{
		if(noOfItems==0)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else
		{
			for(int i=0;i<=n;i++)
			{
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				noOfItems--;
				System.out.println(noOfItems+" item is sell");
			}
		}	
	}
	public static void main(String[] args) 
	{
		Q10_Item i=new Q10_Item();
		BuyItemThread it=new BuyItemThread(i);
		SellItemThread st=new SellItemThread(i);
		it.start();
		st.start();
	}
}
