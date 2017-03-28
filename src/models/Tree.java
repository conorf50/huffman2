package models;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import models.Node;
import utils.FileIO;

/*
 * This is the tree class
 * All code based on previous assignments
 */

public class Tree<T extends Comparable<T>> {
	private Node root;
	public Map <Character, String> mp  = new HashMap <Character, String>();

	public Tree(Node root) {
		this.setRoot(root);
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
/*
	 * @return the root
	 */
	public Node getRoot() {
		return root;
	}
	/**
	 * @param root the root to set
	 */
	public void setRoot(Node root) {
		this.root = root;
	}

	
	public void traverse(){
		traverseR(root, " ");
	}

	private void traverseR(Node root, String prefix ){
		
			if (root.getLeftPtr() != null){
				traverseR(root.getLeftPtr(), prefix +"0");
			}
			

			if (root.getRightPtr() != null){
				traverseR(root.getRightPtr(), prefix +"1");
				
			}
			
			if ((root.getLeftPtr() == null) && (root.getRightPtr() == null)){
				mp.put(root.getCharacter(), prefix);
			}
	}
	

}
