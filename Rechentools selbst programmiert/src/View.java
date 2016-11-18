
public abstract class View {
	
	
	public static void printInitialise(){
		System.out.println("- calculator initialized -\n"
				+ "type 'help' for usage");
	}
	
	public static void printHelp(){
		//TODO print usage of each function
		System.out.println("\n\nhelpfile: \nonly primitive operations are allowed for now.\n"
				+ "usage: <number1> space <operator> space <number2>");
	}
	
	public static void printSyntaxError(){
		System.out.println("Syntax error, type 'help' for usage");
	}
	
	
	public static void printResult(double result){
		System.out.println("\n" + result + "\n");
	}

}
