import javax.swing.*;

public class question3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count =0;
		String input = JOptionPane.showInputDialog("Enter a line of digit and letters");
		for(int i = 0; i < input.length(); i++)
		{
			if(Character.isDigit(input.charAt(i)))
				count++;
		}
		JOptionPane.showMessageDialog(null, "Number of digits: " + count);
	}

}
