package models;
import java.util.Queue;

import models.Node;
import utils.FileIO;

/*
 * This is the tree class
 * All code based on previous assignments
 */

public class Tree<T extends Comparable<T>> {
	private Node root;

	public Tree(Node root) {
		this.root = root;
	}

	// Node class set to null
	private Node node = null;
	


	//Check if the array is empty or not, returns true if it is
	public boolean isEmpty() {
		if(node == null){
			return true;
		}
		else{
			return false;
		}
	}
	// build a Huffman tree based on the priority queue
	public void buildTree(){
		
		
	}



	

}
