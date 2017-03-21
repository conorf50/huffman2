package models;


/*
 * Node: Each part of the Tree has Nodes and children. A child can be a node and a Node can be a child. 
 * A Node has at most 2 children, left and right. It can also have one left child or none at all.
 * When adding children, the left one takes precedence
 * The modes are part of a Binary Search Tree
 */
public class Node implements Comparable <Node>{
	private Integer index;
	private Character letter;
	private Node leftPtr;
	private Node rightPtr;
	/**
	 * @param index
	 * @param letter
	 */
	public Node(Character letter, Integer index) {
		super();
		this.index = index;
		this.letter = letter;
		this.leftPtr = null;
		this.rightPtr = null;
	}
	
	public Character getLetter() {
		return letter;
	}

	public Integer getIndex() {
		return index;
	}
	public int compareTo(Node n){
		return this.getLetter().compareTo(n.getLetter());
	}

	public Node getLeftPtr() {
		return leftPtr;
	}

	public Node getRightPtr() {
		return rightPtr;
	}
	
	public void setLeftPtr(Node n) {
		this.leftPtr =  n;
	}
	public void setRightPtr(Node n) {
		this.rightPtr =  n;
	}





		
}
