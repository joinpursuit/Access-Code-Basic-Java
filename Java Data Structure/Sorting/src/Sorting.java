/*
 * Dumb sort
 * Insertion
 * Selection
 * 
 * Bottom up... should study with heap trees
 * Heap
 * 
 * Divide and conqueue
 * Merge
 * Quick
 * 
 * Goal is to pass in an array to each static sorting function and out put each step of the sorting.
 */
public class Sorting {

	public static int [] insertion (int t[])
	{
		//Anything before i is sorted.
		for ( int i = 1; i < t.length; i ++)
		{
			int index = newLocation(t, i)
			
		}
		
	}
	
	public static int newLocation (int [] t, int i)
	{
		int result = i;
		while (t[i]>t)
	}

	public static void selection (int t[])
	{
		print(t);
		for (int i = 0 ; i < t.length ; i++)
		{
			int maxIndex = i;
			for ( int j = i ; j < t.length ; j ++)
			{
				if (t[maxIndex]<t[j])
				{
					maxIndex = j;
				}
			}
			int temp = t[i];
			t[i] = t[maxIndex];
			t[maxIndex] = temp;
			print(t);
		}
	}

	public static int [] merge(int n[])
	{
		if ( n.length >1)
		{
			//divide it in to two part
			int l1[] = new int [(int) Math.ceil(n.length/2)];
			int l2[] = new int [(int) (Math.ceil(n.length)-n.length/2)];
			//copy the elements
			for ( int i = 0 ; i < n.length ; i ++)
			{
				if (i<Math.ceil(n.length/2))
				{
					l1[i] = n[i];
				}
				else
				{
					l2[(int) (i-Math.ceil(n.length/2))]= n[i];
				}
			}
			//Recursion
			merge(l1);
			merge(l2);
			//combine two list
			return combine (l1, l2);
		}
		//only 1 element, return it.
		return (n);


	}

	//I think is better to use queue 
	public static int [] combine (int l1[] ,int l2[])
	{
		int [] temp = new int [l1.length + l2.length];
		int lhs = 0 , rhs = 0 , tempIndex = 0;

		while (l1.length>lhs && l2.length>rhs)
		{
			if (l1[lhs]>l2[rhs])
			{
				temp[tempIndex++] = l2[rhs++];

			}
			else // (l2[rhs]>l1[lhs])
			{
				temp[tempIndex++] = l1[lhs++];
			}
		}
		while (l2.length > rhs)
		{
			temp[tempIndex++] = l2 [rhs++];
		}

		while (l1.length > lhs)
		{
			temp[tempIndex++] = l1[lhs++];
		}

		return temp;
	}


	public static void print (int t[])
	{
		for ( int i = 0 ; i < t.length ; i ++)
		{
			System.out.print(t[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) 
	{
		int [] num = {6,2,3,8,4};
		num = merge (num);

		print(num);

	}

}
