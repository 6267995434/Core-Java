package threading;

import java.security.DomainCombiner;

/*Goal: Create two threads:

PrinterThread prints numbers 1 to 5 with 1 second delay.

CharThread prints characters A to E with 1.5 seconds delay.

Run them simultaneously and observe the mixed output.*/

public class PrintedThreads implements Runnable {

	Thread t1;
	Thread t2;
	
	public PrintedThreads() {
		// TODO Auto-generated constructor stub
		
		t1 = new Thread(this, "printer");
		t2 = new Thread(this, "charthread");
		
		t1.setPriority(10);
		t1.start();
		
		t2.setPriority(3);
		t2.start();
	}
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		String name = Thread.currentThread().getName();
		
		if(name.equals("printer")) {
		for(int i=1; i<=5; i++) {
			System.out.println(Thread.currentThread().getName() + " count " + i);
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				System.out.println("Interrupted thread");
			}
		}
		}
		
		if(name.equals("charthread")) {
		for(int i=1; i<=5; i++) {
			System.out.println(Thread.currentThread().getName() + " aplha: " + (char)(i+64));
			try {
				Thread.sleep(1500);
			}
			catch(InterruptedException e) {
				System.out.println("Interrupted thread");
			}
		}
		}
		
	}
	
	public static void main(String[] args) {
		
	PrintedThreads p1 = new PrintedThreads();
	}
}

