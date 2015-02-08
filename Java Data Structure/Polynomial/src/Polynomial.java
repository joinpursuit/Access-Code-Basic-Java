// Singwai Chan
//this is a linked list for node with Integer.
//By having address in both the first and last node can quickly access to the data.

//Deep copy vs Shallow copy issue.
public class Polynomial
{
	private Node first ;	// the lowest degree
	private Node last ; // the greatest degree
	private int size = 0;

	public Polynomial ()
	{
		first = null;
		last = null;
	}

	public Polynomial (Polynomial p) throws Exception
	{
		for (int i = 0 ; i < p.size ; i ++)
		{
			this.pushBack(p.first.getInt());
			p.pushBack(p.popFront());
		}
	}

	public void pushBack(int n)
	{
		Node temp = new Node (n);
		if ( size == 0)
		{
			first= temp;
			last = temp;
		}
		else 
		{
			last.setNextNode(temp);
			last= temp;
		}
		size++;
	}

	public int popFront() throws Exception
	{
		if (size == 0 )
		{
			throw new Exception ("Polynomial is empty");
		}
		int temp = first.getInt();
		first = first.getNextNode();
		size--;
		return temp;
	}

	public boolean isEmpty()
	{
		if (size == 0)
		{
			return true;
		}
		return false;
	}
	public void makeEmpty()
	{
		first = null;
		last = null;
		size = 0;
	}

	public int getSize ()
	{
		return size;
	}

	public static Polynomial sum (Polynomial lhs, Polynomial rhs) throws Exception
	{
		Polynomial lhsCopy = new Polynomial (lhs);
		Polynomial rhsCopy = new Polynomial (rhs);

		//Is there a way to do it without using temp?
		Polynomial temp = new Polynomial ();
		int minSize =  Math.min(lhsCopy.size, rhsCopy.size); 

		for ( int i = 1 ; i <= minSize; i ++)
		{
			temp.pushBack(lhsCopy.popFront()+rhsCopy.popFront());
		}

		if (lhsCopy.isEmpty())
		{
			temp.append(rhsCopy);
		}
		else if (rhsCopy.isEmpty())
			temp.append(lhsCopy);

		temp = checkPolynomial(temp);
		return temp;
	}
	//Non static
	//need to offset the node degree.
	public static Polynomial product(Polynomial lhs, Polynomial rhs) throws Exception
	{
		Polynomial result = new Polynomial ();
		Polynomial rhsCopy = new Polynomial (rhs);
		int counter = 0;

		while (!rhsCopy.isEmpty())
		{
			Polynomial copyLhs = new Polynomial(lhs);
			Polynomial set = new Polynomial ();
			for ( int l = 0 ; l < counter ; l ++)
			{
				set.pushBack(0);
			}
			while (!copyLhs.isEmpty())
			{
				set.pushBack(copyLhs.popFront()*rhsCopy.first.getInt());
			}
			rhsCopy.popFront();
			counter ++;
			result = Polynomial.sum(result, set);
		}
		result= checkPolynomial(result);
		return result;
	}


	//This is to check polynomial to make sure there are no trailing zero.
	private static Polynomial checkPolynomial(Polynomial rhs) throws Exception
	{
		//If the answer is 0, we want at least one zero.
		//This is equal to 2 because we want to at least return one zero for a polynomial that is not null.
		int pendingZero = 1;
		Polynomial temp = new Polynomial ();
		while (!rhs.isEmpty())
		{
			if (rhs.first.getInt()!=0)
			{
				while (pendingZero>1)
				{
					temp.pushBack(0);
					pendingZero--;
				}
				temp.pushBack(rhs.popFront());
			}

			else if (rhs.first.getInt()==0)
			{
				pendingZero++;
				rhs.popFront();
			}
		}
		if (temp.isEmpty())
			temp.pushBack(0);
		return temp;
	}



	//Does this append will deep copy the node??
	//Can we append something null?
	//Maybe an append that takes Node object.
	public Polynomial append (Polynomial rhs) throws Exception
	{
		//Make rhs as a loop instead of using temp.
		//monitor with size.
		int rhsSize = rhs.size;
		for (int i = 0 ; i < rhsSize ; i ++)
		{
			this.pushBack(rhs.first.getInt());
			rhs.pushBack(rhs.popFront());
		}
		return this;
	}

	public String toString ()
	{

		int size = this.size;
		String ans = new String ();
		for ( int i = 0 ; i <size ; i ++)
		{
			ans = String.format( "%s %4d", ans ,this.first.getInt());
			try 
			{
				this.pushBack(this.popFront());
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return ans;
	}
}
