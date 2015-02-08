import java.io.*;
//Author Singwai Chan
//0 = possible move 
//1 = NOT possible move or wall
//2 = 2 path
//The order of direction checking is Top, Bottom, Right and Left
public class Maze 
{
	//Global variable
	static boolean found = false;
	static int nr;
	static int nc;
	static int maze[][] = new int [10][10];
	static int temp [][];

	public static void findway(int sr, int sc, int dr, int dc)
	{	
		if (sr==dr && sc == dc) 
		{
			found = true;
		}
		else
		{	
			temp [sr][sc] = 1;
			while (!found && possibleToMove (sr,sc))
			{
				findway (nr,nc,dr,dc);
				if (!found)
				{
				System.out.println(" Backtracking from [" + nr + " , " + nc + "] to [" + sr + " , " + sc + "]" );
				}
			}

			//If the difference is greater than 1, show message Start Backtracking from the location.
			//It is backtracking from the new location
			if (!((sr == nr&& Math.max(sc, nc) - Math.min(sc, nc)==1 )
				||(sc == nc&& Math.max(sr, nr) - Math.min(sr, nr)==1 )) && !found)
			{
				System.out.println("\nStart backtracking [" + sr + " , " + sc +"]" );
			}
			//Record the current message and allow the recursion above it to call the message.
			nr = sr;
			nc = sc;
		}

		if (found) 
			maze[sr][sc] = 2;
	}

	public static boolean possibleToMove (int row, int col)
	{
		//Since nr nc is global, we can modify it before returning true here.
		//Check top
		if (row+1 < temp.length && temp [row+1][col] ==0)
		{
			nr=row +1;
			nc= col;
			return true;
		}
		//Check bottom
		else if (row-1 >= 0 && temp [row-1][col] ==0)
		{	
			nr=row -1;
			nc= col;
			return true;
		}
		//Check right
		else if (col+1 < temp[row].length && temp [row][col+1] ==0)
		{	
			nr=row;
			nc= col+1;
			return true;
		}

		//Check left
		else if (col-1 >= 0 && temp [row][col-1] ==0)
		{
			nr=row ;
			nc= col-1;
			return true;
		}
		else
		 {
			return false;
		}

	}

	//Copy maze to temp;
	public static void backUpMaze (int m [][])
	{
		temp = new int [10][10];
		for (int i = 0 ; i < m.length ; i ++)
		{	
			for (int j = 0 ; j < m[i].length ; j ++)
			{
				temp[i][j] = m[i][j];
			}
		}
	}

	//print a 2d array
	public static void print (int m[][])
	{
		System.out.println();
		for (int i = 0 ; i < m.length ; i ++)
		{
			for (int j = 0 ; j < m[i].length ; j ++)
			{
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	//The entire processing order
	public static void processMaze()
	{
		backUpMaze(maze);
		//We alway set location A as 0,0 and location B as 9,9.
		findway(0,0,9,9);
		if (!found)
		System.out.println("No path is found");
		else
		print(maze);

		//reset global variable
		found = false;
		maze = new int [10][10];
	}
	
	public static void main (String [] args) 
	{
		int j = 0;
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
					
					String numbers[] = oneLine.split(" ");  // or "," for comma
					for ( int i = 0 ; i < numbers.length ; i ++)
					{
						maze[j][i] = Integer.parseInt(numbers[i]);
					}
					//When j reach 10, the entire maze is copied and we can start processing the maze.
					if (++j == 10)
					{
						//process the maze.
						processMaze();
						//Reset j to capture new maze
						j=0;
						//Throws away the empty line
						inFile.readLine();
					}
				}                                                                    
			}
			catch (Exception e) { System.out.println(e); }
		}
	}
}



