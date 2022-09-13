/**
 * Class: CMSC204
 *  Program: Assignment #1
 *  Instructor: Dr. Kuijt
 * Description: An application that will check for valid passwords
 * Due: 09/13/2022 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Shengquan Yang
*/



import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.function.BooleanSupplier;


public class PasswordCheckerUtility {

	public static boolean comparePasswordsWithReturn(String password, String password2) {
		
		boolean comparePasswordsWithReturn = false;
		
		if (password.equals(password2)) {
			comparePasswordsWithReturn = true;
		}
			
		return comparePasswordsWithReturn;
	}
	
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
		
		if (!comparePasswordsWithReturn(password, passwordConfirm)){
			throw new UnmatchedException("Passwords do not match");
		}
	}
	
	
	/**
	 * 
	 * @param password the string the user input
	 * @return true if the password has valid length
	 * @throws LengthException display message "The password must be at least 6 characters long"
	 */
	public static boolean isValidLength(String password) throws LengthException{
		
		if (password.length() < 6){
			throw new LengthException("The password must be at least 6 characters long");
		}	
		return true;
		
	}

	/**
	 * @param password the string the user input
	 * @return true if the password has at least one upper alpha
	 * @throws NoUpperAlphaException display message "The password must contain at least one uppercase alphabetic character"
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
		boolean hasUpperAlpha = false;
		char ch1;
		
		for (int i=0; i<password.length(); i++)
		{
			ch1 = password.charAt(i);
			
			if(Character.isUpperCase(ch1)){
				hasUpperAlpha = true;
			}
		}
		
		if (!hasUpperAlpha){
			 throw new NoUpperAlphaException ("The password must contain at least one uppercase alphabetic character");    
		}	
		
		return hasUpperAlpha;
	}
	
	/**
	 * @param password the string the user input
	 * @return true if the password has at least one lower alpha
	 * @throws NoLowerAlphaException display message "The password must contain at least one lowercase alphabetic character"
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		boolean hasLowerAlpha = false;
		char ch1;
		
		for (int i=0; i<password.length(); i++)
		{
			ch1 = password.charAt(i);
			
			if(Character.isLowerCase(ch1)) {
				hasLowerAlpha = true;
			}
		}
		
		if (!hasLowerAlpha){
			 throw new NoLowerAlphaException ("The password must contain at least one lowercase alphabetic character");    
		}	
		
		return hasLowerAlpha;
		
	}
	
	/**
	 * @param password password the string the user input
	 * @return true if the password has at least one digit
	 * @throws NoDigitException display message "The password must contain at least one digit."
	 */
	public static boolean hasDigit(String password) throws NoDigitException{
		boolean hasDigit = false;
		char ch1;
		
		for (int i=0; i<password.length(); i++)
		{
			ch1 = password.charAt(i);
			
			if(Character.isDigit(ch1)) {
				hasDigit = true;
			}
		}
		
		if (!hasDigit)
		{
			 throw new NoDigitException ("The password must contain at least one digit.");    
		}	
		
		return hasDigit;
	}
	
	
	/**
	 * @param password the string the user input
	 * @return true if the password has at least one special character
	 * @throws NoSpecialCharacterException display message "The password must contain at least one special character"
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
		
		
		Pattern special = Pattern.compile("[a-zA-Z0-9]*");
		Matcher hasSpecial = special.matcher(password);
		
		if (hasSpecial.matches()) {
			throw new NoSpecialCharacterException("The password must contain at least one special character");
		}
		return true;
	
	}
	
	/**
	 * @param password the string the user input
	 * @return true if the password doesn't have three same characters in sequence
	 * @throws InvalidSequenceException display message "The password cannot contain more than two of the same character in sequence"
	 */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException{
		
		boolean NoSameCharInSequence = true;
		
		for(int i=0; i<password.length()-2;i++) {
			if (password.charAt(i) == password.charAt(i+1)) {
				if (password.charAt(i+1) == password.charAt(i+2)) {
					throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");
				}
			}
		}
		return NoSameCharInSequence;
	}
	
	
	/**
	 * @param password the string the user input
	 * @return true if the password has Between Six And nine characters
	 */
	public static boolean hasBetweenSixAndNineChars(String password){

		boolean hasBetweenSixAndNineChars = false;
		if (password.length() >= 6 && password.length()<= 9)
		{
			hasBetweenSixAndNineChars = true;
		}
		
		return hasBetweenSixAndNineChars;
		
	}
	
	/**
	 * @param password the string the user input
	 * @return true if the password is a weak password
	 * @throws WeakPasswordException display message "Password is OK but weak"
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException{
		
		if (hasBetweenSixAndNineChars(password)){
			throw new WeakPasswordException("Password is OK but weak");
		}
		
		return false;
	}
	
	/**
	 * @param password the string the user input
	 * @return true if the password is valid
	 * @throws LengthException display message "The password must be at least 6 characters long"
	 * @throws NoUpperAlphaException display message "The password must contain at least one upper case alphabetic character"
	 * @throws NoLowerAlphaException display message "The password must contain at least one lower case alphabetic character"
	 * @throws NoDigitException display message "The password must contain at least one digit"
	 * @throws NoSpecialCharacterException display message "The password cannot contain more than two of the same character in sequence"
	 * @throws InvalidSequenceException display message "The password must contain at least one special character"
	 */
	public static boolean isValidPassword(String password)throws LengthException,
																 NoUpperAlphaException,
														         NoLowerAlphaException,
														         NoDigitException,
														         NoSpecialCharacterException,
														         InvalidSequenceException{	
		try {
			isValidLength(password);
		}catch(LengthException e) {
			throw new LengthException("The password must be at least 6 characters long");
		}     
		
		try {
			hasUpperAlpha(password);
		}catch(NoUpperAlphaException e) {
			throw new NoUpperAlphaException ("The password must contain at least one uppercase alphabetic character");  
		}
		
		try {
			hasLowerAlpha(password);
		}catch(NoLowerAlphaException e) {
			throw new NoLowerAlphaException ("The password must contain at least one lowercase alphabetic character");      
		}
		
		try {
			hasDigit(password);
		}catch(NoDigitException e) {
			throw new NoDigitException ("The password must contain at least one digit");
		}
		
		try {
			NoSameCharInSequence(password);
		}catch(InvalidSequenceException e) {
			throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");
		}
		
		try {
			hasSpecialChar(password);
		}catch(NoSpecialCharacterException e) {
			throw new NoSpecialCharacterException("The password must contain at least one special character");
		}
		
		return true;
		
	}
	
	
	
	/**
	 * @param passwords the string the user input
	 * @return
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {

		ArrayList<String> invalidPasswords = new ArrayList<String>();
		String str;
		File file = new File("password.text");
		
		try {
			PrintWriter pw = new PrintWriter(file);
			for (int i=0; i<passwords.size(); i++) {
				try {
					isValidPassword(passwords.get(i));
				}catch(LengthException e){
					str = passwords.get(i) + (" -> The password must be at least 6 characters long");
					invalidPasswords.add(str);
					pw.println(passwords.get(i) + (" -> The password must be at least 6 characters long"));
				}catch (NoUpperAlphaException e) {
					str = passwords.get(i) + (" -> The password must contain at least one uppercase alphabetic character");
					invalidPasswords.add(str);
					pw.println(passwords.get(i) + (" -> The password must be at least 6 characters long"));
				} catch (NoLowerAlphaException e) {
					str = passwords.get(i) + (" -> The password must contain at least one lowercase alphabetic character");
					invalidPasswords.add(str);
					pw.println(passwords.get(i) + (" -> The password must be at least 6 characters long"));
				} catch (NoDigitException e) {
					str = passwords.get(i) + (" -> The password must contain at least one digit");
					invalidPasswords.add(str);
					pw.println(passwords.get(i) + (" -> The password must be at least 6 characters long"));
				} catch (NoSpecialCharacterException e) {
					str = passwords.get(i) + (" -> The password must contain at least one special character");
					invalidPasswords.add(str);
					pw.println(passwords.get(i) + (" -> The password must be at least 6 characters long"));
				} catch (InvalidSequenceException e) {
					str = passwords.get(i) + (" -> The password cannot contain more than two of the same character in sequence");
					invalidPasswords.add(str);
					pw.println(passwords.get(i) + (" -> The password must be at least 6 characters long"));
				}
			}
			pw.close();
		
		} catch (FileNotFoundException e1) {
		}
		
		return invalidPasswords;
		
	}
}

	