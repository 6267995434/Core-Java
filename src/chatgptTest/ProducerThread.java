package chatgptTest;

import java.util.ArrayList;
import java.util.List;

public class ProducerThread extends Thread {
	
	List<Integer> list = new ArrayList<Integer>();
	
	Shared s = new Shared(list);
	String name;
	int i; //integer to be add
	
	public ProducerThread(Shared ss , String n, int j) {
		
		
		super(n);
		this.name = n;
		this.i=j;
//		this.list=l;
		this.s = ss;
		
		start();
	
	}
	
	
	public void run() {
		
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());
			s.add(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
