package pac_1;

public class Vigenere_Cipher {

    
    public static String encrypt(String text, String key) {
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

    public static void main(String[] args) {
        String plaintext = "Hello, World!";
        String key = "KeyKeyKeyKey";

        String encrypted = encrypt(plaintext, key);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted: " + decrypted);
    }
}
