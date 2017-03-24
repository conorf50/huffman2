package utils;

import java.io.File;
import models.Node;
import java.io.FileNotFoundException;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;



import controllers.Main;

public class FileIO {
	private static File inputFile  = new File("string.txt");
	HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
	private static int occurance = 1;

	
	public static char charParser() throws FileNotFoundException {
		 
		 String inputFile  = "AAaFBCCHDDD";
		 HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		 Queue<Node> pQueue = new PriorityQueue<>();


			Scanner sc = new Scanner(inputFile);

			while(sc.hasNextLine()){
				char ch = sc.findInLine(".").charAt(0);
				if(charMap.containsKey(ch)){
					
					occurance++;
					System.out.println(occurance);
				}
				else{
					occurance = 1;
				}
					System.out.println(ch);			
				// Put this into a HashMap with value c and occurance of 1
				charMap.put(ch, occurance);
				
				// 	Print the nodes for debugging
				System.out.println(charMap);

				// Build nodes
				Node nd  = new Node(charMap.get(ch), charMap.get(occurance));
			//	System.out.print(nd);
				// Put these nodes into a queue
				
				
			}
			sc.close();
			
			return 0;

			
	 }

		
	

	public int getOccurance() {
		return occurance;
	}

	public void setOccurance(int occurance) {
		this.occurance = occurance;
	}
}
