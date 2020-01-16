package hk222su_assign4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckingWords {
	public static void main(String[] args) {
		
		try {
			File test = new File ("/home/haraldur/eclipse-workspace/1DV510/src/hk222su_assign4/lovecraft.txt");
			Scanner read = new Scanner(test);					
			//Here I create list to collect my words into and a integer to count the words (to set the limit to 50.000 words - time wise)
			ArrayList<String> wordCounter = new ArrayList<String>();
			int test1 = 0;
			
			//Here I add the first 50 thousand words to my list (If I would like to read all in the file I would skip test1 and have just read.hasNext())
			while (test1<10000 && read.hasNext()) { //THIS IS SET TO TEST FIRST 10 THOUSAND WORDS - take out test1<1000&& to test whole document - TAKES A LONG TIME THOUGH
				wordCounter.add(read.next());
				test1++;					
				
			}
			
			//Here I sort the words to group same words together
			wordCounter.sort(String::compareToIgnoreCase);
			int highest = 0;
			int nextHighest = 0;
			int secondHighest = 0;
			String highestString = "";
			String secondString ="";
			
			//Search for the word with most occurrences 
			for(int i = 0; i<wordCounter.size(); i++) {
				String a = wordCounter.get(i);				
				for(int j = 1; j<wordCounter.size(); j++) {
					String b = wordCounter.get(j);					
							if (a.equalsIgnoreCase(b))
								nextHighest++;		
							if (nextHighest > highest) {                         
								highest = nextHighest;
								highestString = a;}							
															
							if (!a.equalsIgnoreCase(b))	{
								nextHighest =0;
							}							
							}
				    }
			//Search for the word with second most occurrences - that is I know the one with the most, so I use same technique as long as it is not the same word as from first iteration == ok
			for(int i = 0; i<wordCounter.size(); i++) {
				String a = wordCounter.get(i);				
				for(int j = 1; j<wordCounter.size(); j++) {
					String b = wordCounter.get(j);					
							if (a.equalsIgnoreCase(b))
								nextHighest++;		
							if (nextHighest > secondHighest && !a.equalsIgnoreCase(highestString)) {                         
								secondHighest = nextHighest;
								secondString = a;}																
							if (!a.equalsIgnoreCase(b))	{
								nextHighest =0;
							}							
						}
				    }
			
			int cthulhu = 0;
			int azathoth = 0;
			int necronomicon = 0;
			
			for(int i = 0; i<wordCounter.size(); i++) {
				String a = wordCounter.get(i).toLowerCase();
				
				if(a.contains("cthulhu")) {
					cthulhu++;
				}
				if(a.contains("azathoth")) {
					azathoth++;
				}
				if(a.contains("necronomicon")) {
					necronomicon++;
				}
			}
			
				
				read.close();	
			
			System.out.println("The word with most occurrences is: " + highestString + ", it appeared: " + highest + " times.");
			System.out.println("The word with most occurrences is: " + secondString + ", it appeared: " + secondHighest + " times.");	
			System.out.println("Cthulhu appeared: " + cthulhu + " times.");
			System.out.println("Azathoth appeared: " + azathoth + " times.");
			System.out.println("Necronomicon appeared: " + necronomicon + " times.");
		}		
		 
		catch (FileNotFoundException e) {				
			e.printStackTrace();
		}		
	}

}
