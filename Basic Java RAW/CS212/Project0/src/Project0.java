import javax.swing.*;

public class Project0 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = JOptionPane.showInputDialog(null, "Please enter a sentence: ");
		
		while(!(s.equalsIgnoreCase("stop")))
		{
			int count=0;
			for(int i =0; i <= s.length(); i++)
			{
				if(i<s.length()-1)
					{
					if((s.substring(i,i+1)).equals(s.substring(i+1,i+2)))
						count++;
					}
			
			}
			JOptionPane.showMessageDialog(null, "There are  pair " + count + " of consecutive letters.");
			s = JOptionPane.showInputDialog(null, "Please enter a sentence: ");
		}
		
	}

}
	
