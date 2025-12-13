package chatgptTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//  we cannot use wait and notify with Reentrant Class as it uses lock system so we cannot use synchronized key word with 


//test2
/*
 * Create a Buffer class with the following:

A list that represents the shared buffer.

Methods for adding and removing products from the buffer.

Use wait() and notify() to coordinate the producer and consumer.

Use ReentrantLock to lock and unlock when modifying the buffer.
 */
public class Shared {
	
	private final int length = 10;
	
	private List<Integer> list = new ArrayList<>();
	private  Lock lock = new ReentrantLock();
	

	public Shared(List<Integer> l) {
		this.list = l;
		
	}
	
	
	public synchronized void add(int element) throws InterruptedException {
		
		
		lock.lock();
		
		try {
			
			while(list.size() == length) {
				wait();
			}
			
			list.add(element);
			System.out.println("Producer produces: " + element);
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}
		
		
		return;
	}
	
	public synchronized void remove() throws InterruptedException {
		
		lock.lock();
		
		try {
			
			while(list.isEmpty()) {
				
				wait();
			}
			System.out.println("Consumer cosumes: " + list.get(list.size() - 1));
			list.remove(list.size() - 1);
			notify();
			
		} finally {

			// TODO: handle finally clause
			lock.unlock();
		}
	}
	
}
