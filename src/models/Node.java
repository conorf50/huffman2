package models;


/*
 * Node: Each part of the Tree has Nodes and children. A child can be a node and a Node can be a child. 
 * A Node has at most 2 children, left and right. It can also have one left child or none at all.
 * When adding children, the left one takes precedence
 * The modes are part of a Binary Search Tree
 */
public class Node implements Comparable <Node>{
	private Integer freq;
	private Integer ch;
	private Node leftPtr;
	private Node rightPtr;
	/**
	 * @param freq
	 * @param integer
	 */
	public Node(Integer integer, Integer freq) {
		super();
		this.freq = freq;
		this.ch = integer;
		this.leftPtr = null;
		this.rightPtr = null;
	}
	
	public Integer getLetter() {
		return ch;
	}

	public Integer getFreq() {
		return freq;
	}
	public int compareTo(Node n){
		return this.getFreq().compareTo(n.getFreq());
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
