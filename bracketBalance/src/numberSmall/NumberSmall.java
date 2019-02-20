package numberSmall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NumberSmall {

	public static void main(String ...args) throws IOException {
		System.out.println("Indique el numero de veces que quiere que se elimine");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(bf.readLine());
		String s = bf.readLine();
		Stack<Integer> p = new Stack<>();
		Queue<Integer> q = new LinkedList<Integer>();
		String[] numbers = s.split(" ");
		for (int i = 0; i < numbers.length; i++) {
			q.add(Integer.parseInt(numbers[i]));
		}
		p.push(q.poll());
		while (k > 0 && !q.isEmpty()) {
			Integer num = q.poll();
			if (num > q.peek()) {
				while (k > 0  && !p.isEmpty() && num > p.peek()) {
					p.pop();	
					k--;
				}
				p.push(num);
			}else {
				k--;
			}
		}
		String toPrint = "";
		for (Integer num : p) {
			toPrint = num + " " + toPrint;
		}
		
		for (Integer num : q)     {
			toPrint += " "+ num;
		}
		
		System.out.println(toPrint);

	}

}
