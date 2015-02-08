//This queue can only doubleSize manually.


class QueueArray 
{
	private static final int CAPACITY = 1000;
	private Integer [] data  ;
	private int size;
	private int tail;
	private int head;
	private int counter = 0;
	//tail and head should be at the location where we can read and write on it directly.
	
	public QueueArray()
	{
		this (CAPACITY);
	}

	public QueueArray(int s) 
	{
		size = s;
		data = new Integer [s];
		head = 1;
		tail = 0;
	}
	
	public void enqueue (Integer s)
	{
		if ( counter == size)
		{
			//throw something here, array is full.
		}
		tail = (++tail)%size;
		data[tail%size] = s;
		counter++;
	}
	
	public Integer dequeue ()
	{
		if (counter == 0 )
		{
			//Queue is empty
			//Throw something here
			System.out.println("Something is thrown");
			return -1;
		}
		 
		head = (++head)%size;
		counter --;	
		return data[head];
		// test here see what happen if you just return temp.
	}
	
	public void print()
	{
		for ( int i = 0 ; i < size ; i ++)
		{
			System.out.print(data[i] +" ");
		}
			System.out.println("\ntail is " + tail + "\nHead is " + head + "\nCounter is "+ counter);
		for ( int i = 0 ; i < counter ; i ++ )
		{
			System.out.print(data[((head+i)%size)] +" ");
		}
	}
	
	public boolean isEmpty()
	{
		if (counter == 0 ) return true;
		return false;
	}
	
	public void makeEmpty()
	{
		counter = 0;
		head = 1;
		tail = 0;
	}
}
