package chatgptTest;

import java.util.Stack;

public class StringRev {
	
	public static void main(String[] args) {
		
		String s = "hello world"; 
		String res = "";
		
		Stack<Character> stc = new Stack<>();
		char[] ch = s.toCharArray();
		
		for(int i = s.length()-1; i>=0; i--) {
			
			if(ch[i] != ' ') {
				stc.push(ch[i]);
			}else {
				if(res.isEmpty()) {
					while(!stc.isEmpty()) {
					res += stc.pop();
					}
				}else {
					res += " ";
					while(!stc.isEmpty()) {
						res += stc.pop();
						}
				}
			}
			
		}
		
		if(!stc.isEmpty()) {
			
		res += " ";
		while(!stc.isEmpty()) {
			res += stc.pop();
			}
		}
		
		System.out.println(res);
		
	}
}
