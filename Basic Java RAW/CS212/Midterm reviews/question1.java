import java.util.*;

public class question1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int sum = 0, product=1;
		for(int i = 0; i < args.length; i++)
		{
			if(args.length!=2)
			{
				throw new IllegalArgumentException("Invalid argument length");
			}
			
			try
			{
				sum+=Integer.parseInt(args[i]);
				product*=Integer.parseInt(args[i]);
			}
			catch (Exception e)
			{
				System.out.println("Argument must be an integer");
			    System.exit(1);
			}
		}
		System.out.println(args[0] + " + " + args[1] + " = " + sum);
		System.out.println(args[0] + " * " + args[1] + " = " + product);
	}

}
