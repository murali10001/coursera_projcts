package pac_1;

import java.io.FileReader;
import java.util.Scanner;


public class CaeserCipher {
	private String alphabet,Salphabet;
	private String shiftedalphabet1,shiftedalphabet2,Shiftedsalphabet1,Shiftedsalphabet2;
	
	
	public CaeserCipher(int key1,int key2){
		
		 alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		 shiftedalphabet1=alphabet.substring(key1)+alphabet.substring(0,key1);
		 shiftedalphabet2=alphabet.substring(key2)+alphabet.substring(0,key2);
		 
		 Salphabet="abcdefghijklmnopqrstuvwxyz";
		 Shiftedsalphabet1=Salphabet.substring(key1)+Salphabet.substring(0,key1);
		 Shiftedsalphabet2=Salphabet.substring(key2)+Salphabet.substring(0,key2);
		
	}
	
	
	public  String encrypted_msg(String input) {
		
		StringBuilder encrypted=new StringBuilder(input);
		
		for(int i=0;i<encrypted.length();i++) {
			
			char currChar=encrypted.charAt(i);
			String shiftedalphabet=(i%2==0)?shiftedalphabet1:shiftedalphabet2;
			String shiftedLalphabet=(i%2==0)?Shiftedsalphabet1:Shiftedsalphabet2;
			
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
				int index=Salphabet.indexOf(currChar);
				if(index!= -1) {
					char newChar=shiftedLalphabet.charAt(index);
					encrypted.setCharAt(i, newChar);
				}
			}
		}
		
		return encrypted.toString();

	}
	
	public static void main(String[] args)throws Exception {

		int key1=13;
		int key2=17;		
		
		Scanner scan=new Scanner(new FileReader("C:/Users/Lenovo/eclipse-workspace/coursera_project/src/pac_1/other/message2.txt")); 
		String line=null;
		
		CaeserCipher enc=new CaeserCipher(key1,key2);
		System.out.println("\t	Encrypted message\n");
		
		while(scan.hasNextLine()){
			line=scan.nextLine();			
			System.out.println(enc.encrypted_msg(line));			
		}		
		scan.close();
	}
}