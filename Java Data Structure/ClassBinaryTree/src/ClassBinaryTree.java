
public class ClassBinaryTree 
{
	ClassBinaryTreeNode root;

	public ClassBinaryTree ()
	{
		root = null;
	}

	public ClassBinaryTree(int e)
	{
		root = new ClassBinaryTreeNode (e);
	}

	public ClassBinaryTree(ClassBinaryTreeNode n)
	{
		root = n;
	}


	public boolean isEmpty ()
	{
		return root==null;
	}

	public void makeEmpty()
	{
		root = null;
	}

	public int getRootObject() throws Exception
	{
		if (isEmpty())
		{
			throw new Exception ("Tree is Empty");
		}
		else
			return root.object;
	}

	public ClassBinaryTree getLeftTree () throws Exception
	{
		if (isEmpty())
		{
			throw new Exception ("The tree is empty");
		}
		else 
			return new ClassBinaryTree (this.root.left);
	}

	public ClassBinaryTree getRightTree () throws Exception
	{
		if (isEmpty())
		{
			throw new Exception ("The tree is empty");
		}
		else 
			return new ClassBinaryTree (this.root.right);
	}

	public void setLeftTree (ClassBinaryTree l) throws Exception
	{
		if (this.root == null)
		{
			throw new Exception ("The root is empty");
		}
		else
			root.left = l.root;
	}

	public void setRightTree (ClassBinaryTree r) throws Exception
	{
		if (this.root == null)
		{
			throw new Exception ("The root is empty");
		}
		else
			root.right = r.root;
	}


	//Delete Object
	public static ClassBinaryTree delete (ClassBinaryTree t, int o) throws Exception 
	{
		//object is not found
		if (t.isEmpty())
		{
			return t;
		}
		//Finding the object
		else if (t.getRootObject()>o)
		{
			return delete (t.getLeftTree(), o);
		}
		else if (t.getRootObject()<o)
		{
			return delete (t.getRightTree(),o);
		}
		//Item found, three case, one child, no child or two children
		else if (t.getLeftTree().isEmpty())
		{
			return t.getRightTree();
		}
		else if (t.getRightTree().isEmpty())
		{
			return t.getLeftTree();
		}
		else // two children
		{
			int m = findMin (t.getRightTree());
			t.root = new ClassBinaryTreeNode(m);
			t.setRightTree(delete (t.getRightTree(), m));
			return t;
		}

		//object found
		//Remove node and replace by the right subtree's most left node

	}

	private static int findMin (ClassBinaryTree t) throws Exception 
	{
		if (!t.getLeftTree().isEmpty())
			return findMin(t.getLeftTree());
		return t.getRootObject();
	}

	//Insert function
	public static ClassBinaryTree insert(ClassBinaryTree t, int o) throws Exception
	{
		if (t.isEmpty ())
		{
			return new ClassBinaryTree(o);
		}
		else if (t.getRootObject()>o)
		{
			 t.setLeftTree(insert(t.getLeftTree(), o));
		}
		else if (t.getRootObject()<o)
		{
			t.setRightTree(insert(t.getRightTree(),o));
		}
		return t;
	}

	//Traversal 

	//Pre-order
	//They are the same just the calling order is different.
	public static void preOrder (ClassBinaryTree t) throws Exception
	{
		if (!t.isEmpty())
		{
			System.out.print(t.getRootObject()+" ");
			preOrder(t.getLeftTree());
			preOrder(t.getRightTree());
		}
		
	
	}
	//In-order
	public static void inOrder (ClassBinaryTree t) throws Exception
	{
		if (!t.isEmpty())
		{
		
			inOrder(t.getLeftTree());
			System.out.print(t.getRootObject()+" ");
			inOrder(t.getRightTree());
		}
		
	
	}

	//Post-order
	public static void postOrder (ClassBinaryTree t) throws Exception
	{
		if (!t.isEmpty())
		{
			postOrder(t.getLeftTree());
			postOrder(t.getRightTree());
			System.out.print(t.getRootObject()+" ");
		}
		
	
	}
}
