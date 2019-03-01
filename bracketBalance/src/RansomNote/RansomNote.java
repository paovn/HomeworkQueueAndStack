package RansomNote;

import java.util.Hashtable;
import java.util.Scanner;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RansomNote {
	
	static void checkMagazine(String[] magazine, String[] note) {
		Hashtable<String,Integer> contenedor=new Hashtable<String,Integer>();
		
		//Llenado de la hashTable
		for (int i = 0; i < magazine.length; i++) {
			if(contenedor.containsKey(magazine[i])) {
				contenedor.put(magazine[i],contenedor.get(magazine[i]+1));
				
			}else {
				contenedor.put(magazine[i], 1);
			}
        }
		//comparacion de la hash con el arreglo
		boolean parar = false;
		for (int i = 0; i < note.length&&!parar; i++) {
			if(contenedor.containsKey(note[i])) {
				if(contenedor.get(note[i])>0) {
					contenedor.put(note[i],contenedor.get(note[i])-1);
				}else {
					parar = true;
					System.out.println("No");
				}
			}else {
				parar = true;
				System.out.println("No");
			}
		}
		if(!parar) {
			
			System.out.println("yes");
		}
		
    }
	
	private static final Scanner scanner = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;

        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
