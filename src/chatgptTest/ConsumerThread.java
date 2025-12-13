package chatgptTest;

import java.util.ArrayList;
import java.util.List;

public class ConsumerThread extends Thread{

	List<Integer> list = new ArrayList<Integer>();
	int length = list.size();
	Shared s = new Shared(list);
	String name;
	
	public ConsumerThread(Shared ss,String n) {
		
		super(n);
		this.name = n;
		this.s = ss;
		
		start();
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(1200);
			System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());
			s.remove();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
