package calc;
import java.util.Scanner;

public class Calculator 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String parseString = "placeholder";
		
		while (!(parseString.equals("exit")))
		{
			System.out.println("Accepted formatting:  <argument one> <operator> <argument two>");
			System.out.println("Accepted operators:  +, -, /, *, x");
			System.out.println("Type 'exit' to close the program.");
			parseString = sc.nextLine();
			String[] stArray = parseString.split(" ");
			if (parseString.equals("exit"))
			{
				sc.close();
			}
			else if (stArray.length != 3)
			{
				System.out.println("Bad syntax.  Try again.");				}
			else
			{
				try
				{
					Order workOrder = new Order(stArray[1], stArray[0], stArray[2]);
					System.out.println(workOrder.execute());
				}
				catch (Exception e)
				{
					System.out.println("Exception occurred: " + e);
				}
			}
		}
	}
}

