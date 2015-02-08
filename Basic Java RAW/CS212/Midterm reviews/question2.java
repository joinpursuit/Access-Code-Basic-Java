
public class question2 {
	

	public static void main(String[] args) {
		int array[][] ={{10,45},{2,42,67,5},{3,21}};
		
		System.out.println(getSumOfRow(array,1)); // prints the sum of row 1
	}

	private static int getSumOfRow(int [][]array, int row)
	{
		int sum=0;
		for(int c = 0; c < array[row].length; c++)
		{
			sum+=array[row][c];
		}
		return sum;
	}
}

