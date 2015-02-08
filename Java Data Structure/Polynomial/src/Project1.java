/*	Singwai Chan
 * 
 * 	This will be the main program where  the data will read and compute.
 * 
 * 		Each polynomial will have an linked list of int, which represent a list of coefficients of the polynomial. 
 * 		The index will be the same as the degree of the polynomial
 * 		It will have a sum and product function which will return a polynomial object.
 * 		
 * 		The toString function will leave 4 space for each number. so they will line up nicely.
 * 
 * 		The logic of the sum function is to create a new Polynomial and pushBack the sum of the two polynomial.
 * 		Since, the two polynomial can have different degree.
 * 		Therefore when we reach the end of the shorter polynomial, we can just append everything from the longer polynomial to the new polynomial
 *
 *		The logic of the product function follow the idea of foil method.
 *		It will be an double while loop one keep track of the first polynomial and second keep track of the second polynomial.
 * 		Each node of the second polynomial will multiply with all the node in the first polynomial.
 * 		Each node will create a polynomial and the result will be the sum of all polynomials. 
 * 		The number of polynomial will depend on the degreeof the second polynomial.		
 * 		In addition, we need to offset the set polynomial as we running the loop, b/c the degree of the second polynomial is raising by 1 in each loop.
 * 		We can do this by creating a counter to remember the offset and pushback 0 depend on the number of the offset.
 */
//

import java.io.*;

public class Project1 {
	public static void main (String [] args) 
	{

		if (args.length == 0) System.out.println("No file specified."); 
		else 
		{
			FileReader theFile;
			BufferedReader inFile; 
			String oneLine;

			// FileNotFoundException must be caught
			try 
			{                       
				theFile = new FileReader(args[0]);
				inFile = new BufferedReader(theFile);

				while ((oneLine = inFile.readLine()) != null) //read first set
				{
					String numbers1[] = oneLine.split(" "); 
					String numbers2[] = null;
					if ((oneLine = inFile.readLine()) != null) // read second set and process the calculation
					{
						numbers2 = oneLine.split(" "); 
						oneLine = inFile.readLine();

						Polynomial one = new Polynomial();
						Polynomial two = new Polynomial ();
						for (int i=0; i<numbers1.length; i++) 
						{
							one.pushBack(Integer.parseInt(numbers1[i]));//put it in to Polynomial
						}

						for (int i=0; i<numbers2.length; i++) 
						{
							two.pushBack(Integer.parseInt(numbers2[i]));//put it in to Polynomial
						}
						System.out.println(one.toString());
						System.out.println(two.toString());
						System.out.println(Polynomial.sum(one,two).toString());
						System.out.println(Polynomial.product(one,two).toString()+"\n");
					}

				}                                                                    
			}


			catch (Exception e) { System.out.println(e); }
		}
	}
}