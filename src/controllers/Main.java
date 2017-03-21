/**
 * 
 */
package controllers;


import models.Node;
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
		Shell ui = ShellFactory.createConsoleShell("dict>", "Spanish to English dictionary - type ?list to show commands", mn);
		ui.commandLoop();
		
	}

	
	@Command(description="Add a new entry")
	public void chooseFile ()
	{
		if(isDEBUG()){
			System.out.println("debug");
		}
		System.out.print("File hardcoded into code");
		
		// Use FileChooser to select file
		}
	
	
	
	@Command(description="Encode a file")
	public void encode ()
	{
		System.out.println("Starting encode");
		}
	
	@Command(description="Decode")
	public void decode ()
	{
		System.out.println("See Huffman part 2");
		}


	
	
}
