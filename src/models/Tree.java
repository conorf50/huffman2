package models;



import models.Node;

/*
 * This is the tree class
 * All code based on previous assignments
 */

public class Tree<T extends Comparable<T>> {
	public Tree() {
		// should be something in here?
		
	}

	// File for the XML handling
	// Node class set to null
	private Node node = null;
	// Field to keep track of the number of nodes
	private int nodeNum = 0;


	//Check if the array is empty or not, returns true if it is
	public boolean isEmpty() {
		if(node == null){
			return true;
		}
		else{
			return false;
		}
	}

	// Turns the array elements into Strings
	public String toString() {
		return "null";
	}

	/////////////////////////////////////////////////////////////////////////
	/*
	 * (non-Javadoc)
	 * @see controllers.MaxHeapInterface#add(java.lang.Comparable)
	 * 
	 * ADD METHOD
	 * Recursive method to add items to the tree of Nodes
	 */
	@SuppressWarnings("unchecked")
	public void add(Comparable item) {
		// check if the tree is empty, if it is we set the
		// input to be the root of the tree by casting it as a Node
		if(isEmpty()){
			node = (Node) item;
			nodeNum ++;
		}
		// if there is already items in the Tree, call the second 
		// addR method to handle it
		else{
			addR(item, node);
			nodeNum ++;
		}

	}

	@SuppressWarnings("unchecked")
	private void addR(Comparable item, Node current) {
		// check if what's coming in is less than 
		// the current Node

		// eg; item.lessThan(current)
		if(item.compareTo(current) > 0){
			if (current.getLeftPtr() == null )
				// cast the left item as a Node
				current.setLeftPtr((Node) item);
			else
				addR(item, current.getLeftPtr());
		}

		// else the item goes on the right child
		else{
			if (current.getRightPtr() == null)
				current.setRightPtr((Node) item);
			else
				addR(item, current.getRightPtr());
		}
	}
	// end of add methods


	/*
	 * (non-Javadoc)
	 * @see controllers.MaxHeapInterface#add(java.lang.Comparable)
	 * 
	 * SEARCH METHOD
	 * Recursive method to search the tree by comparing and input Node against
	 * an existing node in the tree
	 */
	@SuppressWarnings("unchecked")
	public String search(Comparable item) {
		// check if the tree is empty, if it is we set the
		// input to be the root of the tree by casting it as a Node
		if(!isEmpty()){
			node = (Node) item;
			nodeNum ++;
		}
		// if there is already items in the Tree, call the second 
		// addR method to handle it
		else{
			return null;
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	private void searchR(Comparable item, Node current) {
		// check if what's coming in is less than 
		// the current Node

		// eg; item.lessThan(current)
		if(item.compareTo(current) > 0){
			if (current.getLeftPtr() == null )
				current.setLeftPtr((Node) item);
			else
				addR(item, current.getLeftPtr());
		}

		// else the item goes on the right child
		else{
			if (current.getRightPtr() == null)
				current.setRightPtr((Node) item);
			else
				addR(item, current.getRightPtr());
		}
	}
	//end of add methods

	public void setNode(Node node) {
		this.node = node;
	}

	public Comparable<?> removeMax() {
		nodeNum --;
		return null;
	}


//	// Written by Joe
//	void printPreOrder(Node root, String indent)
//	{
//		if(root == null)
//			return;
//		System.out.println(""+indent+root.getLetter());
//		if(root.getLeftPtr() != null){
//			printPreOrder(root.getLeftPtr(),indent+"   ");
//		}
//		if(root.getRightPtr() != null){
//			printPreOrder(root.getRightPtr(),indent+"   ");
//		}
//	}



	public int getSize() {
		return nodeNum;
	}

	

	public void clearAll() {
		//parts.clear();
		nodeNum = 0;
	}

	public void deleteEntry(Comparable item) {
		//parts.remove(item);
		nodeNum --;
	}



	public Comparable getMax() {
		// TODO Auto-generated method stub
		return null;
	}

}
