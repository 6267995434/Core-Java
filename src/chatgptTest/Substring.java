package chatgptTest;

public class Substring {
public static void main(String[] args) {
	
	String s = "abc";
	
	char[] ch = s.toCharArray();
	
	for(int i=0; i<s.length();i++) {
		
		for(int j=1; j<s.length()-1;j++) {
			
			String sp = ch[i] + "" + ch[j];
			System.out.print(ch[i] +""+ ch[j] + ", ");
			
		}
	}
}
}
