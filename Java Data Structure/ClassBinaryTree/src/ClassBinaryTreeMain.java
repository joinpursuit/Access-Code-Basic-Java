// Read lists of numbers from a specified text file 

import java.io.*;


public class ClassBinaryTreeMain {
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
					ClassBinaryTree myTree = new ClassBinaryTree ();
					for (int i=0; i<numbers.length; i++) 
						myTree=ClassBinaryTree.insert(myTree, Integer.parseInt(numbers[i]));
						//ClassBinaryTree.draw(myTree);
						//This is a break line.
						ClassBinaryTree.inOrder(myTree);
						System.out.println();
						ClassBinaryTree.preOrder(myTree);
						System.out.println();
						ClassBinaryTree.postOrder(myTree);
						System.out.println();
						System.out.println(ClassBinaryTreeNode.ExternalLeaveCount(myTree.root));
						System.out.println(ClassBinaryTreeNode.InternalLeaveCount(myTree.root));
						System.out.println(ClassBinaryTreeNode.ExternalLeaveCount(myTree.root));
						System.out.println(ClassBinaryTreeNode.MinDepth(myTree.root));
					System.out.println("\n---------------------------------------------------------------------------------------------------\n");
				}                                                                    
			}
			catch (Exception e) { System.out.println(e); }
		}
	}
}
