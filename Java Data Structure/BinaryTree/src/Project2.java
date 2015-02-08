// Read lists of numbers from a specified text file 

import java.io.*;


public class Project2 {
	public static void main (String [] args) {

		if (args.length == 0) System.out.println("No file specified."); 
		else {
			FileReader theFile;
			BufferedReader inFile; 
			String oneLine;
			try {                       // FileNotFoundException must be caught
				theFile = new FileReader(args[0]);
				inFile = new BufferedReader(theFile);
				while ((oneLine = inFile.readLine()) != null) 
				{
					String numbers[] = oneLine.split(" ");        // or "," for comma
					BinaryTree myTree = new BinaryTree ();
					for (int i=0; i<numbers.length; i++) 
						myTree.add(Integer.parseInt(numbers[i]));
						BinaryTree.draw(myTree);
						//This is a break line.
						System.out.println("\n---------------------------------------------------------------------------------------------------\n");
				}                                                                    
			}
			catch (Exception e) { System.out.println(e); }
		}
	}
}
