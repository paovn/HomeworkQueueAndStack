package numberArrayTwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class TwoArrays {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String arr1s = reader.readLine();
		String arr2s = reader.readLine();
		int x = Integer.parseInt(reader.readLine());
		
		String[] arr1ss = arr1s.split(" ");
		String[] arr2ss = arr2s.split(" ");
		int[] arr1 = new int[arr1ss.length];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = Integer.parseInt(arr1ss[i]);
		}
		
		Hashtable<Integer,Integer> hash = new Hashtable<>();
		for (int i = 0; i < arr2ss.length; i++) {
			hash.put(Integer.parseInt(arr2ss[i]), i);
		}
		
		for (int i = 0; i < arr1.length; i++) {
			if (hash.containsKey(x-arr1[i])) {
				System.out.println(i+","+hash.get(x-arr1[i]));
			}
		}

	}
}
