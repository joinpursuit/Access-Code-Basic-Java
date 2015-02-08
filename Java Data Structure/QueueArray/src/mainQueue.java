
public class mainQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		QueueArray t1 = new QueueArray (10);
		
		for (int i = 0 ; i < 10 ; i ++)
		{
			t1.enqueue(i);
		}
		t1.print();
		
		//Integer temp = t1.dequeue();
		//temp = 1000;
		
		t1.print();
		
	}

}
