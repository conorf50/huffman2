/**
 * 
 */
package controllers;


import utils.FileIO;

/**
 * @author Conor
 *
 *
 *TO-DO
 *Remove Cliche along with its methods, replace with basic Swing GUI with FileChooser
 *Tidy up code, formatting etc...
 *Sort out project on Git
 *Add more comments!
 *
 *
 */
public class Main {
	
	// Crude Debug flag
	public static boolean DEBUG_FLAG = true;


	public static boolean isDEBUG() {
		return DEBUG_FLAG;
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	
	public static void main(String[] args) throws Exception {
		
		FileIO files = new FileIO();
		FileIO.charParser();
		Main mn = new Main();
		
	}

	
	
	
	
}
