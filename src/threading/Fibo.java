package threading;

import java.util.ArrayList;
import java.util.List;

public class Fibo {
	
	
	    public static void main(String[] args) {
	        System.out.println("Try programiz.pro");
	    
	       
	    
			ArrayList<Integer> list = new ArrayList<>();
			
			int n = 5; 
			
			int sum = 0;
			
			for(int i=0 ; i<n; i++){
			
			sum += i;
			list.add(sum);
		}
			for(int i : list){
			    System.out.print(i + " ");
			}
		}
	}


