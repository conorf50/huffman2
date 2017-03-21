package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import controllers.Main;
import models.Node;

public class FileIO {
	private static File inputFile  = new File("string.txt");
	private static File XMLFile  = new File("stringXML.xml");
	HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
	private int occurance = 1;

	@SuppressWarnings("unchecked")
	public void readXML() throws Exception
	{
		ObjectInputStream is = null;
		try
		{
			XStream xstream = new XStream(new DomDriver());
			is = xstream.createObjectInputStream(new FileReader(XMLFile));
			//parts = (ArrayList<T>) is.readObject();
		}
		finally
		{
			if (is != null)
			{
				is.close();
			}
		}
	}

	public void writeToXML() throws Exception
	{
		ObjectOutputStream os = null;
		try
		{
			XStream xstream = new XStream(new DomDriver());
			os = xstream.createObjectOutputStream(new FileWriter(XMLFile));
			os.writeObject(xstream);
		}
		finally
		{
			if (os != null)
			{
				os.close();
			}
		}
	}

	public void charParser()
	{
		try {
			Scanner sc = new Scanner(inputFile);

			while(sc.hasNextLine()){
				Character ch = sc.findInLine(".").charAt(0);
				
				if(Main.isDEBUG()){
					System.out.println(ch);

				}
				// Put this into a HashMap with value c and occurance of 1

				charMap.put(ch, occurance);
				// Check the occurance of a character
				if(charMap.containsKey(ch)){
					
					occurance++;
				}


			}
			sc.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		
	}

	

	public int getOccurance() {
		return occurance;
	}

	public void setOccurance(int occurance) {
		this.occurance = occurance;
	}
}
