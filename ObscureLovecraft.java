package hk222su_assign4;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ObscureLovecraft {
	//Takes really long time to print my obscure and readable file
	
	public static void main(String[] args)  throws InputMismatchException{		
	Scanner input = new Scanner(System.in);
	int loop = 0;	
	while(loop==0)	{
		System.out.println ("Please enter number: "
				+        "\n ======================"
				+ "\n 1. Make obscure"
				+ "\n 2. Make readable"
				+ "\n 3. Print obscure"
				+ "\n 4. Print readable"
				+ "\n 5. Exit");	
		
	try {
		
		int number = input.nextInt();
	if(number < 1 || number > 5)
		System.out.println("Please choose number from the list");
		
	switch (number) {
		case 1 : 
			try {
				obscure();
					} 
			catch (FileNotFoundException e) {				
				e.printStackTrace();}			
			break;		
		case 2: 
			try {	
				readable();
				}
			catch (FileNotFoundException e) {				
				e.printStackTrace();}
			break;
		case 3: 
			try {
				System.out.println(printObscure());						
				}
			catch (FileNotFoundException e) {				
				e.printStackTrace();}
			break;
		case 4: 
			try {
				System.out.println(printReadable());
				} 
			catch (FileNotFoundException e) {				
				e.printStackTrace();}
			break;
		case 5:
			loop=-1;
		}
	}
	catch(InputMismatchException e) {
		System.out.println("Invalid input");
		input.next();}	
	} 
	
	System.out.print("Okey, bye!");
	input.close();
	
	}
	
	public static void obscure() throws FileNotFoundException {
		StringBuilder obscure = new StringBuilder();
		
		File test = new File ("/home/haraldur/eclipse-workspace/1DV510/src/hk222su_assign4/lovecraft.txt");
		Scanner read = new Scanner(test);			
		
		while (read.hasNextLine()) {
			String ab = read.nextLine();
			String bc ="";
			for (int i = 0; i<ab.length(); i++) {
				int a = ab.charAt(i);
				int b = a+3;
				bc += (char) b;				
			  }
			obscure.append(bc+"\n");			
			}
		File outfile = new File ("/home/haraldur/eclipse-workspace/1DV510/src/hk222su_assign4/obscure.txt");
		PrintWriter printer = new PrintWriter(outfile);
		printer.print(obscure);
		printer.close();
			
		read.close();		
		
	}
	
	public static void readable() throws FileNotFoundException {
		StringBuilder readable = new StringBuilder();
		
		File test = new File ("/home/haraldur/eclipse-workspace/1DV510/src/hk222su_assign4/obscure.txt");
		Scanner read = new Scanner(test);
		while (read.hasNextLine()) {
			String ab = read.nextLine();
			String bc ="";
			for (int i = 0; i<ab.length(); i++) {
				int a = ab.charAt(i);
				int b = a-3;
				bc += (char) b;				
			  }
			readable.append(bc+"\n");			
			}
		File outfile = new File ("/home/haraldur/eclipse-workspace/1DV510/src/hk222su_assign4/readableLovecraft.txt");
		PrintWriter printer = new PrintWriter(outfile);
		printer.print(readable);
		printer.close();
			
		read.close();		
		
	}
	
	public static String printObscure() throws FileNotFoundException {
		File test = new File ("/home/haraldur/eclipse-workspace/1DV510/src/hk222su_assign4/obscure.txt");
		Scanner read = new Scanner(test);
		String obscured = "";
		while (read.hasNextLine()) {
			 obscured += read.nextLine() + "\n";			
		}
		
		read.close();
		return obscured;
		
		
	}
	public static String printReadable() throws FileNotFoundException {
		File test = new File ("/home/haraldur/eclipse-workspace/1DV510/src/hk222su_assign4/readableLovecraft.txt");
		Scanner read = new Scanner(test);
		String readable = "";
		while (read.hasNextLine()) {
			readable += read.nextLine() + "\n";
						
		}
		read.close();
		return readable;	
		
	}
	
	
}

