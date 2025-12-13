package threading;

public class Testing {
	
	public static void main(String[] args) {
		
	
	
	WaitNotify shareData = new WaitNotify();
	
	CustomThread cs1 = new CustomThread("one", shareData);
	CustomThread2 cs2 = new CustomThread2("two", shareData);
	
	}
}
