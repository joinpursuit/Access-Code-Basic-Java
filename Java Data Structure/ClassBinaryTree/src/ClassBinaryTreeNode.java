
public class ClassBinaryTreeNode 
{
	//Object without modifier is available for other class in the same project.
	int object;
	ClassBinaryTreeNode left;
	ClassBinaryTreeNode right;

	public ClassBinaryTreeNode ()
	{
	}
	public ClassBinaryTreeNode(int o) 
	{
		this(o, null, null);
	}
	public ClassBinaryTreeNode (int i, ClassBinaryTreeNode l, ClassBinaryTreeNode r)
	{
		object = i;
		left = l;
		right = r;

	}
	

	//Count external leave
	//Count internal leave
	//Find min depth
	
	//Fix this
	public static int InternalLeaveCount (ClassBinaryTreeNode n)
	{
		if (n==null) 
			return 0;
		else if (n.left == null && n.right ==null)
		{
			return 1;
		}
		else
		{
			return 1+ InternalLeaveCount(n.left) + InternalLeaveCount(n.right);
		}
	}
	
	public static int ExternalLeaveCount (ClassBinaryTreeNode n)
	{
		if (n==null)
		{
			return 0;
		}
		else if (n.left ==null && n.right == null)
		{
			return 1;
		}
			return ExternalLeaveCount (n.left) + ExternalLeaveCount (n.right); 
	}
	
	public static int MinDepth (ClassBinaryTreeNode n)
	{
		if (n==null)
		{
			return -1;
		}
		else 
			return 1+ Math.min(MinDepth(n.left), MinDepth(n.right));
	}
	
	public static int ClassBinaryTreeNodeCount(ClassBinaryTreeNode n)
	{
		if (n==null)
		{
			return 0;
		}
		else return (1+  ClassBinaryTreeNodeCount(n.left) +  ClassBinaryTreeNodeCount(n.right));
	}
	
	public static int ClassBinaryTreeNodeDepth(ClassBinaryTreeNode n)
	{
		if (n==null)
			return -1;
		else 
			return (1+Math.max(ClassBinaryTreeNodeDepth(n.left), ClassBinaryTreeNodeDepth(n.right)));
	}
}
