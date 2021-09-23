import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);


    public static int[] encoder() {

        String messageToBeEncoded = scan.nextLine();

        int[] encodedMessage = new int[messageToBeEncoded.length()];
        for (int i = 0; i < messageToBeEncoded.length(); i++) {
            char letter = messageToBeEncoded.charAt(i);
            int letterToIndex = charToIndex(letter);
            encodedMessage[i] = letterToIndex + 1;
        }
        return encodedMessage;
    }

    public static int charToIndex(char input) {

        char[] alphabet = new char[]{
                'a', 'b', 'c', 'd', 'e', 'f', 'g',
                'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u',
                'v', 'w', 'x', 'y', 'z', 'æ', 'ø',
                'å', ' '
        };

        int charIndex = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (input == alphabet[i]) {
                charIndex = i;
            }
        }
        return charIndex;
    }

    public static void formattingEncoder(int[] encodedLetters) {
        for (int i = 0; i < encodedLetters.length; i++) {
            if (i < encodedLetters.length - 1) {
                System.out.print(encodedLetters[i] + ";");
            } else {
                System.out.print(encodedLetters[i]);
            }
        }
    }


    public static char[] decoder() {

        String messageToBeDecoded = scan.next();
        char[] decodedMessage = new char[messageToBeDecoded.length()];

        for (int i = 0; i < messageToBeDecoded.length(); i++) {
            char a = messageToBeDecoded.charAt(i);
            String b = String.valueOf(a);
            int index = Integer.parseInt(b);
            char indexToLetter = indexToChar(index);
            decodedMessage[i] = indexToLetter;
        }
        /*for (int i = 0; i < messageToBeDecoded.length(); i++) {
            int index = messageToBeDecoded.charAt(i);
            char indexToLetter = indexToChar(index);
            encodedMessage[i] = indexToLetter;
        }*/
        return decodedMessage;
    }

    public static char indexToChar(int input) {

        char[] alphabet = new char[]{
                ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
                'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u',
                'v', 'w', 'x', 'y', 'z', 'æ', 'ø',
                'å'
        };

        char charIndex = alphabet[input];

        return charIndex;
    }

    public static void formattingDecoder(char[] encodedLetters) {
        for (int i = 0; i < encodedLetters.length; i++) {
            System.out.print(encodedLetters[i]);
        }
    }


    public static void main(String[] args) {

        System.out.println("Welcome to the encoder\nWhat is your message?");

        //formattingEncoder(encoder());
        //System.out.println(Arrays.toString(encoder()));

        formattingDecoder(decoder());
        //System.out.println(Arrays.toString(decoder()));

    }
}
