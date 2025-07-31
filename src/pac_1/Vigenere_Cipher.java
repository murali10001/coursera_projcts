package pac_1;

import java.io.FileReader;
import java.util.Scanner;

public class Vigenere_Cipher {

    
    public  String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        int keyIndex = 0;
        int keyLength = key.length();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            char keyChar = key.charAt(keyIndex % keyLength);
            if (Character.isLetter(ch)) {
                boolean isUpper = Character.isUpperCase(ch);
                char base = isUpper ? 'A' : 'a';
                int chPos = ch - base;
                int keyPos = Character.toLowerCase(keyChar) - 'a';
                char encryptedChar = (char) ((chPos + keyPos) % 26 + base);
                result.append(encryptedChar);
                keyIndex++;
            } else {
                result.append(ch); 
            }
        }
        return result.toString();
    }

    
    public static String decrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        int keyIndex = 0;
        int keyLength = key.length();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            char keyChar = key.charAt(keyIndex % keyLength);

            if (Character.isLetter(ch)) {
                boolean isUpper = Character.isUpperCase(ch);
                char base = isUpper ? 'A' : 'a';

                int chPos = ch - base;
                int keyPos = Character.toLowerCase(keyChar) - 'a';

                char decryptedChar = (char) ((chPos - keyPos + 26) % 26 + base);
                result.append(decryptedChar);

                keyIndex++;
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    
    public static void main(String[] args){
    	try {																					
    	
	    	Scanner scan=new Scanner(new FileReader("C:/Users/manis/eclipse-workspace/coursera_project/src/pac_1/other/message2.txt"));
			String line=null;
			String key = "Key";
			Vigenere_Cipher enc=new Vigenere_Cipher();
			System.out.println("\t	Encrypted message\n");		
			while(scan.hasNextLine()){
				line=scan.nextLine();
				System.out.println(enc.encrypt(line,key));
			}		
			scan.close();
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }
}
