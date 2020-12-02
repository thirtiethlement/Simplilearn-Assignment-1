package calc;

public class Order 
{
	private final String orderType;
	private final double argumentOne;
	private final double argumentTwo;
	
	public Order(String orderType, String argumentOne, String argumentTwo) throws BadSyntaxException
	{
		if (!(orderType.matches("^[x\\+\\/\\-*]+")) || orderType.length() != 1)
		{
			throw new BadSyntaxException("Invalid operator.");
		}
		else
		{
			this.orderType = orderType;
		}
		
		if (!(argumentOne.matches("^[0-9]+(\\.\\d+)*$")))
		{
			throw new BadSyntaxException("Invalid value for argument one.");
		}
		else
		{
			this.argumentOne = Double.valueOf(argumentOne);
		}
		
		if (!(argumentTwo.matches("^[0-9]+(\\.\\d+)*$")))
		{
			throw new BadSyntaxException("Invalid value for argument two.");
		}
		else
		{
			this.argumentTwo = Double.valueOf(argumentTwo);
		}
	}

	public String getOrderType() 
	{
		return orderType;
	}

	public double getArgumentOne() 
	{
		return argumentOne;
	}

	public double getArgumentTwo() 
	{
		return argumentTwo;
	}
	
	public double execute() throws ArithmeticException
	{
		double returnValue = 0;
		switch(this.orderType)
		{
		case "+":
			returnValue = this.executeAdd();
		case "-":
			returnValue = this.executeSub();
		case "x":
			returnValue = this.executeMult();
		case "*":
			returnValue = this.executeMult();
		case "/":
			try
			{
				returnValue = this.executeDiv();
			}
			catch (ArithmeticException e)
			{
				throw e;
			}
			
		}
		return returnValue;
	}
	
	public double executeAdd()
	{
		return this.argumentOne + this.argumentTwo;
	}
	
	public double executeSub()
	{
		return this.argumentOne - this.argumentTwo;
	}
	
	public double executeMult()
	{
		return this.argumentOne * this.argumentTwo;
	}
	
	public double executeDiv() throws ArithmeticException
	{
		if (argumentTwo == 0)
		{
			throw new ArithmeticException("You can't divide by zero.");
		}
		return this.argumentOne / this.argumentTwo;
	}
}
