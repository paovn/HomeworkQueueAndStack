package bracketBalance;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Stack;

public class BracketBalance {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(new File("inputBracketBalance.txt")));
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("outputBreacketBalance.lol")));
		String s ="";
		
		while((s=br.readLine())!=null) {
			Stack<Character> p = new Stack<>();
			
			char[] c = s.toCharArray();
			
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
					bw.write("true");
					bw.flush();
				}else {
					bw.write("false");
					bw.flush();
				}
				
			
		}
		br.close();
		bw.close();
		
	
	}
	
}
