/**
 * 
 */
package controllers;


import models.Node;
import models.Tree;

import java.io.IOException;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;
import utils.FileIO;

/**
 * @author Conor
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
		files.charParser();
		Main mn = new Main();
		Shell ui = ShellFactory.createConsoleShell("HFCode>", "\nHuffman encoder: type ?list to show commands", mn);
		ui.commandLoop();
		
	}

	
	@Command(description="Encode a new file")
	public void chooseNewFile()
	{
		if(isDEBUG()){
			//System.out.println (Node.toString());
		}
		System.out.print("File hardcoded into code");
		
		// Use FileChooser to select file
		}
	
	
	
	
	
	@Command(description="Encode a file")
	public void encode ()
	{
		System.out.println("Starting encode");
		}
	
	

	
	@Command(description="View the occurences for each character")
	public void viewTally ()
	{
		System.out.println("getTally - see FlieIO method");
		}
	
	@Command(description="View the priorty queue")
	public void viewPQueue ()
	{
		System.out.println("pQueue = ");
		}
	
	

	
	
}
