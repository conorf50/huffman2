package models;


/*
 * A Node has a ch and occurrence

 */
public class Node implements Comparable <Node>{
	private Integer occurrence;
	private char ch;
	private Node leftPtr;
	private Node rightPtr;
	/**
	 * @param occurrence
	 * @param ch
	 */
	public Node(Character ch, Integer occurrence) {
		super();
		this.occurrence = occurrence;
		this.ch = ch;
		this.leftPtr = null;
		this.rightPtr = null;
	}
	
	public Character getCharacter() {
		return ch;
	}

	@Override
	// auto generated through Eclipse
	public String toString() {
		return "Node [occurrence=" + occurrence + ", ch=" + ch + ", leftPtr=" + leftPtr + ", rightPtr=" + rightPtr
				+ "]";
	}

	public Integer getOccurence() {
		return occurrence;
	}
	public int compareTo(Node n){
		return this.getOccurence().compareTo(n.getOccurence());
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
