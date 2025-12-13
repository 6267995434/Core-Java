package threading;

import java.util.ArrayList;

public class DD {
	 public static void main(String[] args) {
		
//		 int[] arr = new int[3]?
		 
		 int n = 4;
		 
		 // 0 1 1 2
		 
		 int sum = 0,prev = 1;
		 
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 
		 if(n>0) {
			 list.add(sum);
		 }
		 if(n>1) {
			 list.add(prev);
		 }
		 
		 for(int i = 2 ; i < n; i++) {
			 
			 list.add(sum + prev);
			 
			 sum = prev;
			 prev = list.getLast();
		 }
		 
		 
		 
		 for (Integer i : list) {
			System.out.print( i  + " ");
		}
	}
}
