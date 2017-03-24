package utils;

import java.io.File;
import models.Node;
import java.io.FileNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import controllers.Main;

public class FileIO {
	private static File inputFile = new File("string.txt");
	HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
	private static int occurrence = 1;

	public static char charParser() throws FileNotFoundException {

		String inputFile = "AAaFBCCHDDD";
		HashMap<Character, Integer> tally = new HashMap<Character, Integer>();
		Queue<Node> pQueue = new PriorityQueue<>();
		// char ch = ' ';

		Scanner sc = new Scanner(inputFile);

		while (sc.hasNextLine()) {

			// scan the input for single characters
			char ch = sc.findInLine(".").charAt(0);
			if (tally.containsKey(ch)) {

				occurrence++;
				// System.out.println(occurrence);
			} else {
				occurrence = 1;
			}
			System.out.println(ch);
			// Put this into a HashMap with value c and occurrence of 1
			tally.put(ch, occurrence);
		
		}
		
		sc.close();
		 
		for(Map.Entry <Character, Integer> entry : tally.entrySet()){
			char c  = entry.getKey();
			int f = entry.getValue();
			
			Node n = new Node(c,f);
			//System.out.println(n.toString());
			
		}
		return 0;

	}

	public int getOccurance() {
		return occurrence;
	}

	public void setOccurance(int occurrence) {
		this.occurrence = occurrence;
	}
}
