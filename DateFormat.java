package hk222su_assign4;

public class DateFormat {
	private int year;
	private int month;
	private int day;
	private char punctuation = '.'; //nothing in the assignment that I can not initialize those chars, I do It because else if uses set methods to create a data and forgets those two - it will return null.
	private char format = 'l'; //Asked one of the teachers assistance and he said if is ok. 

	public DateFormat() {
	}
	public DateFormat(int year, int month, int day, char punctuation, char format) {
	setYear(year);
	setMonth(month);
	setDay(day);
	setPunctuation(punctuation);
	setFormat(format);
	}

	public void setYear(int year) {	//between 1900-2100 in the assignment, I take that as 1900 and 2100 is excluded (easy to change if they are included just change > and < to >= and <= ) 
		if(year > 1900 && year < 2100){
			this.year = year;
		}	
		else
			if (year!=0)
			throw new IllegalArgumentException("Invalid year, must be between 1900 and 2100");	
	}
	public void setMonth(int month) {	
		if(month >= 1 && month <= 12){
			this.month = month;}
		else
			throw new IllegalArgumentException("Invalid month, must be between 1 and 12");
	}
	public void setDay(int day) {	
		if(day >= 1 && day <= 31){
			this.day = day;}
		else
			throw new IllegalArgumentException("Invalid day");
	}

	public void setPunctuation(char punch) {	
			this.punctuation = punch;
		
	}
	public void setFormat(char format) {	
		if (format == 'l') {
			this.format = format;
		}
		if (format == 'b') {
			this.format = format;
		}	
		if (format == 'm') {
			this.format = format;
		}
		
	}

	public String getDate(boolean fullYear) {
		
		String date;
		
		//Here below I will be making some restrictions before working on the string
		//First to make sure date is in the range
		//For VG question 3.7 - make sure days are in order with the month chosen
			
		
		
		if (this.month == 2) {//Make sure February is correct - leap year (year is divisible by 4, but if also by 100 it must then be also with 400)
			if(this.year % 4 == 0) {
				if(this.year % 100 == 0) {
					if(this.year % 400 == 0) {
						if(this.day > 29) {//if year  div. by 4,100 and 400
							throw new IllegalArgumentException("There are only 29 days in leap year's February");						
							
							}
					}
					if(this.day > 28) {//if year  div. by 4 and 100 but not 400
						throw new IllegalArgumentException("Invalid date - only 28 days in February");					
						}
				}
				if(this.day > 29) {//if year only div. by 4 (not 100)
					throw new IllegalArgumentException("There are only 29 days in leap year's February");
				}
			}
		
		else {//Normal February - not leap year
			if(this.day>28)
					throw new IllegalArgumentException("Invalid date - only 28 days in February");
				}
		}
		
		//Make sure the 30 day months are ok
		if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
			if(day > 30) {
				throw new IllegalArgumentException("Invalid date - only 30 days in this month");		
			}
		}
		
		String month1 = Integer.toString(this.month);
		String day1 = Integer.toString(this.day);
		
		if(this.month<10) {
			month1 = String.format("%02d", this.month);		
		}
		if(this.day<10) {
			day1 = String.format("%02d",this.day);
		}
		
		
		 
		
		
		
		if (fullYear == false) { 		 
				this.year = this.year % 100;
				//change to string and measure length - if the string is one letter (to add zero in front)
				int length = String.valueOf(this.year).length();
				char zero = '0'; //so that year 1901 at two digits appear 01 instead of just 1
		
				//Here are my string creations for the years i.e. 1900-1909 with two digits(adding 0 in front)
			if(length < 2)	{	
				//If char ! is used as punctuation, there is no char in the format "" instead to get no-space
				if (this.punctuation == '!') {
					if(this.format == 'b') { 					
						date = zero + Integer.toString(this.year) + "" + month1 + "" + day1 ; 
						return date;}
					if(this.format == 'l') {
						date = day1 + "" + month1 + "" + zero + Integer.toString(this.year) ;
						return date;}
					if(this.format == 'm') {
						date = month1 + "" + day1 + "" + zero + Integer.toString(this.year) ;
						return date;}
				}
				
				//This is if everything is normal (except the year has just one digit)			
				if(this.format == 'b') { 
					date = zero + Integer.toString(this.year) + this.punctuation + month1 + this.punctuation + day1 ; 
					return date;}
				if(this.format == 'l') {
					date = day1 + this.punctuation + month1 + this.punctuation + zero + Integer.toString(this.year) ;
					return date;}
				if(this.format == 'm') { 
					date = month1 + this.punctuation + day1 + this.punctuation + zero + Integer.toString(this.year) ;
					return date;}
				}
			}	
		
		//Here below are two string versions - one for ! = no punctuation and another for all other punctuation
		// These two string versions below are for year = for digits and year two digits (but not the one missing leading 0)
		
		if (this.punctuation == '!') {
			if(this.format == 'b') { 
				date = Integer.toString(this.year) + "" + month1 + "" + day1 ; 
				return date;}
			if(this.format == 'l') {
				date = day1 + "" + month1 + "" + Integer.toString(this.year) ;
				return date;}
			if(this.format == 'm') {
				date = month1 + "" + day1 + "" + Integer.toString(this.year) ;
				return date;}
			}
				
		if(this.format == 'b') { 
			date = Integer.toString(this.year) + this.punctuation + month1 + this.punctuation + day1 ; 
			return date;}
		if(this.format == 'l') {
			date = day1 + this.punctuation + month1 + this.punctuation + Integer.toString(this.year) ;
			return date;}
		if(this.format == 'm') { 
			date = month1 + this.punctuation + day1 + this.punctuation + Integer.toString(this.year) ;
			return date;}
		return null;

		}

}
