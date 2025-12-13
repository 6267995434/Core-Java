package threading;

public class SecondThread implements Runnable{
	
	Thread t1;
	public SecondThread() {
		
		t1 = new Thread(this, "second");
		t1.start();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0; i<5; i++) {
			System.out.println(Thread.currentThread().getName() + " count: " + i);
		}
			
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			System.out.println("Iterrupted exception");
		}
	}
	
	public static void main(String[] args) {
		
		SecondThread t2 = new SecondThread();
				
	}

}
