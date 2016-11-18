import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * A simple calculator for use in the command line. There's no GUI.
 * 
 * @author Thomas Kozsir
 *
 */
public class Calculator {

	boolean exit = false;
	Scanner eingabe;

	public Calculator() {
		eingabe = new Scanner(System.in);
		View.printInitialise();

		update();

	}

	/**
	 * Repeadetly takes in the user commands and starts evaluation by pressing
	 * enter.
	 */
	public void update() {
		while (!exit) {
			String eingabeterm = eingabe.nextLine();
			evaluateTerm(eingabeterm);
		}
	}

	/**
	 * Tokenizes the term. 
	 */
	public void evaluateTerm(String eingabeterm){
		StringTokenizer tokenizer = new StringTokenizer(eingabeterm);
		double result;
		
		//checks for keywords, not associated with calculating
		if(eingabeterm.equals("help")){
			View.printHelp();
		}else if(eingabeterm.equals("exit")){
			System.exit(1);
		}else if(eingabeterm.equals("clr")){
			Calculator newCalc = new Calculator();
		}else{
		
		//tokenizes the term and puts its tokens on a stack
			StringTokenizer tokens =  new StringTokenizer(eingabeterm);
			Stack<String> stack = new Stack<String>();
			while(tokens.hasMoreTokens()){
				stack.push(tokens.nextToken());
			}
		
		try{	
		double operand1 = Double.parseDouble(stack.pop());
		String operator = stack.pop();
		double operand2 = Double.parseDouble(stack.pop());
		
		switch(operator){
		case "+": View.printResult(sum(operand1, operand2));
			break;
		case "-": View.printResult(sub(operand2, operand1));
			break;
		case "/": View.printResult(div(operand2, operand1));
			break;
		case "*": View.printResult(multiplie(operand2, operand1));
			break;
		case "%": View.printResult(mod(operand2, operand1));
			break;
		default: 
		}
		}catch(Exception e){
			View.printSyntaxError();
		}
		
		
		}
	}
	
	/**
	 * Calculates modulo operation between two operands.
	 * @return 
	 */
	public double mod(double number1, double number2){
		return (number1%number2);
	}
	
	/**
	 * Multiplies the operands.
	 */
	public double multiplie(double number1, double number2){
		return (number1 * number2);
	}
	
	/**
	 * Divides the two operands and shortens the term.
	 */
	public double div(double number1, double number2){
		double result = 0;
		result = number1 / number2;
		//TODO shorten(result);
		return result;
	}
	

	/**
	 * sums up the given operands.
	 * 
	 * @return
	 */
	public double sum(double ...number) {
		double result = 0;
		
		for(double i : number){
			result += i;
		}
		
		return result;
	}
	
	/**
	 * subtracts the second operand from the first.
	 */
	public double sub(double number1, double number2){
		return number1 - number2;
	}

}