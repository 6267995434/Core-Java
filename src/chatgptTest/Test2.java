package chatgptTest;

import java.util.Arrays;
import java.util.List;

/*
 * You need to implement the Producer-Consumer Problem using both wait(), notify(), and lock() in Java. Here's the setup:

Producer: The producer produces a product and places it in a shared buffer. If the buffer is full, the producer will wait until there is space in the buffer.

Consumer: The consumer consumes the product from the buffer. If the buffer is empty, the consumer will wait until there is something to consume.

The shared buffer should have a fixed size, and you need to handle synchronization between the producer and consumer using the following:

wait() and notify() (to control when to wait and when to notify that work is done)

ReentrantLock for thread synchronization to ensure mutual exclusion when accessing the buffer.

*/
public class Test2 {
  
	public static void main(String[] args) {
		
		System.out.println("starting point");
	
	List<Integer> list = Arrays.asList(2,1,3,2);
	int i = list.size();
	Shared s = new Shared(list);
	
	ProducerThread t1 = new ProducerThread(s, "One", 32); //adding 5 by producer
	ConsumerThread t2 = new ConsumerThread(s, "two"); //removing last index
	
	try {
		t1.join();
		t2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("At the end");
	
	}	
	
}
