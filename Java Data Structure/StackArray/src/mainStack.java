
public class mainStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack myname = new Stack ();
		 for ( int i = 0 ; i < 10 ; i ++)
		 {
			 myname.pushFront((char) ('a'+i));
		 }
		
		
		while (myname.empty() == false)
		 {
			 System.out.println(myname.popFront());
		 }
		 System.out.println("HELLO");

		 
	}

}
