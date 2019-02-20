package bracketBalance;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BracketBalance {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String s = bf.readLine();
		Stack<Character> p = new Stack<>();
		
		char[] c = s.toCharArray();
		try {
			for (int i = 0; i < c.length; i++) {
				if (c[i] == '(') {
					p.push(c[i]);
				}else if(c[i]=='{') {
					p.push(c[i]);
				}else if(c[i]== '[') {
					p.push(c[i]);
				}else if(c[i]== ')') {
					if(p.peek() == '(') {
						p.pop();	
					}else {
						break;
					}
				}else if(c[i]=='}') {
					if(p.peek()=='{') {
						p.pop();
					}else {
						break;
					}
				}else if(c[i]==']') {
					if(p.peek()=='[') {
						p.pop();
					}else {
						break;
					}
				}
			}
			if(p.isEmpty()) {
				System.out.println("true");
			}else {
				System.out.println("false");
			}
		}catch(Exception e ){
			System.out.println("false");
			e.printStackTrace();
			
		}
		
	
	}
	
}
