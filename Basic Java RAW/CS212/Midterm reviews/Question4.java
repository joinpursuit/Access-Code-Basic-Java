
public class Question4 {

private String title, author;
private float price;

	public Question4 (String args1, String args2, String args3)
	{
		title=args1;
		author=args2;
		price=Float.parseFloat(args3);
		if(title.length()==0||author.length()==0||price < 0)
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
