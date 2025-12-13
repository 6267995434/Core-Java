package threading;

public class CustomThread2 extends Thread{
	
	
		WaitNotify shared = new WaitNotify();
		public CustomThread2(String name, WaitNotify shared) {
			super(name);
			this.shared = shared;
			start();
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(Thread.currentThread().getName() + " Doing work.");
			shared.doWork();
		}
	}
