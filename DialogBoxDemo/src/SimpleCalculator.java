import javax.swing.JOptionPane;

public class SimpleCalculator {

	/**
	 * Written by Andrew Nagel
	 * This program allows users to make simple calculations:
	 * (Add, Subtract, Multiply, and Divide)
	 */
	public static void main(String[] args) {

		//Show initial prompt and get initial input
		String menutext = "Choose an op, \na for add\ns for subtract\nm for multiply\nd for divide\nq to quit";
		
		String op = JOptionPane.showInputDialog(menutext);
		
		//Declare string variables to hold input
		//and double variables to hold the numeric conversions
		//and results
		String arg1Str, arg2Str, resultStr;
		double arg1, arg2, result=0;
		//tmp will hold the first letter of whatever op is typed
		char tmp = op.charAt(0);
		
		//loop that keeps the app running
		while(tmp!='q')
		{
			//make sure the op is valid
			if(tmp!='a'&&tmp!='s'&&tmp!='m'&&tmp!='d')
			{
				op = JOptionPane.showInputDialog("Invalid Entry!\n\n"+menutext);
				tmp = op.charAt(0);
			}
			else
			{
			//get the numeric input
			arg1Str = JOptionPane.showInputDialog("Enter argument 1");
			arg2Str = JOptionPane.showInputDialog("Enter argument 2");
			
			try
			{
			//do the conversion to numeric type
			arg1 = Double.parseDouble(arg1Str);
			arg2 = Double.parseDouble(arg2Str);
				
				//do the appropriate op
				switch (tmp)
				{
					case 'a' :
						result = arg1 + arg2;
						break;
					case 's' :
						result = arg1 - arg2;
						break;
					case 'm' :
						result = arg1 * arg2;
						break;
					case 'd' :
						result = arg1 / arg2;
						break;
				}
			
				//create the result string, then show it
				resultStr = String.format("The answer is %30.1f", result);
				
				JOptionPane.showMessageDialog(null, resultStr);
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "You entered an invalid number, please try again.");
			}
			
				//get the net op
				op = JOptionPane.showInputDialog(menutext);
				tmp= op.charAt(0);
			}
			
			int confirmed;
			
			while(tmp=='q')
			{
				confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?");
				if(confirmed==0)  //they want to quit, so break out of the confirmation loop, tmp still has value q, so big loop exits
					{
						break;
					}
				//otherwise get the net op
				op = JOptionPane.showInputDialog(menutext);
				tmp= op.charAt(0);
			}
			
		}
		
		JOptionPane.showMessageDialog(null, "That's all folks!");
		
	}

}
