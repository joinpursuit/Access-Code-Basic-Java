// Are we allow to use the array implementation of BinaryTree?
public class TreeNode
{
	int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int d)
	{
		this(d,null,null);
	}
	
	public TreeNode (int d, TreeNode l, TreeNode r)
	{
		data = d;
		left = l;
		right = r;
	}

	public TreeNode (TreeNode t)
	{
		this.data = t.data;
		this.left = t.left;
		this.right = t.right;
	}
	
	public int getData ()
	{
		return this.data;
	}
	
	public static int NodeCount (TreeNode n)
	{
		if ( n == null)
		{
			return 0;
		}
		else return (1+ NodeCount(n.left) + NodeCount(n.right));
	}
	
	public static int NodeDepth (TreeNode n)
	{
		if (n == null )
		{
			return -1;
		}
		else 
			return 1 + Math.max(NodeDepth(n.left), NodeDepth(n.right));
	}
}
