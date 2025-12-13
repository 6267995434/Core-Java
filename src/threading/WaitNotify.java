package threading;

public class WaitNotify {
		int data = 0;
	public synchronized void doWork() {
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		data = 1;
		notify();
	}
	
	public synchronized int getResult() {
		
		try {
			Thread.sleep(1000);
			wait();	
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
		}
		
		return data;
	}
}
