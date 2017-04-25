package utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import models.Node;
import models.Tree;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import controllers.Main;

public class FileIO<T> implements Iterable<T>{
	// work in progress, code coming from part 2
	// private static File inputFile = new File("string.txt");
	public static HashMap<Character, Integer> tally = new HashMap<Character, Integer>();
	public static Queue<Node> pQueue = new PriorityQueue<>();
	static StringBuffer codedOutput = new StringBuffer();
	static String inputFile = "conor";

	// a variable integer to keep track of the letter tally
	private static int occurrence = 1;

	public static void charParser() throws IOException {


		Scanner sc = new Scanner(inputFile);

		while (sc.hasNextLine()) {

			/*
			 * scan the input for single characters findInLine() takes in a
			 * regex "." is a regular expression for next single character ideas
			 * taken from the internet, multiple stack overflow questions
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
				// set it to 1 because we found a new character
				occurrence = 1;
			}
			// Put this into a HashMap with value c and occurrence of 1
			tally.put(ch, occurrence);

		}

		sc.close();

		for (Map.Entry<Character, Integer> entry : tally.entrySet()) {
			char c = entry.getKey();
			int i = entry.getValue();

			Node n = new Node(c, i);
			// System.out.println(n.toString());
			pQueue.add(n);
			// System.out.println(pQueue.poll());

		}

		// leaves the root of the tree
		while (pQueue.size() > 1) {
			// poll removes the head of the queue, so that we can view it
			Node c1 = pQueue.poll();
			Node c2 = pQueue.poll();
			Node c3 = new Node(' ', c1.getOccurence() + c2.getOccurence());
			c3.setLeftPtr(c1);
			c3.setRightPtr(c2);
			pQueue.add(c3);
		}

		Node root = pQueue.poll();
		Tree<?> t = new Tree(root);
		// System.out.println("Root = " +root);
		t.traverse();
		
		for (int i = 0; i < inputFile.length(); i++) {
			char c = inputFile.charAt(i);
			codedOutput.append(t.mp.get(c));

		}
		System.out.println("Coded output = " + codedOutput);
		binaryOut(codedOutput.toString());

	}

	private static void binaryOut(String binaryOutS) throws IOException{

		try {
			FileOutputStream fos = new FileOutputStream(new File("test.dat"));
			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			byte[] magic = { (byte) 0x0c, (byte) 0xAD, (byte) 0xD0, (byte) 0x99 };
			bos.write(magic);

			for (Map.Entry<Character, String> entry : Tree.mp.entrySet()) {
				Character key = entry.getKey();
				String value = entry.getValue();
				System.out.println(key + value);

				byte[] bK = new byte[1];
				bK[0] = (byte) key.charValue();
				bos.write(bK);

				bK[0] = (byte) value.length();
				bos.write(bK);

				for (int i = 0; i < value.length(); i++) {
					int j = i + 8;
					String s;
					if (j >= value.length()) {
						s = value.substring(i, value.length());
						for (int k = 0; k < j - value.length(); k += 8) {
							s += "0";
						}
						
						}else{
							s = value.substring(i, i+8);
						
					}
				
				byte b = (byte) Integer.parseInt(s,2);
				bK[0] = b;
				bos.write(bK);
						
				
				}

			}
			
			bos.writeTo(fos);
			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

	public int getTallySize() {
		return tally.size();
	}

	public static void setOccurrence(int occurrence) {
		FileIO.occurrence = occurrence;
	}

	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
