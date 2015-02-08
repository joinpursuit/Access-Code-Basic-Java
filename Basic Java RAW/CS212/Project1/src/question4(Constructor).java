
public class Book {

private String title, author;
private float price;

	public Book(String args1, String args2, String args3)
	{
		title=args1;
		author=args2;
		price=Float.parseFloat(args3);
		if(args1.equals(null)||args2.equals(null)||Float.parseFloat(args3) < 0)
			throw new IllegalArgumentException("The argument is not correct");
		
		
	}
	
	public void setNames(String args1, String args2, float args3)
	{
		title=args1;
		author=args2;
		price=args3;
	}
	
	public void print()
	{
		System.out.println("Title: " + title + "\nAuthor:" + author + "\nPrice: " + price);
	}
	}
