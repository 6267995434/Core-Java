package threading;

public class CustomThread extends Thread {
	WaitNotify shared = new WaitNotify();
	public CustomThread(String name, WaitNotify shared) {
		super(name);
		this.shared = shared;
		start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println(Thread.currentThread().getName() + " " + shared.getResult());
		
		
	}
}
