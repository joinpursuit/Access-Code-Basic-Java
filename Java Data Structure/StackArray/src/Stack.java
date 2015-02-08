//this is a stack of character.
//This is an exercise to see how much I know about stack and array implementation.

//Should I use a counter to avoid over flow?
//Use counter to keep track of what is on the "top";

//In primitive type, is there such thing as deep copy and shallow copy

//problem with pointer and object....
public class Stack 
{
	//Should I put final in size? Since we will not re-declare it again
	private int size;
	private int topIndex;
	//topIndex should be the index for the LAST character.
	//-1 mean that the stack is empty
	private char myStack[];
	private final static int MAXCAPACITY = 1000;
	
	public Stack()
	{
		this(MAXCAPACITY);
	}
	
	public Stack(int s)
	{
		if (s<1)
		{
			//Throw something here, b/c size is too small or we can use MAXCAPACITY instead.
			size = MAXCAPACITY;
		}
		else
			size = s;
		topIndex = -1;
		myStack = new char [size];
	}
	

	public Stack (Stack rhs)
	{
		this.size = rhs.size;
		topIndex = rhs.topIndex;
		myStack = rhs.myStack;
	}
		
	public boolean empty()
	{
		if (topIndex == -1)
		{
			return true;
		}
		return false;
	}
	
	public void makeEmpty()
	{
		while (topIndex !=-1)
		{
			myStack[topIndex] = '\0';
			topIndex--;
		}
	}
	
	//Remember to deal with speacal cases.
	public void pushFront(char a)
	{
		if (topIndex==(size-1))
		{
			//Stack is full, throw something here.
		}
		
		myStack[++topIndex] = a;	
		//add first then increase topindex
	}
	
	//Push a String	
	//Pop a String
	
	public char popFront()
	{
		if (size == -1)
		{
			//Stack is empty, throw something here.
		}
		return myStack[topIndex--];
		//return topIndex first then decreasement. 
		//the following line will kill the stack, but why?
		//myStack[topIndex] ='\0';
		
	}
	
}
