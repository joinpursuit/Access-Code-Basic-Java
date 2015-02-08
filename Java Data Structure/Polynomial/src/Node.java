// Singwai Chan

public class Node
{
	public int object ;
	private Node nextNode ;
	
	public Node ()
	{
		this(0, null);
	}
	public Node (int object)
	{
		this.object= object;
	}	
	public Node (Node n)
	{
		this.object = n.object;
		this.nextNode = n.nextNode;
	}
	//Does this construction do anything?
	public Node (int o, Node nn)
	{
		object= o;
		nextNode = nn;
	}

	public void setNextNode(Node n)
	{
		nextNode = n;
	}
	
	public int getInt()
	{
		return object;
	}
	
	public Node getNextNode()
	{
		return nextNode;
	}
}