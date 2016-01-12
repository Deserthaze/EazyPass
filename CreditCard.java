package assignment4;
/*
 * EZ Pass Project
 */
import java.util.Scanner;

public class CreditCard {

	Scanner input = new Scanner(System.in);
	private long cardNumber;
	
	public CreditCard(){
		setCardNumber(askNum());
	}

	/**
	 * Sets Credit Card Number
	 * Checks for Validity
	 * @param cardNumber
	 */
	private void setCardNumber(long cardNumber) {
		boolean test = false;
		
		while(!test){
			if(isValid(cardNumber)){
				this.cardNumber = cardNumber;
				test = true;
			}
			else{
				cardNumber = askNum();
			}
		}
	}

	/**
	 * 
	 * @return Credit Card Number
	 */
	public long getCardNumber() {
		return cardNumber;
	}
	
	

	/**
	 * Return true if the card number is valid
	 * @param cardNumber2 Credit Card Number
	 * @return true if valid, false if invalid
	 */
	private static boolean isValid (long cardNumber2){
		boolean valid=false;
		
		valid=checkStartNum(cardNumber2);
		if(!valid)
			return false;
		
		valid=checkLength(cardNumber2);
		if(!valid)
			return false;
		
		int evenSum=sumAndSquareOfEvenPlace(cardNumber2);
		int oddSum=sumOfOddPlace(cardNumber2);
		
		if((evenSum+oddSum)%10 == 0)
			return true;
		else{
			System.out.println("Sum not divisible by 10");
			return false;
		}
	}
	
	/**
	 * Return true if the starting digit is possible 
	 * @param cardNumber2 Credit Card Number
	 * @return true if valid, false if invalid
	 */
	private static boolean checkStartNum(long cardNumber2){
		boolean valid=false;
		String num = String.valueOf(cardNumber2);
		
		if(num.charAt(0) == '4' || num.charAt(0) == '5' || num.charAt(0) == '6')
			valid=true;
		else if(num.charAt(0) == '3' && num.charAt(1) == '7')
			valid=true;
		else{
			if(num.charAt(0) == '3' && !(num.charAt(1) == '7'))
				System.out.println("Starting digit is not 37.");
			else
				System.out.println("Starting digit is " + num.charAt(0));
			System.out.println("Starting digit not valid for Visa Cards, Master Cards, American Express Cards, and Discover Cards");
		}
			
		return valid;
	}
	
	/**
	 * Return true if card number length is between 13 and 16 digits
	 * @param cardNumber2 Credit Card Number
	 * @return true if valid, false if invalid
	 */
	private static boolean checkLength(long cardNumber2){
		String num = String.valueOf(cardNumber2);
		if(num.length() < 13 || num.length() > 16){
			System.out.println("Credit Card Number has " + num.length() + " digits");
			return false;
		}
		else 
			return true;
	}
	
	/**
	 * Extract a digit from the long
	 * @param cardNumber2 Credit Card Number
	 * @param position position to be extracted
	 * @return the number extracted
	 */
	private static int seperateDigit(long cardNumber2, int position){
		String num = String.valueOf(cardNumber2);
		return Character.digit(num.charAt(position), 10);
	}
	
	/**
	 * Get the result from Steps 1 and 2
	 * @param cardNumber2 Credit Card Number
	 * @return the sum of the doubled even digits
	 */
	private static int sumAndSquareOfEvenPlace(long cardNumber2){
		int sum=0;
		int holdNum=0;
		String num = String.valueOf(cardNumber2);
		
		for(int i = num.length()-2; i>=0; i-=2){
			if(i>=0){
				holdNum = seperateDigit(cardNumber2, i);
				holdNum *= 2;
				if(holdNum>9)
					holdNum=getAsOneDigit(holdNum);
				sum+=holdNum;
			}
		}
		
		return sum;
	}
	
	/**
	 * Return the sum of the two digits
	 * @param number Credit Card Number
	 * @return the sum of the two digits
	 */
	private static int getAsOneDigit(int number){
		String num = String.valueOf(number);
		int left = Character.digit(num.charAt(0), 10);
		int right = Character.digit(num.charAt(1), 10);
		return left + right;
	}
	
	/**
	 * Sum of Odd Places
	 * @param cardNumber2 Credit Card Number
	 * @return sum of odd place
	 */
	private static int sumOfOddPlace(long cardNumber2){
		int sum=0;
		int holdNum=0;
		String num = String.valueOf(cardNumber2);
		
		for(int i = num.length()-1; i>=0; i-=2){
			holdNum = seperateDigit(cardNumber2, i);
			sum+=holdNum;
		}
		return sum;
	}
	
	/**
	 * Asks for new Credit Card Number
	 * @return credit card number
	 */
	public long askNum(){
		long cardNum = 0;
		boolean test=false;
		
		while(!test){
			System.out.println("\nEnter Credit Card Number:");
			try{
				cardNum = Long.parseLong(input.next());
				test=true;
			}
			catch(Exception e){
				System.out.println("Please enter a number");
				test=false;
			}
		}
		
		return cardNum;
	}
	
	public String toString(){
		return getClass()+"\nCredit Card Number: \tlong cardNumber"; 
	}
}
