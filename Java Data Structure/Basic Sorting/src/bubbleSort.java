import java.io.*;
import java.util.Scanner;

public class bubbleSort 
{
	public static void printResult (int [] dataSorted, int dataCount, String fileName)
	{
		try 
		{
			PrintWriter pw = new PrintWriter (new FileOutputStream (new File (fileName), true));
			for (int i = 0 ; i < dataCount ; i ++)
			{
				pw.write(dataSorted[i]+" ");
			}
			pw.write("\r\n");
			pw.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("File is not found");
		}
	}

	public static void main(String[] args) throws IOException
	{
		int startIndex, endIndex, walkerIndex, dataCount = 0;
		int [] dataSorted;
		Scanner input = null;
		FileReader rd = null;

		try
		{
			rd = new FileReader ("data.txt");
			input = new Scanner (rd);
		}
		catch (IOException e)
		{
			System.err.print("Error when opening file");
		}

		while (input.hasNextInt())
		{
			dataCount++;
			input.nextInt();
		}
		input.close();
		rd.close();
		dataSorted = new int[dataCount];
		try
		{
			rd = new FileReader ("data.txt");
			input = new Scanner (rd);
		}
		catch (IOException e)
		{
			System.err.print("Error when opening file");
		}

		for (int i = 0 ; i < dataCount; i++)
		{
			dataSorted[i] = input.nextInt();
		}

		startIndex = 0;
		endIndex = dataCount-1;

		while (!(endIndex<=startIndex))
		{
			walkerIndex = startIndex;

			while (!(walkerIndex>=endIndex))
			{
				if (dataSorted[walkerIndex]>dataSorted[walkerIndex+1])
				{
					int temp = dataSorted[walkerIndex];
					dataSorted[walkerIndex] = dataSorted[walkerIndex+1];
					dataSorted[walkerIndex+1] = temp;
				}
				
				walkerIndex++;
			}
			printResult(dataSorted, dataCount, "bubbleSort.txt");
			endIndex--;
		}
		printResult(dataSorted, dataCount, "bubbleSort.txt");	
	}

}
