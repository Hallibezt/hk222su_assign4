package hk222su_assign4;

import java.util.Scanner;



public class SafeDateMain {

	    public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		
		while (true) {		
		DateFormat test= new DateFormat();
		try {
		System.out.print ("Please enter year: ");		
			int year = input.nextInt();
			test.setYear(year);	
			if (year==0)
				break;			
			
		System.out.print ("Please enter month: ");
		
			test.setMonth(input.nextInt());				
			
		System.out.print ("Please enter day: ");		
			test.setDay(input.nextInt());						
		
		
		
		System.out.println(test.getDate(true));		
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			
		}	    
		}
		System.out.print("Good bye");
		input.close();
	 }
}
