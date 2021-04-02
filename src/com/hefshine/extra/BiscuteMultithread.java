package com.hefshine.extra;

import java.util.ArrayList;
import java.util.List;
class ProduceT extends Thread
{
	List<Integer> b;
	public ProduceT(List<Integer> b) 
	{
		this.b=b;
	}
	@Override
	public void run() 
	{
		synchronized(b)
		{
		while(true)
		{
			if(b.size()>0)
			{
				try {
					b.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				produceBuiscute();
			}
		}
		}
	}
	private void produceBuiscute() 
	{
		for (int i = 11; i <=20; i++) 
		{
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			b.add(i);
			System.out.println("produce Buiscute: "+i);
		}
		b.notifyAll();
	}
}
class ConsumeT extends Thread
{
	List<Integer> b;
	public ConsumeT(List<Integer> b) 
	{
		this.b=b;
	}
	@Override
	public void run() 
	{
		while(true)
		{
			synchronized(b){
				if(b.size()==0) 
				{
					try {
						b.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					consume();
				}
			}
		}
	}
	private void consume() 
	{
		while(!b.isEmpty()) {
			try {
				Thread.sleep(200);
				System.out.println("Buiscuite consume: "+b.remove(0));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.notifyAll();
	}
}
public class BiscuteMultithread 
{
	public static void main(String[] args) 
	{
		List<Integer> b=new ArrayList<Integer>();
		ProduceT pt=new ProduceT(b);
		ConsumeT ct=new ConsumeT(b);
		pt.start();
		ct.start();
	}

}
