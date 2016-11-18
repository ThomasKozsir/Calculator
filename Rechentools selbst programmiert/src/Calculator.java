import java.util.Scanner;

/**
 * A simple calculator for use in the command line. There's no GUI.
 * @author Thomas
 *
 */
public class Calculator {

	boolean exit = false;
	Scanner eingabe;
	
	
	public  Calculator(){
		eingabe = new Scanner(System.in);
		View.printInitialise();
		
		update();
		
	}
	
	public void update(){
		while(!exit){
			String eingabeterm = eingabe.next();
			evaluateTerm();
		}
	}
	
	public void evaluateTerm(){
		
	}
	
	
	
}