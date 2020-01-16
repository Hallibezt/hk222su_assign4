package hk222su_assign4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountingWords {
public static void main(String[] args) {
		
		int countTotal = 0;	
		int isWord = 0;
		int isPageNr = 0;
		
		
		try {
			File test = new File ("/home/haraldur/eclipse-workspace/1DV510/src/hk222su_assign4/lovecraft.txt");
			Scanner read = new Scanner(test);			
				
			while (read.hasNextLine()) {
				String a = read.nextLine().trim();
				if (a.matches("[0-9]+")) //count page numbers
					isPageNr++;
				Scanner readWords = new Scanner(a);
					while(readWords.hasNext()) {				
						readWords.next(); //count total words
						countTotal++;
					}
					readWords.close();	
				}
			isWord = countTotal - isPageNr; //subtracting page numbers from total words
			System.out.println("This is total number of words: "+ countTotal);
			System.out.println("This is number of words that are page numbers: " + isPageNr);
			System.out.println("This is total number of words, not including page numbers: " + isWord);	
			read.close();
		} 
		catch (FileNotFoundException e) {				
			e.printStackTrace();
		}		
		

	}	

}
