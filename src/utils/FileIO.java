package utils;

import java.io.File;
import models.Node;
import models.Tree;

import java.io.FileNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import controllers.Main;

public class FileIO {
	// work in progress, code coming from part 2
	//private static File inputFile = new File("string.txt");
	public static HashMap<Character, Integer> tally = new HashMap<Character, Integer>();
	public static Queue<Node> pQueue = new PriorityQueue<>();

	
	// a variable integer to keep track of the letter tally
	private static int occurrence = 1;

	public static void charParser() throws FileNotFoundException {

		String inputFile = "AAaFBCCHDDD";
		// char ch = ' ';

		Scanner sc = new Scanner(inputFile);

		while (sc.hasNextLine()) {

			/* scan the input for single characters
			 * findInLine() takes in a regex
			 * "." is a regular expression for next single character
			 * ideas taken from the internet,  multiple stack overflow
			 * questions
			 */
			char ch = sc.findInLine(".").charAt(0);
			/*
			 * containsKey is handy, comes from reading the documentation for
			 * HashMap
			 */
			if (tally.containsKey(ch)) {
				// increment occurance by 1
				occurrence++;
			} else {
				// set it to 1 just in case it changed for some reason
				occurrence = 1;
			}
			// Put this into a HashMap with value c and occurrence of 1
			tally.put(ch, occurrence);
			
		
		
		}
		
		sc.close();
		 
		for(Map.Entry <Character, Integer> entry : tally.entrySet()){
			char c  = entry.getKey();
			int i = entry.getValue();
			
			Node n = new Node(c,i);
			//System.out.println(n.toString());
			pQueue.add(n);
			//System.out.println(pQueue.poll());
			
			
		}
		
		// leaves the root of the tree
	while(pQueue.size() > 1){
		// poll removes the head of the queue, so that we can view it
		Node c1 = pQueue.poll();
		Node c2 = pQueue.poll();
		Node c3 = new Node(' ', c1.getOccurence()+c2.getOccurence());
		c3.setLeftPtr(c1);
		c3.setRightPtr(c2);
		pQueue.add(c3);
		}

	Node root=pQueue.poll();
	Tree t  = new Tree(root);
	System.out.println("Root = " +root);

	}

	public int getOccurance() {
		return occurrence;
	}

	public HashMap<Character, Integer> getTally() {
		return tally;
	}

	public void setCharMap(HashMap<Character, Integer> tally) {
		this.tally = tally;
	}

	public static int getOccurrence() {
		return occurrence;
	}
	

	public int getQSize() {
		 return tally.size();
	}
	
	public static void setOccurrence(int occurrence) {
		FileIO.occurrence = occurrence;
	}

	
}
