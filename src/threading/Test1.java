package threading;
/*
 * Create two threads using Runnable.

One thread should print numbers from 10 to 1 (descending) with 1 second delay.

The other should print letters from J to A (reverse alphabet from 'J') with 1.5 seconds delay.

Start both threads from the main method and make sure they run simultaneously.

Assign different priorities t
 */
public class Test1 implements Runnable{

	Thread t1;
	Thread t2;
	
	String name1,name2;
	
	public Test1(String thread1, String thread2) {
		
		name1 = thread1;
		name2 = thread2;
		
		t1 = new Thread(this,name1);
		t2 = new Thread(this,name2);
		
		t1.setPriority(4);
		t2.setPriority(2);
		
		t1.start();
		t2.start();
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
			if(Thread.currentThread().getName().equals("t1")) {
				int i = 10;
				while(i >= 1){
					System.out.println(Thread.currentThread().getName() + " counts: " + i);
				
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i--;
				}
			}
			
			if(Thread.currentThread().getName().equals("t2")) {
			
				
				
					char x = 'J';
					while(x >= 'A'){
					
					System.out.println( Thread.currentThread().getName() + " counts: " + x);
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					x--;
					}
			}
				
	}
	
	public static void main(String[] args) {
		
		Test1 obj = new Test1("t1", "t2");
		System.out.println("running starts:");
//		obj.run();
//		System.out.println("running ends:");
	}
}
