package threading;

public class Joins extends Thread{
	
	public Joins(String name) {
		super(name);
		start();
		System.out.println(Thread.currentThread().getName() + "created");
	}
	
	public void run() {
		
		try {
			for(int i=10;i>5;i--) {
				System.out.println(Thread.currentThread().getName() + " in run" + i);
			}
			System.out.println(Thread.currentThread().getName() + " ends");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Joins thread1 = new Joins("1");
		Joins thread2 = new Joins("2");
		Joins thread3 = new Joins("3");
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Interrupted exception");
		}
		
		System.out.println("enna meena deeka");
		
	}
}
