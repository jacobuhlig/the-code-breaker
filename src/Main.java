import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);


    public static void simpleEncoder() {
        System.out.println("Welcome to the encoder\nWhat is your message?");
        generalFormatting(formattingEncoder(encodingMechanics()));
    }

    public static int[] encodingMechanics() {
        String messageToBeEncoded = scan.nextLine();

        int[] encodedMessage = new int[messageToBeEncoded.length()];
        for (int i = 0; i < messageToBeEncoded.length(); i++) {
            char letter = messageToBeEncoded.charAt(i);
            int letterToIndex = charToIndex(letter);
            encodedMessage[i] = letterToIndex;
        }
        return encodedMessage;
    }

    public static int charToIndex(char input) {

        char[] alphabet = new char[]{
                ' ', 'a', 'b', 'c', 'd', 'e', 'f',
                'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z', 'æ',
                'ø', 'å'
        };

        int charIndex = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (input == alphabet[i]) {
                charIndex = i;
            }
        }
        return charIndex;
    }

    public static String[] formattingEncoder(int[] encodedLetters) {
        String[] encodedLettersArray = new String[((encodedLetters.length) * 2) - 1];
        int count = 0;

        for (int i = 0; i < encodedLettersArray.length; i++) {
            if (i % 2 == 0) {
                encodedLettersArray[i] = String.valueOf(encodedLetters[count]);
                count++;
            } else {
                encodedLettersArray[i] = ";";
            }
        }
        return encodedLettersArray;
    }


    public static void simpleDecoder() {
        System.out.println("Welcome to the decoder\nWhat is your message?");
        generalFormatting(decodingMechanics());
    }

    public static String[] decodingMechanics() {


        String messageToBeDecoded = scan.next();
        String[] messageToBeDecodedArray = messageToBeDecoded.split(";");

        for (int i = 0; i < messageToBeDecodedArray.length; i++) {
            int index = Integer.parseInt(messageToBeDecodedArray[i]);
            String indexToLetter = indexToString(index);
            messageToBeDecodedArray[i] = indexToLetter;
        }
        return messageToBeDecodedArray;
    }

    public static String indexToString(int input) {

        String[] alphabet = new String[]{
                " ", "a", "b", "c", "d", "e", "f", "g",
                "h", "i", "j", "k", "l", "m", "n",
                "o", "p", "q", "r", "s", "t", "u",
                "v", "w", "x", "y", "z", "æ", "ø",
                "å"
        };

        return alphabet[input];
    }

    public static void generalFormatting(String[] decodedLetters) {
        for (int i = 0; i < decodedLetters.length; i++) {
            System.out.print(decodedLetters[i]);
        }
    }


    public static void caesarCipherEncoder() {
        System.out.println("Welcome to the Caesar Cipher encoder\nWhat is your message?");
        generalFormatting(decodingMechanicsCaesarCipher(encodingMechanicsCaesarCipher()));
    }

    public static int[] encodingMechanicsCaesarCipher() {
        String messageToBeEncoded = scan.nextLine();
        int shift = 3;

        int[] encodedMessage = new int[messageToBeEncoded.length()];
        for (int i = 0; i < messageToBeEncoded.length(); i++) {
            char letter = messageToBeEncoded.charAt(i);
            int letterToIndex = charToIndexShifted(letter, shift);
            encodedMessage[i] = letterToIndex;
        }
        return encodedMessage;
    }

    public static int charToIndexShifted(char input, int shift) {

        char[] alphabet = new char[]{

                ' ', 'a', 'b', 'c', 'd', 'e', 'f',
                'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z', 'æ',
                'ø', 'å'
        };

        int startOfAlphabetIndex = 0;
        int endOfAlphabetIndex = 30;
        int charIndex = 0;

        for (int i = 0; i < alphabet.length; i++) {
            if (input == ' ') {
                charIndex = 0;
            } else if (input == alphabet[i]) {
                int iWithShift = i + shift;
                if (iWithShift >= startOfAlphabetIndex && iWithShift < endOfAlphabetIndex) {
                    charIndex = iWithShift;
                } else {
                    charIndex = iWithShift - endOfAlphabetIndex;
                }
            }
        }
        return charIndex;
    }

    public static String[] decodingMechanicsCaesarCipher(int[] messageToBeDecoded) {
        String[] messageToBeDecodedArray = new String[messageToBeDecoded.length];

        for (int i = 0; i < messageToBeDecoded.length; i++) {
            int index = messageToBeDecoded[i];
            String indexToLetter = indexToString(index);
            messageToBeDecodedArray[i] = indexToLetter;
        }
        return messageToBeDecodedArray;
    }


    public static void caesarCipherDecoder() {
        System.out.println("Welcome to the Caesar Cipher decoder\nWhat is your message?");
        generalFormatting(decodingMechanicsCaesarCipher(decodingMechanicsCaesarCipher()));
    }

    public static int[] decodingMechanicsCaesarCipher() {
        String messageToBeDecoded = scan.nextLine();
        int shift = 27;

        int[] decodedMessage = new int[messageToBeDecoded.length()];
        for (int i = 0; i < messageToBeDecoded.length(); i++) {
            char letter = messageToBeDecoded.charAt(i);
            int letterToIndex = charToIndexShifted(letter, shift);
            decodedMessage[i] = letterToIndex;
        }
        return decodedMessage;
    }


    public static void main(String[] args) {

        System.out.println("Would you like to access the simple encoder/decoder,");
        System.out.println("or would you rather go with the slightly more advanced Caesar Cipher?");
        System.out.println("Simple:\tPress 1\nCaesar:\tPress 2");

        boolean simpleOrCaesar = true;
        boolean encoderOrDecoderSimple = true;
        boolean encoderOrDecoderCaesar = true;

        while (simpleOrCaesar) {

            String choiceOfTypeOfEncoder = scan.next();

            if (choiceOfTypeOfEncoder.equals("1")) {
                System.out.println("Which would you like to use?");
                System.out.println("The encoder:\tPress 1\nThe decoder:\tPress 2");
                while (encoderOrDecoderSimple) {
                    String choiceOfEncoderOrDecoder = scan.next() + scan.nextLine();
                    if (choiceOfEncoderOrDecoder.equals("1")) {
                        simpleEncoder();
                        encoderOrDecoderSimple = false;
                    } else if (choiceOfEncoderOrDecoder.equals("2")) {
                        simpleDecoder();
                        encoderOrDecoderSimple = false;
                    } else {
                        System.out.println("Please choose 1 or 2");
                    }
                }
                simpleOrCaesar = false;
            } else if (choiceOfTypeOfEncoder.equals("2")) {
                System.out.println("Which would you like to use?");
                System.out.println("The encoder:\tPress 1\nThe decoder:\tPress 2");
                while (encoderOrDecoderCaesar) {
                    String choiceOfEncoderOrDecoder = scan.next() + scan.nextLine();
                    if (choiceOfEncoderOrDecoder.equals("1")) {
                        caesarCipherEncoder();
                        encoderOrDecoderCaesar = false;
                    } else if (choiceOfEncoderOrDecoder.equals("2")) {
                        caesarCipherDecoder();
                        encoderOrDecoderCaesar = false;
                    } else {
                        System.out.println("Please choose 1 or 2");
                    }
                }
                simpleOrCaesar = false;
            }

        }
    }
}
