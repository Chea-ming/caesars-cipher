package caesars.cipher;

public class CaesarsCipher {
    private static final char LETTER_A = 'a';
    private static final char LETTER_Z = 'z';
    private static final int ALPHABET_SIZE = 26;

    public String cipher(String message, int offset){
        offset %= ALPHABET_SIZE;
        char[] chars = message.toCharArray();
        offsetBy(chars, offset);
        return new String(chars);
    }

    private void offsetBy(char[] chars, int offset) {
        for(int i = 0; i < chars.length; ++i){
            if(chars[i] != ' '){
                chars[i] = offsetChar(chars[i], offset, LETTER_A, LETTER_Z);
            }
        }
    }

    private char offsetChar(char aChar, int offset, char letterA, char letterZ) {
        aChar += offset;
        if(aChar < letterA){
            return (char) (aChar += ALPHABET_SIZE);
        }
        if(aChar > letterZ){
            return (char) (aChar -= ALPHABET_SIZE);
        }
        return aChar;
    }


}
