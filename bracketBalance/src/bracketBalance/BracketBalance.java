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
		
		File file = new File("outputBreacketBalance.txt");
		FileWriter fileWriter = new FileWriter(file, true);
		
		StringBuilder stringBuilder = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new FileReader(new File("inputBracketBalance.txt")));
		BufferedWriter bw = new BufferedWriter(fileWriter);
		
		String s ="";
		String salida = ""; 
		while((s=br.readLine())!=null) {
			Stack<Character> p = new Stack<>();
			
			boolean auxStop = true;
			
			char[] c = s.toCharArray();

			for (int i = 0; i < c.length && auxStop; i++) {
				if (c[i] == '(') {
					p.push(c[i]);
				}else if(c[i]=='{') {
					p.push(c[i]);
				}else if(c[i]== '[') {
					p.push(c[i]);
				}else if((c[i]== ')'||c[i]=='}'||c[i]==']') && p.isEmpty()) {
//					bw.write("false");
					auxStop = false;	
					//bw.flush();
				}

				else if(c[i]== ')') {
					if(p.peek() == '(') {
						p.pop();	
					}else {
						auxStop = false;
					}
				}else if(c[i]=='}') {
					if(p.peek()=='{') {
						p.pop();
					}else {
						auxStop = false;
					}
				}else if(c[i]==']') {
					if(p.peek()=='[') {
						p.pop();
					}else {
						auxStop = false;
					}
				}
			}
			if(p.isEmpty()) {
				stringBuilder.append("True\n");
//				System.out.println("Esta vacio");
//				bw.write("True");
				//bw.flush();
			}else {
				stringBuilder.append("False\n");
//				System.out.println("NO Esta vacio");
//				bw.write("False");
				//bw.flush();
			}
		}
		
		bw.write(stringBuilder.toString());
		br.close();
		bw.close();

	}

}
