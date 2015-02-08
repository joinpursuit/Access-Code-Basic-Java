import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class Project12 {

    /** Haiqiang Zou
     * 	CS212
     * @param args
     */
    public static void main(String[] args) {
 	    String [][]board=new String[5][5];
 	    String [][]board2=new String[5][5];
    	int player1[][]=new int[5][5];
        int player2[][]=new int[5][5];     
        
        //reads in the informations from both files
        readFile("player1Spring2012.txt", board, player1);
        readFile("player2Spring2012.txt", board2, player2);      
        
        //when all the ships has not been sunk for either player the while loop executes
        while(!allSunk(player1)&&!allSunk(player2))
        {
        	
        	//calls upon the print method to play the battleship game by taking turns entering the coordinates.
        	if(allSunk(player1)||allSunk(player2))
        		break;
        	JOptionPane.showMessageDialog(null, "Player 1's Turn");
        	print("Player 1",board2 , player2, player1);
        	System.out.println();
           	if(allSunk(player1)||allSunk(player2))
        		break;
        	JOptionPane.showMessageDialog(null, "Player 2's Turn");
        	print("Player 2",board ,player1, player2);
        	System.out.println();
        }
        
        //when all the ships from either player has been sunk, it displays a message that the opposing player wins.
        if(allSunk(player1))
        	JOptionPane.showMessageDialog(null,"Winner is Player 2");
        if(allSunk(player2))
        	JOptionPane.showMessageDialog(null, "Winner is Player 1");
    }
  
    /**
     * This method reads in the coordinates from the file and tokenizes them. it uses the first token as row and the second token as column part of the coordinates.
     * It also prints out the size of the battleship by counting how many amount of tokens are in the line. 
     * at last it initializes everything in the board array as "+".
     * @param filename
     * @param board
     * @param player
     */
   private static void readFile(String filename, String [][]board, int[][]player)
    {  
        TextFileInput tfi = new TextFileInput(filename);
        String line=tfi.readLine();
        StringTokenizer st;
        int row, col;
        
        //reads in every line in the file
        while(line!=null)
        {
           
        	//Tokenizes every line after it reads in
            st= new StringTokenizer(line, ",|");
            int count=st.countTokens()/2;
            while(st.hasMoreTokens())
            {
            	//sets the first token as the row value and second token as the column value.
                row=Integer.parseInt(st.nextToken());
                col=Integer.parseInt(st.nextToken());
                player[row][col]=count;
            }
            line=tfi.readLine();
        }
        
        //setting up all the values of a board array to "+"
        for(int r = 0; r < board.length; r++)
 	   {
 		   for(int c = 0 ; c < board[r].length; c++)
 		   {
 			   board[r][c]="+";
 		   }
 	   }
    }    
  
   /**
    * 
    * Check if the ships for player 1 and player 2 has all been sunk
    * @param player
    * @returns true value if all the ships for player 1 or 2 has been sunk or else return false;
    */
   
   private static boolean allSunk(int [][] player)
   {
	   
	   //going through the entire player array. if all the values are all 0 then the ships are not all sunk.
	   for(int r = 0; r < player.length; r++)
	   {
		   for(int c = 0; c < player[r].length; c++)
		   {
			   if(player[r][c]>0)
				   return false;
		   }
	   }
	   return true;
   }
   
   /**
    * This methods prints out the board of each player, asks the user to input coordinates and tokenize them to make the coordinates for row and column.
    * It also checks whether the player's coordinate hit the battleship of the opposing player. If the player hits then he/she gets to go again without passing his/her turn.
    * @param name
    * @param board
    * @param player
    * @param ownBoard
    * @param player2
    * @return
    */
   public static void print(String name, String[][] board, int[][] player , int[][] player2) 
   {
	   String input; int row, col;
	   StringTokenizer st;
	   System.out.println( name + " Attempts");
	   checkSunk(player);
	  
	   // prints out the attempt hits by the players 
	   for(int r = 0; r < board.length; r++)
 	   {
 		   for(int c = 0 ; c < board[r].length; c++)
 		   {
 			   System.out.print(board[r][c] + " ");
 		   }
 		   System.out.println();
 	   }
	   System.out.println();
	   
	   //asks the user to input a coordinates
	   input = JOptionPane.showInputDialog(name + " enter the cordinates in this format: 0,0");
	   st= new StringTokenizer(input, ",");
	   while(st.hasMoreTokens())
		   {
			   if(st.countTokens()==1)
			   {
				   if(Integer.parseInt(st.nextToken())==-1)
					   System.exit(0);
			   }
			   row=Integer.parseInt(st.nextToken());
			   col=Integer.parseInt(st.nextToken());
			   while(row<0||col<0||row>4||col>4)
			   {
				   JOptionPane.showMessageDialog(null, "Invalid coordinates, Please enter the coordinates again");
				   input = JOptionPane.showInputDialog(name + " enter the coordinates in this format: 0,0");
				   st= new StringTokenizer(input, ",");
				   row=Integer.parseInt(st.nextToken());
				   col=Integer.parseInt(st.nextToken());
			   }
		   		
			   //if the user's coordinate miss the ship it will change the value on the player's array to -2 and the board array to X 
			   if(player[row][col]==0)
		   		{
		   			player[row][col]=-2;
		   			board[row][col]="X";
		   			JOptionPane.showMessageDialog(null, "You have missed");
		   			break;
		   		}
		   		
		   		if(board[row][col]=="X")
		   		{
		   			player[row][col]=-2;
		   			board[row][col]="X";
		   			JOptionPane.showMessageDialog(null, "You have missed");
		   			break;
		   		}
		   		
		   		//if the user's coordinate hit the ship it will change the value on the player's array to -1 and the board array to H. 
		   		//It will continuously to ask the user to input coordinates until the player misses the ship.
		   		if(board[row][col]=="H")
				  {
				   player[row][col]=-1;
				   board[row][col]="H";
				   JOptionPane.showMessageDialog(null, "You have missed");
				   break;	
				
				  }
		   		if(player[row][col]>0)
				  {
				   player[row][col]=-1;
				   board[row][col]="H";
				   JOptionPane.showMessageDialog(null, "YOU HIT HIM! GO AGAIN!!");
				   if(allSunk(player))
					   break;
				   //if player hits the opponent ships. it refreshes their board display
				   System.out.println( name + " Attempts");
				   checkSunk(player);
				   for(int r = 0; r < board.length; r++)
			 	   {
			 		   for(int c = 0 ; c < board[r].length; c++)
			 		   {
			 			   System.out.print(board[r][c] + " ");
			 		   }
			 		   System.out.println();
			 	   }
				   System.out.println();
				   input = JOptionPane.showInputDialog(name + " enter the coordinates in this format: 0,0");
				
				  }
			   
		   	 st= new StringTokenizer(input, ",");
		   }
	}
   
   /**
    * checks to see if the ships on each of the player's board has been sunk.
    * @param player
    * @return
    */
   private static void checkSunk(int[][] player)
   {
	   int count2=0, count3=0, count4=0;
	   
	   //a for loop to run thru the entire array to check for their values
	   for(int r = 0; r < player.length; r++)
	   {
		   for(int c = 0; c < player[r].length; c++)
		   {
			   //if there is value of 2 in anywhere of the array that means that the size 2 ship has not been sunk
			   if(player[r][c]==2)
				   count2++;
			   
			   //if there is value of 3 in anywhere of the array that means that the size 3 ship has not been sunk
			   if(player[r][c]==3)
				   count3++;
			   
			   //if there is value of 4 in anywhere of the array that means that the size 4 ship has not been sunk
			   if(player[r][c]==4)
				   count4++;
		   }
	   }
	   
	   //prints out the statement if any of the ships has been sunk.
	   if(count2==0)
		   System.out.println("Ship 2 has been sunk");
	   if(count3==0)
		   System.out.println("Ship 3 has been sunk");
	   if(count4==0)
		   System.out.println("Ship 4 has been sunk");
   }
}
  