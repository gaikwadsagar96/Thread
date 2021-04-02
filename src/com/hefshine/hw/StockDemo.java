package com.hefshine.hw;
class Stock
{
	int biscute=0;
	
	synchronized void produce()
	{
		if(biscute<0)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		for (int i = 0; i < 20; i++) 
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			biscute++;
			System.out.println("produce:"+biscute);
		}
		notify();
	}
	synchronized void consume()
	{
		if(biscute<12)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		for (int i = 20; i > 10; i--) 
		{
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("consume:"+biscute);
			biscute--;
		}
		notify();
	}
}
class ConsumeThread extends Thread 
{
	Stock c;
	public ConsumeThread(Stock s) 
	{
		c=s;
	}
	@Override
	public void run() 
	{
		c.consume();
	}

}
class ProduceThread extends Thread
{
	Stock p;
	public ProduceThread(Stock s) 
	{
		p=s;
	}
	@Override
	public void run() 
	{
		
			p.produce();	
	}
}
public class StockDemo 
{
	public static void main(String[] args) 
	{
		Stock s=new Stock();
		ProduceThread pt=new ProduceThread(s);
		ConsumeThread ct=new ConsumeThread(s);
		pt.start();
		ct.start();
	}
}
