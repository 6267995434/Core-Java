package threading;


// Volatile keyword : changes made to any variable with volatile keyword are reflected to all threads immediately
public class Volatiles implements Runnable{

	String tn;
	Thread t1;
	boolean flag = true;
	
	public Volatiles(String name) {
		
		tn = name;
		t1 = new Thread(this,tn);
		t1.start();
		// TODO Auto-generated constructor stub
	}
	
	public void StopRunning() {
//		?System.out.println("Stopping thread: " + t.getName());
		flag = false;
		
	}
	
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(flag) {
			System.out.println(Thread.currentThread().getName() + "running");
			 try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                System.out.println("Interrupted");
	            }
		}
		System.out.println("Stopped .. " + Thread.currentThread().getName());
	}
	
	
	public static void main(String[] args) {
		
		
		Volatiles t1 = new Volatiles("thread1");
		Volatiles t2 = new Volatiles("Thread2");
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1.StopRunning();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.StopRunning();
		
	}
}
