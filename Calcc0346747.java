
/*Calculator Design: 1st Project Work on Object Oriented programming Techniques.
 * Developed By: Kamal Panthi
 * Student Roll No: c0346747
 * Email Address: kamal.panthi@lut.fi
  */
import java.applet.Applet;
import java.awt.*;
//Added imported declaration for the mathematics inbuilt functions.
import java.lang.Math;


// class BadOperationException:
class BadOperationException extends Exception
{
	
	/*
	 *Default Serial Version added since it showed the warning as mentioned below 
	 *"The serializable class BadOperationException does not declare a static final serialVersionUID field of type long"
	 */
	private static final long serialVersionUID = 1L;
	String label;
	BadOperationException() 
		{
			label = "E";
		}
}

/** Class Calcc0346747: 
 * Initialization, actions and operations Performed here
 
*/
public class Calcc0346747 extends Applet
{
	
	/**
	 *Default Serial Version added since it showed the warning as mentioned below
	 *"The serializable class Calcc0346747 does not declare a static final serialVersionUID field of 
 type long"
	 */
	private static final long serialVersionUID = 1L;
	
	//1.Initialization of Buttons
	Button add;	// Button to add two double numbers.
	Button subtract;  // Button to subtract two double numbers.
	Button equals;  // Button to generate results after operations completed.
	Button clear;  // Button to clear the result text box.
	Button lastOperation;
	Button zero;
	Button multiplication;  // Button to multiply two double numbers.
	Button division;  // Button to Divide a double number by another.
	Button Store;  // Button to store the double number as displayed in the textbox.
	Button Restore;  // Button to Restore the previously stored number.
	Button Sqrt;  // Button to get the square root of the provided number.
	Button Pow;  // Button to perform the action for the operation x raised to power y.
	Button Pi;  // Button to display the approximation of PI.
	Button Sin;  // Button to get the Sine value of an angle.	
	Button ArcSin;  // Button to get the InverseSine or ArcSine of a value.
	
	//2.Initialization of Label
	Label name;
	
	//3.Initialization of Text Box
	TextField result; 
	
	//3.Initialization of double variables
	double current = 0;  // variable for current double number
	double temp=0;  // variable for Temporary double number
	double Stored=0;  // variable for Storing double number
	double PI=0;  // variable for PI Value approximation
	
	// init() is always run when the applet is started
	public void init()
	{
		
		// Displays Label on the Top
		name=new Label("Calculator");  
		add(name);
		
		// Displays the empty text box with max limit of 25 integers
		result = new TextField(25);
		add(result);
		
		// Displays the Add Button with "+" Sign on it
		add = new Button("+");
		add(add);
		
		// Displays the Subtract Button with "-" Sign on it
		subtract = new Button("-");
		add(subtract);
		
		// Displays the Equals Button with "=" Sign on it
		equals = new Button("=");
		add(equals);
		
		// Displays the Clear Button
		clear = new Button("Clear");
		add(clear);
		
		// Displays the Multiplication Button with "*" Sign on it
		multiplication = new Button("*");
		add(multiplication);
		
		// Displays the Division Button with "/" Sign on it
		division = new Button("/");
		add(division);
		
		// Displays the Store Button
		Store = new Button("Store");
		add(Store);
		
		// Displays the Restore Button
		Restore = new Button("Restore");
		add(Restore);
		
		// Displays the Square Root Button with "Sqrt" Sign on it
		Sqrt= new Button("Sqrt");
		add(Sqrt);
		
		// Displays the PI Button
		Pi= new Button("Pi");
		add(Pi);
		
		// Displays the Power Button with "xPowy" Sign on it
		Pow= new Button("xPowy");
		add(Pow);
		
		// Displays the Sine Button
		Sin= new Button("Sin");
		add(Sin);
		
		
		// Displays the ArcSine Button
		ArcSin= new Button("ArcSin");
		add(ArcSin);
		
		
		lastOperation = null;
	}

	// action() is executed when a user-interface event
	// has happened
	public boolean action(Event event, Object arg)
	{
		//Started Try-Catch statement
		try {
			
			//These Operations Add,Subtract,Myltiply, Divide and Power
			//requires two double number parameters and dispalys result
			//on clicking on equals Button.
			//So when these buttons are clicked 
			//it calls another function named "completeOperation()"
			if ((event.target == add) ||  //When clicked add button or
				(event.target == subtract)||  //When clicked subtract button or
				(event.target == multiplication)||  //When clicked Multiply button or
				(event.target == division)||  //When clicked Divide button or
				(event.target == Pow))  //When clicked power button
					{
						completeOperation();  // function Call for "completeOperation();" 
						lastOperation = (Button) event.target;
						result.setText("");  // Emptying the Text box
						result.requestFocus();  //  Enabling the text box for input
					}
			//If clicked equals button
			else if (event.target == equals) 
				{
					completeOperation();// function Call for "completeOperation();"
					lastOperation = null;
					String text = Double.toString(current);  //The current value assigned to the Text Variable
					result.setText(text); //the Result of the operations displayed on the text box
					result.requestFocus();  //  Enabling the text box for input
				}
			// If clicked clear button
			else if (event.target == clear) 
				{
					current = 0;  // Current Variable replaced by Zero Value
					lastOperation = null;
					result.setText("");  // Emptying the Text box  
					result.requestFocus();  //  Enabling the text box for input
				} 
			// If clicked Store button
			else if (event.target== Store)
				{
					current=Double.valueOf(result.getText());  // Current Variable replaced by value of text box
					Stored=current;  // current Value stored in the stored variable			
				} 
			// If clicked Restore button
			else if (event.target== Restore)
				{
					String text = Double.toString(Stored);  //The Stored value assigned to the Text Variable
					result.setText(text);  //The Stored value then restored in the text box.
					result.requestFocus();  //  Enabling the text box for input
				}
			// If clicked PI button
			else if (event.target== Pi)
				{
					PI=(Math.PI);  // The approximation value of PI obtained from a inbuilt math function and assigned to PI variable 
					String text = Double.toString(PI);  //The PI value assigned to the Text Variable
					result.setText(text); //the PI value displayed on the text box
					result.requestFocus();  //  Enabling the text box for input
				}
			// If clicked Square Root Button
			else if (event.target == Sqrt) 
				{
					current= Double.valueOf(result.getText());  // Current Variable replaced by value of text box
					current= Math.sqrt(current);  //Square root of Current value calculated and again stored in current
					String text = Double.toString(current);  //The current value assigned to the Text Variable
					result.setText(text); //the Result of the operations displayed on the text box
					result.requestFocus();  //  Enabling the text box for input
				}
			// If clicked Sine Button
			else if (event.target == Sin) 
				{
					current= Double.valueOf(result.getText());  // Current Variable replaced by value of text box				
					current= Math.sin(current);  //Sine Radian of Current angle calculated and again stored in current
					String text = Double.toString(current);  //The current value assigned to the Text Variable
					result.setText(text); //the Result of the operations displayed on the text box
					result.requestFocus();  //  Enabling the text box for input
				}
			// If clicked ArcSine Button
			else if (event.target == ArcSin) 
				{
					current= Double.valueOf(result.getText());  // Current Variable replaced by value of text box				
					current= Math.asin(current);  //ArcSine angle of Current Radian calculated and again stored in current
					String text = Double.toString(current);  //The current value assigned to the Text Variable
					result.setText(text); //the Result of the operations displayed on the text box
					result.requestFocus();  //  Enabling the text box for input
				}
		
			} 
		// If exceptions Caught while in try Statement
		catch (BadOperationException e) 
			{
				lastOperation = null; //Last operation set to null
				result.setText(e.label); // Exception Displayed in the Text box
			}		
			return true; // Return True
	}
	
	//Function Created for few arithmetic operations to complete
	void completeOperation() throws BadOperationException {
		String text = result.getText(); // The Text Box Value stored in the text variable
		Double value; // Value Variable declared as double
		
		// Started Try-Catch statement
		try 
			{
				// The Value in text variable converted to Double and assigned to Variable "value"
				value = Double.valueOf(text);
			} 
		//If exceptions caught throw the exception
		catch (java.lang.NumberFormatException ne) 
			{
				BadOperationException oe = new BadOperationException();
				throw oe;
			}
		//Initialized new double variable "f" and assigned the value stored in Variable "value"
		double f = value.doubleValue();
		
		// If the Operation to perform is add two numbers
		if (lastOperation == add) 
			{
				current += f; // current = current + f
			} 
		// If the Operation to perform is subtract two numbers
		else if (lastOperation == subtract) 
			{
				current -= f;  // current = current - f
			} 
		// If the Operation to perform is multiply two numbers
		else if (lastOperation == multiplication) 
			{
				current *= f;  // current = current * f
			} 
		// If the Operation to perform is to divide a number by another numbers
		else if (lastOperation == division) 
			{
				current /= f;  // current = current / f
			} 
		// If the Operation to perform is to calculate x raised to power y
		else if (lastOperation == Pow) 
			{
				current=Math.pow(current, f); // current = current raised to power f
			}  
		// if the Last operation is nothing
		else if (lastOperation == null) 
			{
				current = f;  // current = f
			}
	}
}
