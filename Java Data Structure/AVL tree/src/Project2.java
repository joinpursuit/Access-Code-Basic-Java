// Read lists of numbers from a specified text file 
//Edit it so it can theoretically draw binary tree with any depth. 
//Create deletion function.
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
						myTree.insert(Integer.parseInt(numbers[i]));	
						BinaryTree.deleteion(6, myTree);
						BinaryTree.deleteion(5, myTree);
						
						BinaryTree.draw(myTree);
						System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
						
						System.out.println("In order");
						BinaryTree.inTravel(myTree);
						System.out.println("Pre-order");
						BinaryTree.preTravel(myTree);
						System.out.println("Post-order");
						BinaryTree.postTravel(myTree);

						
				}                                                                    
			}
			catch (Exception e) { System.out.println(e); }
		}
	}
}
