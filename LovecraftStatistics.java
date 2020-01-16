package hk222su_assign4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LovecraftStatistics {
	public static void main(String[] args) {
		
		int countTotal = 0;	
		int isEmpty = 0;
		int isPageNr = 0;
		
		
		try {
			File test = new File ("/home/haraldur/eclipse-workspace/1DV510/src/hk222su_assign4/lovecraft.txt");
			Scanner read = new Scanner(test);
			
			while (read.hasNextLine()) {			
				String empty = read.nextLine().trim();				
				countTotal++;
				if (empty.matches("[0-9]+")) 
					isPageNr++;				
					
				if (empty.isEmpty())
					isEmpty++;
				}
			read.close();
		} 
		catch (FileNotFoundException e) {				
			e.printStackTrace();
		}
		int isText = countTotal - isEmpty - isPageNr;
		
		System.out.println("Lovecraft.txt has: " + countTotal + " lines.");
		System.out.println("Lovecraft.txt has: " + isEmpty + " empty lines.");
		System.out.println("Lovecraft.txt has: " + isPageNr + " lines with page numbers.");
		System.out.println("Lovecraft.txt has: " + isText + " lines with Text.");

	}	

}
