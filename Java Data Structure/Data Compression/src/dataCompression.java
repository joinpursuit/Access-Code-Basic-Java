import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class dataCompression {

	public static void main(String[] args) 
	{
		int headerChecker = 0;
		FileReader rd = null;
		Scanner input = null;
		int [] header = new int [4];
		String fileName = "result.txt";
		String inputPath = "CompressionInput.txt";
		try
		{
			rd = new FileReader (inputPath);
			input = new Scanner (rd);
		}
		catch (IOException e)
		{
			System.err.print("Error when opening file");
		}

		while (input.hasNextInt() && headerChecker!=4)
		{
			header[headerChecker] = input.nextInt();
			headerChecker++;
		}
		if (headerChecker != 4)
		{
			System.out.println( "bad input\n");
			return ;
		}
		int [][]data = new int [header[0]][header[1]];
		int i,j;
		for (i = 0; i < header[0]; i++)
		{
			for (j = 0; j < header[1]; j++)
			{
				if (input.hasNextInt())
				{
					data[i][j] = input.nextInt();
					if (data[i][j] < header[2] || data[i][j] > header[3])
					{		//Invalid input return
						return;
					}
				}
			}
		}
		try 
		{
			rd.close();
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}

		printResult(header, fileName);
		int  current = data[0][0];
		int result[] = new int [] { 0, 0, current, 0 };

		for (i = 0; i < header[0]; i++)
		{
			for (j = 0; j < header[1]; j++)
			{
				if (current == data[i][j])
				{
					result[3]++;
				}
				else
				{
					printResult(result, fileName);
					current = data[i][j];
					result[0]= i;
					result[1] = j;
					result[2] = current;
					result[3] = 1;
				}
			}
		}
		printResult(result, fileName);
		input.close();
		return ;		
	}

	private static void printResult(int[] result, String fileName) 
	{
		try 
		{
			PrintWriter pw = new PrintWriter (new FileOutputStream (new File (fileName), true));
			for (int i = 0 ; i < 4 ; i ++)
			{
				pw.write(result[i]+" ");
			}
			pw.write("\r\n");
			pw.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("File is not found");
		}

	}

}
