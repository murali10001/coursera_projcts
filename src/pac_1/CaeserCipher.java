package pac_1;

import java.util.Scanner;

public class CaeserCipher {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("enter a msg : ");
		String message=scan.nextLine();
		
		int key1=15;
		int key2=0;
		
		String encrypt = encrypted_msg(message,key1,key2);
		System.out.println( "Encrypted msg : "+encrypt);
		
		
		String decrypt=encrypted_msg(encrypt,26-key1,26-key2);
		System.out.println("decrypt msg "+decrypt);	
		scan.close();
	}
	
	public static String encrypted_msg(String input,int key1,int key2) {
		
		StringBuilder encrypted=new StringBuilder(input);
		String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Lalphabet="abcdefghijklmnopqrstuvwxyz";
		//shifted alphabet
		String shiftedalphabet1=alphabet.substring(key1)+alphabet.substring(0,key1);
		String shiftedLalphabet1=Lalphabet.substring(key1)+Lalphabet.substring(0,key1);
		
		String shiftedalphabet2=alphabet.substring(key2)+alphabet.substring(0,key2);
		String shiftedLalphabet2=Lalphabet.substring(key2)+Lalphabet.substring(0,key2);
		
		for(int i=0;i<encrypted.length();i++) {
			
			char currChar=encrypted.charAt(i);
			String shiftedalphabet=(i%2==0)?shiftedalphabet1:shiftedalphabet2;
			String shiftedLalphabet=(i%2==0)?shiftedLalphabet1:shiftedLalphabet2;
			
			//HANDLE UPPER CASE
			if(Character.isUpperCase(currChar)) {	
				int index=alphabet.indexOf(currChar);
				if(index!= -1) {
					char newChar=shiftedalphabet.charAt(index);
					encrypted.setCharAt(i, newChar);
				}
			}
			//HANDLE LOWER CASE
			else if(Character.isLowerCase(currChar)) {	
				int index=Lalphabet.indexOf(currChar);
				if(index!= -1) {
					char newChar=shiftedLalphabet.charAt(index);
					encrypted.setCharAt(i, newChar);
				}
			}
		}
		
		
		return encrypted.toString();
	}
}
